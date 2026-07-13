import core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SinglePlayerMode{
     static boolean gameOver(List<Boat> boats){
        for(Boat b : boats){
            if(!b.isSunk()) return false;
        }
        return true;
    }
    static boolean isOverlap(List<Point> newBoat,List<Boat> existingBoats){
         for(Boat b: existingBoats){
             for(Point p: newBoat) {
                 if (b.getLocation().contains(p)) return true;
             }
         }
         return false;
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
        while(boats.size() < 3){
            List<Point> newBoat = grid.randomSet();
            if(!isOverlap(newBoat,boats)) boats.add(new Boat(newBoat));
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
                        System.out.println("Already Hit!");
                    }
                    over = true;
                    break;
                }
            }
            if(!over) System.out.println("Miss!");
        }
        if(gameOver(grid.getBoats())){
            System.out.println("""
                        Congratulations! You sank all 3 enemy ships!
                        Total shots used : """ + shots);
        }
        if(!gameOver(grid.getBoats()) && shots > 20){
            System.out.println("Game Over! You ran out of ammo.\n\t" +
                    grid.getRemainingships(grid.getBoats()) +" ships remaining.");
        }
    }
}
