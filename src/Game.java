import core.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    static boolean gameOver(List<Boat> boats){
        for(Boat b : boats){
            if(!b.isSunk()) return false;
        }
        return true;
    }
    static void main() {
        System.out.println("""
                       Welcome to the Battleship Game!
                        The battlefield is a 7x7 grid.
                You have 20 shots to sink 3 enemy ships (size: 3x1).
                   Valid coordinates are rows 0-6 and columns 0-6.
                """);
        int shots = 0;
        Grid grid = new Grid();
        List<Boat> boats = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            boats.add(new Boat(grid.randomSet()));
        }
        grid.setBoats(boats);
        while(!gameOver(grid.getBoats()) && shots <= 20) {
            boolean over = false;
            System.out.println("Enter target coordinate");
            Scanner sc = new Scanner(System.in);
            if(!sc.hasNextInt()){
                System.out.println("Please enter two valid integers.");
                continue;
            }
            int x = sc.nextInt();
            if(!sc.hasNextInt()){
                System.out.println("Please enter two valid integers.");
                continue;
            }
            int y = sc.nextInt();
            if(x < 0 || x > 6 || y < 0 || y > 6){
                System.out.println("Out of range (0-6). Enter again.");
                continue;
            }
            else shots++;
            Point target = new Point(x, y);
            for (Boat b : grid.getBoats()) {
                if (b.getState().containsKey(target)) {
                    if (b.getState().get(target)) {
                        b.hit(target);
                        System.out.println("Hit!");
                    }
                    else{
                        System.out.println("Miss!");
                    }
                    over = true;
                    break;
                }
            }
            if(!over) System.out.println("Miss!");
        }
    }
}
