package com.halestrom.ship.counter.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShipBattleAreaConverterTest {

    ShipBattleAreaConverter shipBattleAreaConverter = new ShipBattleAreaConverter();

    @Test
    void convertBattleArea_shouldReturnNull_whenInputIsEmpty() {
        int[][] actualShipBattleArea = null;

        assertThrows(IllegalArgumentException.class, () -> shipBattleAreaConverter.convertBattleArea(actualShipBattleArea));
    }

    @Test
    void convertBattleArea_shouldConvertArea_whenInputIsValid() {
        int[][] actualBattleArea = {{1, 0, 0},
            {1, 0, 0},
            {1, 0, 0}};
        int[] actualResult = shipBattleAreaConverter.convertBattleArea(actualBattleArea);

        int[] expectedResult = {1, 0, 0, 1, 0, 0, 1, 0, 0};

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void convertBattleArea_shouldConvertArea_whenAreaInInvalid() {
        int[][] actualBattleArea = {{1},
            {},
            {0, 0}};
        int[] actualResult = shipBattleAreaConverter.convertBattleArea(actualBattleArea);

        int[] expectedResult = {1, 0, 0};

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void convertBattleArea_shouldConvertArea_whenAreaContainsDifferentDigits() {
        int[][] actualBattleArea = {{1, 0, 0},
            {3, 4, 5},
            {6, 7, 8}};
        int[] actualResult = shipBattleAreaConverter.convertBattleArea(actualBattleArea);

        int[] expectedResult = {1, 0, 0, 3, 4, 5, 6, 7, 8};

        assertArrayEquals(expectedResult, actualResult);
    }


}
