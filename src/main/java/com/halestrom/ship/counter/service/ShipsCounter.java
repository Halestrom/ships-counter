package com.halestrom.ship.counter.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShipsCounter {

    public int countShips(int[][] shipBattleArea) {
        validateBattleArea(shipBattleArea);

        ShipBattleAreaConverter shipBattleAreaConverter = new ShipBattleAreaConverter();
        int[] convertedBattleArea = shipBattleAreaConverter.convertBattleArea(shipBattleArea);
        int battleAreaRowLength = shipBattleArea[0].length;

        return countShips(convertedBattleArea, battleAreaRowLength);
    }

    public int countShips(int[] shipBattleArea, int battleAreaRowLength) {
        validateBattleArea(shipBattleArea, battleAreaRowLength);

        int shipCounter = 0;
        for (int areaCellIndex = 0; areaCellIndex < shipBattleArea.length; areaCellIndex++) {
            if (isCellShip(areaCellIndex, shipBattleArea)) {
                shipCounter++;
                deleteShip(areaCellIndex, shipBattleArea, battleAreaRowLength);
            }
        }
        return shipCounter;

    }

    private void validateBattleArea(int[][] shipBattleArea) {
        long lengths = Arrays.stream(shipBattleArea).mapToInt(s -> s.length).distinct().count();
        if (lengths != 1L) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBattleArea(int[] shipBattleArea, int battleAreaRowLength) {
        if (shipBattleArea.length % battleAreaRowLength != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void deleteShip(int ShipHeadCellIndex, int[] shipBattleArea, int battleAreaRowLength) {
        List<Integer> shipBodyCellIndexes = new LinkedList<>();
        shipBodyCellIndexes.add(ShipHeadCellIndex);
        for (int i = 0; i < shipBodyCellIndexes.size(); i++) {
            int shipCellIndex = shipBodyCellIndexes.get(i);

            int rightCellIndex = shipCellIndex + 1;
            int leftCellIndex = shipCellIndex - 1;
            int lowerCellIndex = shipCellIndex + battleAreaRowLength;
            int higherCellIndex = shipCellIndex - battleAreaRowLength;

            addCellToBodyIfShip(rightCellIndex, shipBattleArea, shipBodyCellIndexes);
            addCellToBodyIfShip(leftCellIndex, shipBattleArea, shipBodyCellIndexes);
            addCellToBodyIfShip(lowerCellIndex, shipBattleArea, shipBodyCellIndexes);
            addCellToBodyIfShip(higherCellIndex, shipBattleArea, shipBodyCellIndexes);

            shipBattleArea[shipCellIndex] = 0;
        }
    }

    private void addCellToBodyIfShip(int cellIndex, int[] shipBattleArea, List<Integer> shipBodyCellIndexes) {
        if (isCellShip(cellIndex, shipBattleArea)) {
            shipBodyCellIndexes.add(cellIndex);
        }
    }

    private boolean isCellShip(int cellIndex, int[] shipBattleArea) {
        return cellIndex >= 0 && cellIndex < shipBattleArea.length && shipBattleArea[cellIndex] == 1;
    }

}
