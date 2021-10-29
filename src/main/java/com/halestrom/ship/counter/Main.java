package com.halestrom.ship.counter;

import com.halestrom.ship.counter.service.ShipsCounter;

public class Main {

    public static void main(String[] args) {
        int[][] ships = {{0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };


        ShipsCounter shipsCounter = new ShipsCounter();
        System.out.println(shipsCounter.countShips(ships));
    }

}
