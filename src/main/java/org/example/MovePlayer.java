package org.example;

import java.io.IOException;
import com.googlecode.lanterna.input.KeyStroke; //for real-time input into computer without prompt
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class MovePlayer {
    private Screen screen;
    private Player player;
    private Map map;

    public MovePlayer(Screen screen, Player player, Map map) {
        this.map = map;
        this.screen = screen;
        this.player = player;
    }

    public boolean isPositionWalkable (Point point) {
        if (point.x < 0 || point.x > 15 || point.y < 0 || point.y > 41)
            return false;

        if (map.map[point.x][point.y] != '.'){
            return false;
        }

        return true;
    }

    // Instant input method without needing Enter
    public MOVES getInstantInput() {
        try {
            System.out.print("Enter move (WASD): ");

            // Read single character without waiting for Enter
            KeyStroke input = screen.readInput();

            if (input.getKeyType() == KeyType.Character) {
                return convertCharToMove(input.getCharacter());
            }

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

    public void changeMap() {
        // Use instant input instead of scanner
        MOVES userMove = getInstantInput();

        if (userMove == MOVES.QUIT) {
            System.out.println("Game ended by user.");
            System.exit(0);
        }

        if (userMove == null) {
            System.out.println("Invalid move! Use W, A, S, or D.");
            return;
        }

        Point point = new Point(player.getX(), player.getY()); //this lets us check if position we want to move to is valid

        // Calculate new position based on move
        if (userMove == MOVES.LEFT) {
            point.x--; // moves up 1 row
        } else if (userMove == MOVES.RIGHT) {
            point.x++; // moves down 1 row
        } else if (userMove == MOVES.UP) {
            point.y--; // moves left 1 column
        } else if (userMove == MOVES.DOWN) {
            point.y++; // moves right 1 column
        }

        if (isPositionWalkable(point))
        {
            player.coordinates = point;
        }


        return;
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

