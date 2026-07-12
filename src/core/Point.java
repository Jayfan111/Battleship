package core;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static List<Point> randomSet(){
        int XorY = (int)(Math.random() * 2);
        int x = 3+(int)(Math.random() * 4);
        int y = 3+(int)(Math.random() * 4);
        List<Point> res = new ArrayList<>();
        if(XorY == 0){
            for(int i = 0; i < 3; i++){
                res.add(new Point(x,y++));
            }
        }
        if(XorY == 1){
            for(int i = 0; i < 3; i++){
                res.add(new Point(x++,y));
            }
        }
        return res;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
