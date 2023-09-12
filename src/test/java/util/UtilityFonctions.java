package util;

import org.junit.jupiter.api.Assertions;

public class UtilityFonctions {
    public <T> void assertEquals(T expected, T actual){
        Assertions.assertEquals(expected, actual);
    }
}
