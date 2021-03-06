package com.facebook.com.bitEncoderDecoder;

import com.facebook.bitEncoderDecoder.Stage2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Stage2Test {

    Stage2 stage2 = new Stage2();

    @Test
    public void shouldSendGivenEmptyReturnEmpty() {
        // given
        String input = "";
        String outputString = "";

        // when
        String actual = stage2.send(input);

        // then
        assertEquals(outputString, actual);
    }


    @Test
    public void shouldSendGivenStringReturnStringCoded() {
        // given
        String inputString = "aaabbbccc";

        // when
        String actual = stage2.send(inputString);
        boolean hasNoise = true;

        for (int i = 0; i < actual.length() && hasNoise; i += 3){
            char charPos0 = actual.charAt(i);
            char charPos1 = actual.charAt(i + 1);
            char charPos2 = actual.charAt(i + 2);

            if (charPos0 == charPos1) {
                if (charPos2 == charPos0) {
                    hasNoise = false;
                }
            } else {
                if ((charPos0 != charPos2) && (charPos1 != charPos2)){
                    hasNoise = false;
                }
            }
        }

        // then
        assertTrue(hasNoise);
    }

    @Test
    public void shouldSendGivenNullThrowIllegalArgumentException() {
        // given
        String input = null;

        // then
        assertThrows(IllegalArgumentException.class, () -> stage2.send(input));
    }

    @Test
    public void shouldSendGivenStringReturnTheSameLengthString() {
        // given
        String input = "xuxpiplkk";

        // when
        String actual = stage2.send(input);

        // then
        assertEquals(input.length(), actual.length());
    }

    @Test
    public void shouldInputLengthBeDivisibleBy3() {
        // given
        String input = "xuxpiplkk";

        // when
        boolean result = input.length() % 3 == 0;

        // then
        assertTrue(result);
    }

    @Test
    public void shouldOutputLengthBeDivisibleBy3(){
        // given
        String input = "aaaiiioooppp";
        int expected = input.length();

        // when
        int actual = stage2.send(input).length();

        // then
        assertEquals(expected, actual);

    }


    @Test
    public void shouldSendGivenEmptyThrowIllegalArgumentException() {
        // given
        String input = " ";

        // then
        assertThrows(IllegalArgumentException.class, () -> stage2.send(input));
    }


}
