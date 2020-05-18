package com.tectonica.jonix.unify.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Helper {
    public static <U, T> List<U> createList(Iterable<T> productItems, Function<T, ? extends U> supplier) {
        List<U> list = new ArrayList<>();
        for (T item : productItems) {
            list.add(supplier.apply(item));
        }
        return list;
    }
}
