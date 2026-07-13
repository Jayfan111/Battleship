package core;

import java.util.ArrayList;
import java.util.List;

public class Grid {
//    7*7 (0-6)
    private  List<Boat> Boats;

    public void setBoats(List<Boat> boats) {
        Boats = boats;
    }
    public  List<Boat> getBoats(){
        return Boats;
    }
    public int getRemainingships(List<Boat> boats){
        int res = 0;
        for(Boat b: boats){
            if(!b.isSunk()) res++;
        }
        return res;
    }
    public List<Point> randomSet(){
        int XorY = (int)(Math.random() * 2);
        List<Point> res = new ArrayList<>();
        int x = (int)(Math.random() * 5);
        int y = (int)(Math.random() * 5);
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
}
