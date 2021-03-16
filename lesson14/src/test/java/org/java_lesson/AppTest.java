package org.java_lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppTest {
    private Array array;

    private static final int[][] intArray = {
            {1, 1, 4, 4, 1, 4, 4},
            {1, 1, 1, 1, 1, 1},
            {4, 4, 4, 4},
            {1, 4, 4, 1, 1, 4, 3}
    };

    private static final boolean[] booleanArray = {
            true, false, false, false
    };

    @BeforeEach
    public void init() {
        array = new Array();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckingArr")
    public void checkArr(boolean result, int[] arr) {
        Assertions.assertEquals(result, array.checkForOnesAndFours(arr));
    }

    private static Stream<Arguments> dataForCheckingArr() {
        List<Arguments> out = new ArrayList<>();

        for (int i = 0; i < booleanArray.length; i++) {
            out.add(Arguments.arguments(booleanArray[i], intArray[i]));
        }

        return out.stream();
    }
}
