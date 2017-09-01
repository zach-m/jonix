package com.tectonica.jonix;

import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfOnixDataCompositeWithKey
    <C extends OnixDataCompositeWithKey<S, K>, S extends JonixKeyedStruct<K>, K extends Enum<K>>
    extends ListOfOnixDataComposite<C, S> {
    private static final long serialVersionUID = 1L;

    public Optional<C> find(K structKey) {
        for (C item : this) {
            if (item.structKey() == structKey) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<S> findAsStruct(K structKey) {
        return find(structKey).map(i -> i.asStruct());
    }

    public List<C> findAll(Set<K> structKeys) {
        List<C> matches = new ArrayList<>();
        forEach(item -> {
            if (structKeys == null || structKeys.contains(item.structKey())) {
                matches.add(item);
            }
        });
        return matches;
    }

    @SuppressWarnings("unchecked")
    public List<C> findAll(K... structKeys) {
        return findAll(new HashSet<>(Arrays.asList(structKeys)));
    }

    public List<S> findAllAsStructs(Set<K> structKeys) {
        return findAll(structKeys).stream().map(i -> i.asStruct()).collect(Collectors.toList());
    }

    private static ListOfOnixDataCompositeWithKey<?, ?, ?> EMPTY = new ListOfOnixDataCompositeWithKey<>();

    @SuppressWarnings("unchecked")
    public static <C extends OnixDataCompositeWithKey<S, K>, S extends JonixKeyedStruct<K>, K extends Enum<K>>
        ListOfOnixDataCompositeWithKey<C, S, K> emptyKeyed() {
        return (ListOfOnixDataCompositeWithKey<C, S, K>) EMPTY;
    }
}