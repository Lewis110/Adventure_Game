package org.example;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        int input;



        Map map = new Map();
        Game game = new Game();
        Player player = new Player();
        LoadScreen loadScreen = new LoadScreen();

        game.gameLoop(map, player, loadScreen);
        //map.printMap();
        map.saveMap();


    }
}
