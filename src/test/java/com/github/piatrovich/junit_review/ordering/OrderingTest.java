package com.github.piatrovich.junit_review.ordering;

import org.junit.jupiter.api.*;

@DisplayName("Ordering Cases")
public class OrderingTest {
    private String str;
    private String copy;

    @Test
    @DisplayName("Test #1")
    @Order(1)
    void test1 (TestInfo testInfo) {
        Assertions.assertNull(str, "{str} must be null");
        str = "literal";
    }

    @Test
    @DisplayName("Test #2")
    @Order(3)
    void test2 (TestInfo testInfo) {
        Assertions.assertEquals(str, copy);
    }

    @Test
    @DisplayName("Test #3")
    @Order(2)
    @Disabled("Test lifecycle set per_method")
    void test3 (TestInfo testInfo) {
        Assertions.assertNotNull(str, "{str} must be not null");
        Assertions.assertNotEquals(str.isEmpty(), "{str} must be not empty");
        Assertions.assertEquals(str, "literal");
        copy = str;
    }

}
