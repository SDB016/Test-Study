package com.testStudy.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ThrowableTest {

    @Test
    @DisplayName("Exception 테스트 - assertThat")
    void exception_test() {
        Throwable throwable = catchThrowable(() -> {
            throw new IllegalAccessError("exception");
        });

        assertThat(throwable).isInstanceOf(IllegalAccessError.class);
        assertThat(throwable).hasMessage("exception");
    }

    @Test
    @DisplayName("Exception 테스트 - assertThatThrownBy")
    void exception_thrownBy_test() {
        assertThatThrownBy(() -> {throw new IllegalAccessError("exception");})
                .isInstanceOf(IllegalAccessError.class)
                .hasMessage("exception");

    }
}
