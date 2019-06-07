/*
 * Copyright (C) 2012 Zach Melamed
 *
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.external;

import com.tectonica.jonix.util.Comparators;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestComparators {

    @Test
    public void compareArray() {
        String[] a = new String[] {"a"};
        String[] ab = new String[] {"a", "b"};
        String[] ab2 = new String[] {"a", "b"};
        String[] ac = new String[] {"a", "c"};
        String[] a_b = new String[] {"a", null, "b"};
        String[] a_c = new String[] {"a", null, "c"};

        Assert.assertEquals(compare(ab, ac), -1);
        Assert.assertEquals(compare(ab, ab), 0);
        Assert.assertEquals(compare(ab, ab2), 0);
        Assert.assertEquals(compare(a, ac), -1);
        Assert.assertEquals(compare(null, a), -1);
        Assert.assertEquals(compare(a_b, ab), -1);
        Assert.assertEquals(compare(a_b, a_c), -1);
    }

    @Test
    public void compareList() {
        List<String> a = Arrays.asList("a");
        List<String> ab = Arrays.asList("a", "b");
        List<String> ab2 = Arrays.asList("a", "b");
        List<String> ac = Arrays.asList("a", "c");
        List<String> a_b = Arrays.asList("a", null, "b");
        List<String> a_c = Arrays.asList("a", null, "c");

        Assert.assertEquals(compare(ab, ac), -1);
        Assert.assertEquals(compare(ab, ab), 0);
        Assert.assertEquals(compare(ab, ab2), 0);
        Assert.assertEquals(compare(a, ac), -1);
        Assert.assertEquals(compare(null, a), -1);
        Assert.assertEquals(compare(a_b, ab), -1);
        Assert.assertEquals(compare(a_b, a_c), -1);
    }

    private int compare(String[] a, String[] b) {
        int c1 = Comparators.compareArray(a, b);
        int c2 = Comparators.compareArray(b, a);
        Assert.assertEquals(c1, -c2);
        return c1;
    }

    private int compare(List<String> a, List<String> b) {
        int c1 = Comparators.compareList(a, b);
        int c2 = Comparators.compareList(b, a);
        Assert.assertEquals(c1, -c2);
        return c1;
    }
}