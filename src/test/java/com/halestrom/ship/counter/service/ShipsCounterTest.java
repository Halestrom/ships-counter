package com.halestrom.ship.counter.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ShipsCounterTest {

    private final ShipsCounter shipsCounter = new ShipsCounter();

    @Test
    void countShips_shouldCountShips_whenAreaIsOneCell() {
        int[][] actualBattleArea = {{1}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldCountShips_whenAreaIsBiggerThanExpected() {
        int[][] actualBattleArea = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldThrowException_whenInputMatrixIsInvalid() {
        int[][] actualBattleArea = {{1},
            {},
            {,},
            {0, 0, 1}};

        assertThrows(IllegalArgumentException.class, () -> shipsCounter.countShips(actualBattleArea));
    }

    @Test
    void countShips_shouldReturnZero_whenAreaIsEmpty() {
        int[][] actualBattleArea = {{0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldReturnOne_whenAreaIsFull() {
        int[][] actualBattleArea = {{1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldCountShips_whenShipIsInOneRow() {
        int[][] actualBattleArea = {{1, 1, 1},
            {0, 0, 0},
            {0, 0, 0}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldCountShips_whenShipIsInOneColumn() {
        int[][] actualBattleArea = {{1, 0, 0},
            {1, 0, 0},
            {1, 0, 0}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldCountShips_whenShipsAreOnDiagonal() {
        int[][] actualBattleArea = {{1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldCountShips_whenShipIsOnSquare() {
        int[][] actualBattleArea = {{1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }


    @Test
    void countShips_shouldCountShips_whenShipHasAbnormalForm() {
        int[][] actualBattleArea = {{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldCountShips_whenShipIsCircled() {
        int[][] actualBattleArea = {{1, 1, 1, 1,},
            {1, 0, 0, 1},
            {1, 1, 1, 1}};
        int actualResult = shipsCounter.countShips(actualBattleArea);

        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countShips_shouldThrowException_whenInputArrayIsInvalid() {
        int[] actualBattleArea = {0, 0, 1};
        int battleAreaRowLength = 5;

        assertThrows(IllegalArgumentException.class, () -> shipsCounter.countShips(actualBattleArea, battleAreaRowLength));
    }

    @Test
    void countShips_shouldCountShips_whenAreaContainsDifferentNumbers() {
        int[] actualBattleArea = {1, 2, 3, 1, 5, 1, 7, 8, 9};
        int actualBattleAreaRowLength = 3;
        int actualResult = shipsCounter.countShips(actualBattleArea, actualBattleAreaRowLength);

        int expectedResult = 2;

        assertEquals(expectedResult, actualResult);
    }

}
