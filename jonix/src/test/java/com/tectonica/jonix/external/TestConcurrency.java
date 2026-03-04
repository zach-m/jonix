package com.tectonica.jonix.external;

import com.tectonica.jonix.Jonix;
import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.JonixRecords;
import com.tectonica.jonix.JonixSource;
import com.tectonica.jonix.common.JPU;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestConcurrency {
    private static final File SINGLE_ONIX3 = new File("src/test/resources/samples/onix3-single.xml");

    @Test
    public void testJpuStaticCachesAreConcurrentMaps() throws Exception {
        Field f1 = JPU.class.getDeclaredField("emptyListOfOnixDataComposites");
        Field f2 = JPU.class.getDeclaredField("emptyListOfOnixDataCompositeWithKeys");
        Field f3 = JPU.class.getDeclaredField("emptyListOfOnixComposites");

        Assert.assertEquals(ConcurrentMap.class, f1.getType());
        Assert.assertEquals(ConcurrentMap.class, f2.getType());
        Assert.assertEquals(ConcurrentMap.class, f3.getType());
    }

    @Test
    public void testJonixRecordsStateUsesConcurrentPrimitives() throws Exception {
        JonixRecords records = Jonix.source(SINGLE_ONIX3);

        Field globalConfig = JonixRecords.class.getDeclaredField("globalConfig");
        Field onSourceStartEvents = JonixRecords.class.getDeclaredField("onSourceStartEvents");
        Field onSourceEndEvents = JonixRecords.class.getDeclaredField("onSourceEndEvents");
        Field skipSourceRequested = JonixRecords.class.getDeclaredField("skipSourceRequested");
        globalConfig.setAccessible(true);
        onSourceStartEvents.setAccessible(true);
        onSourceEndEvents.setAccessible(true);
        skipSourceRequested.setAccessible(true);

        Assert.assertTrue(globalConfig.get(records) instanceof ConcurrentMap);
        Assert.assertTrue(records.getConfiguration() instanceof ConcurrentMap);
        Assert.assertEquals("java.util.concurrent.CopyOnWriteArrayList",
            onSourceStartEvents.get(records).getClass().getName());
        Assert.assertEquals("java.util.concurrent.CopyOnWriteArrayList",
            onSourceEndEvents.get(records).getClass().getName());
        Assert.assertTrue(skipSourceRequested.get(records) instanceof AtomicBoolean);
    }

    @Test
    public void testJonixRecordAndSourceStoresSupportConcurrentWrites() throws Exception {
        Optional<JonixRecord> maybeRecord = Jonix.source(SINGLE_ONIX3).stream().findFirst();
        Assert.assertTrue(maybeRecord.isPresent());

        JonixRecord record = maybeRecord.get();
        JonixSource source = record.source;

        Field globalConfig = JonixRecord.class.getDeclaredField("globalConfig");
        Field sourceDict = JonixSource.class.getDeclaredField("sourceDict");
        globalConfig.setAccessible(true);
        sourceDict.setAccessible(true);

        Map<?, ?> globalMap = (Map<?, ?>) globalConfig.get(record);
        Map<?, ?> sourceMap = (Map<?, ?>) sourceDict.get(source);
        Assert.assertTrue(globalMap instanceof ConcurrentMap);
        Assert.assertTrue(sourceMap instanceof ConcurrentMap);

        int threadCount = 8;
        int iterations = 400;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(threadCount);

        for (int t = 0; t < threadCount; t++) {
            final int threadNum = t;
            executor.submit(() -> {
                try {
                    start.await();
                    for (int i = 0; i < iterations; i++) {
                        int id = threadNum * iterations + i;
                        record.store("global." + id, id);
                        source.store("source." + id, id);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }

        start.countDown();
        Assert.assertTrue(done.await(15, TimeUnit.SECONDS));
        executor.shutdownNow();
        Assert.assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));

        int expected = threadCount * iterations;
        for (int i = 0; i < expected; i += 137) {
            Assert.assertEquals(i, (int) record.retrieve("global." + i, -1));
            Assert.assertEquals(i, (int) source.retrieve("source." + i, -1));
        }

        Assert.assertTrue(((Map<?, ?>) globalConfig.get(record)).size() >= expected);
        Assert.assertTrue(((Map<?, ?>) sourceDict.get(source)).size() >= expected);
    }
}
