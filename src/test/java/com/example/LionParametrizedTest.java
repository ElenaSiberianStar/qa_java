package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionParametrizedTest {

    @Mock
    private Feline feline;

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testLionConstructorValidSex(String sex) {
        assertDoesNotThrow(() -> {
            Lion lion = new Lion(sex, feline);
            if ("Самец".equals(sex)) {
                assertTrue(lion.doesHaveMane());
            } else {
                assertFalse(lion.doesHaveMane());
            }
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестный", "", "Мальчик", "Девочка"})
    void testLionConstructorInvalidSexThrowsException(String invalidSex) {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidSex, feline);
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
