package com.example.devopslab1.utils;

import javafx.beans.value.ChangeListener;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

@RequiredArgsConstructor
public class AllFieldsChecker {
    private final List<Boolean> conditions = new ArrayList<>();
    private final BiConsumer<String, Boolean> actionWithCheckResult;

    private static boolean all(List<Boolean> conditions) {
        for (Boolean condition : conditions) {
            if (!condition) {
                return false;
            }
        }
        return true;
    }

    public <T> ChangeListener<T> newListener(Function<T, String> warningChecker) {
        int index = conditions.size();
        conditions.add(false);

        return (obj, oldValue, newValue) -> {
            String result = warningChecker.apply(newValue);
            conditions.set(index, result.isBlank());
            actionWithCheckResult.accept(result, all(conditions));
        };
    }

}
