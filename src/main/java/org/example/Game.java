package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    Screen screen;
    public Game (Screen screen) {
        this.screen = screen;
    }

    public void gameLoop(Map map, Player player, LoadScreen loadScreen) {

        try {
            map.loadMap();
        } catch (IOException e) {
            System.out.println(e.getMessage()); //IOException is a CLASS, and e is an instance of the class
            System.out.println("Error loading Map");
        }
        MovePlayer movePlayer = new MovePlayer(screen, player, map);
        while(true){
            //map.clearScreen(); doesnt work

            screen.doResizeIfNecessary();

            movePlayer.changeMap();
            Character[][] mapLayer = map.getLayer();
            Character[][] playerLayer = player.getLayer();
            Character[][] loadLayer = loadScreen.getLayer();

            List<Character[][]> combinedLayers = new ArrayList<Character[][]>();
            combinedLayers.add(mapLayer);
            combinedLayers.add(playerLayer);
            //if(atLoadScreen)
            //{
                combinedLayers.add(loadLayer);
            //}
            Character[][] buffer = this.compositeLayers(combinedLayers);
            this.printScreenBuffer(buffer);

        }
    }

    public void userInput(){
        Scanner input = new Scanner(System.in);

    }

    public Character[][] compositeLayers(List<Character[][]> layers){
        Character[][] buffer = new Character[15][41];
        for (Character[][] layer : layers) { //loops through layers List
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 41; j++) {
                    if (layer[i][j] == null) {
                        continue;
                    }
                    buffer[i][j] = layer[i][j];
                }
            }
        }
        return buffer;
    }

    public void printScreenBuffer(Character[][] buffer) {
        TextGraphics textGraphics = screen.newTextGraphics();

        screen.clear();
        for (int x = 0; x < buffer.length; x++) {
            Character[] row = buffer[x];
            for (int y = 0; y < row.length; y++) {
                textGraphics.putString(x, y, row[y].toString());
            }

        }
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
