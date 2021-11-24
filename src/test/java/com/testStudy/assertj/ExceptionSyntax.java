package com.testStudy.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class ExceptionSyntax {
    @Test
    @DisplayName("NullPoint 예외 처리")
    void nullPoint() {
        assertThatNullPointerException().isThrownBy(() -> {
                    throw new NullPointerException("null!");
                }).withMessage("%s!", "null")
                .withMessageContaining("nu")
                .withNoCause();
    }

    @Test
    @DisplayName("IllegalArgument 예외 처리")
    void illegalArgs() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    throw new IllegalArgumentException("Illegal args!");
                }).withMessage("%s!", "Illegal args")
                .withMessageContaining("Il")
                .withNoCause();
    }

    @Test
    @DisplayName("IllegalState 예외 처리")
    void illegalState() {
        assertThatIllegalStateException().isThrownBy(() -> {
                    throw new IllegalStateException("Illegal state!");
                }).withMessage("%s!", "Illegal state")
                .withMessageContaining("Il")
                .withNoCause();
    }

    @Test
    @DisplayName("IO 예외 처리")
    void io() {
        assertThatIOException().isThrownBy(() -> {
                    throw new IOException("IO!");
                }).withMessage("%s!", "IO")
                .withMessageContaining("I")
                .withNoCause();
    }
}
