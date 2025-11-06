package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RandomStorage {

    /*private int randomMove;

    public  LoadScreen() {
    }
    @Override
    public void loadMap() throws IOException {
        int rowNum = 0;
        File file = new File("C:\\Users\\stens\\IdeaProjects\\AdventureGame\\src\\DemoLoadMap.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            for (int j = 0; j < 41; j++) {
                this.map[rowNum][j] = st.charAt(j);
            }
            rowNum++;
        }
        br.close();
    }


    public int randomMove() {
        this.randomMove = (int)(Math.random() * 4);
        return this.randomMove;
    }

    public MOVES convertIntToMove(){
        return switch (this.randomMove) {
            case 0 -> MOVES.UP;
            case 1 -> MOVES.DOWN;
            case 2 -> MOVES.LEFT;
            case 3 -> MOVES.RIGHT;
            default -> null;
        };
    }

    public void changeMap(Map newMap) {
        // Use instant input instead of scanner
        this.randomMove = randomMove();
        MOVES userMove = this.convertIntToMove();

        Point point = newMap.searchForCharacter();
        if (point == null) {
            System.out.println("Player character (@) not found on map!");
            return;
        }

        // Clear current player position
        newMap.alterCoordinates(point.x, point.y, '.');
        // Calculate new position based on move
        if (userMove == MOVES.UP) {
            point.x--; // moves up 1 row
        } else if (userMove == MOVES.DOWN) {
            point.x++; // moves down 1 row
        } else if (userMove == MOVES.LEFT) {
            point.y--; // moves left 1 column
        } else if (userMove == MOVES.RIGHT) {
            point.y++; // moves right 1 column
        }

        // Place player at new position
        newMap.alterCoordinates(point.x, point.y, '@');*/
}
