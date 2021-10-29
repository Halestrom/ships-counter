package com.halestrom.ship.counter.service;

public class ShipBattleAreaConverter {

    public int[] convertBattleArea(int[][] shipBattleArea) {

        if (shipBattleArea == null) {
            throw new IllegalArgumentException();
        }

        int[] convertedShipBattleArea = new int[shipBattleArea.length * shipBattleArea[0].length];
        int convertedBattleAreaIterator = 0;
        for (int x = 0; x < shipBattleArea.length; x++) {
            for (int y = 0; y < shipBattleArea[x].length; y++) {

                convertedShipBattleArea[convertedBattleAreaIterator] = shipBattleArea[x][y];
                convertedBattleAreaIterator++;
            }
        }
        return convertedShipBattleArea;
    }

}
