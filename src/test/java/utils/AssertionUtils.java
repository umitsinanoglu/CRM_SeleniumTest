// src/test/java/utils/AssertionUtils.java
package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

public class AssertionUtils {

    public static void assertTextEquals(String expected, String actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }

    public static void assertTrue(boolean condition, String message) {
        Assertions.assertTrue(condition, message);
    }

    public static void assertAll(Executable... executables) {
        Assertions.assertAll(executables);
    }
}
