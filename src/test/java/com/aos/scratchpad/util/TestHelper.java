package com.aos.scratchpad.util;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class TestHelper {


    static Stream<Arguments> longestPalindromeArgumentProvider() {
        return Stream.of(
                Arguments.of("ababa", "ababa"),
                Arguments.of("babad", "bab"),
                Arguments.of("a", "a"),
                Arguments.of("ac", "a"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("aacabdkacaa", "aca"),
                Arguments.of("", "")
        );
    }

    static Stream<Arguments> zigzagConversionArgumentProvider() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("PAYPALISHIRING", 2, "PYAIHRNAPLSIIG"),
                Arguments.of("PAYPAL", 1, "PAYPAL"),
                Arguments.of("A", 1, "A"),
                Arguments.of("A", 2, "A")
        );
    }

    static Stream<Arguments> reverseIntegerArgumentProvider() {
        return Stream.of(
                Arguments.of(12, 21),
                Arguments.of(0, 0),
                Arguments.of(1234, 4321),
                Arguments.of(-1234, -4321),
                Arguments.of(2147483647, 0),
                Arguments.of(-2147483648, 0),
                Arguments.of(1534236469, 0)
        );
    }


}
