package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadScreen implements ScreenLayer{

    public LoadScreen() {}

    public Character[][] getLayer(){
        Character[][] layer = new Character[15][41];
        try {
            this.loadScreen(layer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return layer;
    }

    public void loadScreen(Character[][] layer) throws IOException {
        int startingRowNum = 9; //move for the display of loadScreen layer
        int startingColNum = 9;
        File file = new File("C:\\Users\\stens\\IdeaProjects\\AdventureGame\\src\\loadScreen.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        int row = 0;
        while ((st = br.readLine()) != null) {
            for (int col = 0; col < st.length(); col++) {
                layer[row+startingRowNum][col+startingColNum] = st.charAt(col);
            }
            row++;
        }
        br.close();
    }


}
