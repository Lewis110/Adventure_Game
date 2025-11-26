package org.example;

import java.io.*;
import java.util.Scanner;

public class Map implements ScreenLayer {
    protected Character map[][] = new Character[210][90];
    Scanner scanner = new Scanner(System.in);

    public Map() {
    }

    public void loadMap() throws IOException {
        int rowNum = 0;
        File file = new File("C:\\Users\\stens\\IdeaProjects\\AdventureGame\\src\\DemoMap.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            for (int j = 0; j < 42; j++) {
                this.map[rowNum][j] = st.charAt(j);
            }
            rowNum++;
        }
        br.close();
    }

    public void saveMap() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("DemoMapSave.txt"));
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 42; j++) {
                    writer.write(String.valueOf(this.map[i][j]));
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Character[][] getLayer() {
        Character[][] layer = new Character[15][41];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 41; j++) {
                layer[i][j] = this.map[i][j];
            }
        }
        return layer;
    }
}



