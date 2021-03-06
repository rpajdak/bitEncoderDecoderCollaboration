package com.facebook.com.bitEncoderDecoder;

import com.facebook.bitEncoderDecoder.Stage3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stage3Test {

    Stage3 stage3 = new Stage3();

    @DisplayName("Should encode() work with correct inputs")
    @ParameterizedTest
    @MethodSource("encodeArgumentsProvider")
    void encode(String expected, String given){
        assertEquals(expected, stage3.decode(given));
    }
    private static Stream<Arguments> encodeArgumentsProvider(){
        return Stream.of(
                Arguments.of("abc", "aalbobxcc"),
                Arguments.of("test", ";tteXessSTtt"),
                Arguments.of("k12", "Lkk1102_2")
        );
    }

}
