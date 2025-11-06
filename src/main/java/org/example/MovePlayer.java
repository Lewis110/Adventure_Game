package org.example;

import java.io.IOException;

public class MovePlayer {
    private Character[][] layeredMap;
    public MovePlayer(Character[][] layeredMap) {
        this.layeredMap = layeredMap;
    }
    public Point searchForCharacter() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 41; j++) {
                if (this.layeredMap[i][j] == '@') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void alterCoordinates(int x, int y, char key) {
        this.layeredMap[x][y] = key;
    }

    // Instant input method without needing Enter
    public MOVES getInstantInput() {
        try {
            System.out.print("Enter move (WASD): ");

            // Read single character without waiting for Enter
            int input = System.in.read();

            // Clear the input buffer of any remaining characters (like newline)
            while (System.in.available() > 0) {
                System.in.read();
            }

            return convertCharToMove((char) input);

        } catch (IOException e) {
            System.out.println("Input error!");
        }
        return null;
    }



    private MOVES convertCharToMove(char input) {
        return switch (Character.toLowerCase(input)) {
            case 'w' -> MOVES.UP;
            case 's' -> MOVES.DOWN;
            case 'a' -> MOVES.LEFT;
            case 'd' -> MOVES.RIGHT;
            case 'q' -> MOVES.QUIT;
            default -> null;
        };
    }

    public Character[][] changeMap() {
        // Use instant input instead of scanner
        MOVES userMove = getInstantInput();

        if (userMove == MOVES.QUIT) {
            System.out.println("Game ended by user.");
            System.exit(0);
        }

        if (userMove == null) {
            System.out.println("Invalid move! Use W, A, S, or D.");
            return null;
        }

        Point point = this.searchForCharacter();
        if (point == null) {
            System.out.println("Player character (@) not found on map!");
            return null;
        }

        // Clear current player position
        this.alterCoordinates(point.x, point.y, '.');

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
        this.alterCoordinates(point.x, point.y, '@');

        return this.layeredMap;
    }

    public void clearScreen() {
        try {
            // Windows clear screen command
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Fallback: print multiple newlines
            System.out.print("\n".repeat(50));
        }
    }
}

