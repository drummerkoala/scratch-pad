package com.aos.scratchpad.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.stream.Stream;

public class TestHelper {


    static Stream<Arguments> longestPalindromeArgumentProvider() {
        return Stream.of(
                Arguments.of("ababa", "ababa"), // null strings should be considered blank
                Arguments.of("babad", "bab"),
                Arguments.of("a", "a"),
                Arguments.of("ac", "a"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("aacabdkacaa", "aca"),
                Arguments.of("", "")
        );
    }


}
