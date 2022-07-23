package com.example.java.types;

import com.example.java.guard.Guard;

import java.util.TreeMap;

public enum QueteletType {
    EXHAUSTION,
    REDUCED,
    NORMAL,
    ELEVATED,
    OBESITY;

    public static QueteletType getQueteletTypeByIndexAndSexType(Long index, SexType sexType) {
        Guard.that(index > 0
                && index < 1000, "index.out.of.range", "Индекс должен быть в диапазоне 0 - 1000.");
        var queteletIndexMap = new TreeMap<Long, QueteletType>();
        if (sexType == SexType.MALE) {
            queteletIndexMap.put(1L, QueteletType.EXHAUSTION);
            queteletIndexMap.put(321L, QueteletType.REDUCED);
            queteletIndexMap.put(350L, QueteletType.NORMAL);
            queteletIndexMap.put(431L, QueteletType.ELEVATED);
            queteletIndexMap.put(451L, QueteletType.OBESITY);
        } else {
            queteletIndexMap.put(1L, QueteletType.EXHAUSTION);
            queteletIndexMap.put(331L, QueteletType.REDUCED);
            queteletIndexMap.put(340L, QueteletType.NORMAL);
            queteletIndexMap.put(421L, QueteletType.ELEVATED);
            queteletIndexMap.put(441L, QueteletType.OBESITY);
        }
        return queteletIndexMap.floorEntry(index).getValue();
    }
}
