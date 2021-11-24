package com.testStudy.assumption;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTest {

    @Test
    @DisplayName("MacOs에서 실행")
    void test_Mac() {
        assumeTrue(System.getProperty("os.name").startsWith("Mac"));
        assertEquals(3, 3);
    }

    @Test
    @DisplayName("Window에서 실행")
    void test_window() {
        assumeTrue(System.getProperty("os.name").startsWith("Window"));
        assertEquals(3, 3);
    }

    @Test
    @DisplayName("조건부에서 실행")
    void test_condition() {
        String osName = System.getProperty("os.name");
        assumingThat(
                osName.startsWith("Mac"),
                () -> assertNotEquals(1, 2)
        );
        assertEquals(3, 3);
    }
}
