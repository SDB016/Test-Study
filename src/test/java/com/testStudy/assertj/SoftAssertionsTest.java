package com.testStudy.assertj;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SoftAssertionsTest {

    int num = 10, num2 = 20;
    String str = "abc";

    @Test
    @DisplayName("Soft assertions 테스트")
    void soft_assertions_test() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(num).as("테스트1").isLessThan(30);
        softAssertions.assertThat(num2).as("테스트2").isLessThan(5);
        softAssertions.assertThat(str).as("테스트3").contains("b");
        softAssertions.assertThat(str).as("테스트4").endsWith("a");
        softAssertions.assertAll();
    }

}
