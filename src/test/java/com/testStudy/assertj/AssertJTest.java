package com.testStudy.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class AssertJTest {

    private String testString = "Hello world!";

    @Test
    @DisplayName("assertj 체이닝 테스트 - String")
    void chaining_test_string() {
        assertThat(testString) //testString 에 대한 검증
                .isNotEmpty()
                .contains("Hello")
                .doesNotContain("not")
                .startsWith("He")
                .endsWith("!")
                .isNotEqualTo("Hi world!")
                .isEqualTo("Hello world!");
    }

    @Test
    @DisplayName("assertj 체이닝 테스트 - Number")
    void chaining_test_number() {
        assertThat(9.99d) // 9.99에 대한 검증
                .isPositive()
                .isGreaterThan(9)
                .isLessThan(10)
                .isEqualTo(9, offset(1d)) // offset 1 기준 9와 동일
                .isEqualTo(9.9, offset(0.1d)) // offset 0.1 기준 9.9와 동일
                .isEqualTo(9.99);
    }
}
