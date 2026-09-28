package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    void testGetKittensDefault() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void testGetKittensWithParam(int kittensCount) {
        int actualKittens = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actualKittens);
    }
}
