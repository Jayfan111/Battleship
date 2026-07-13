package core;

import java.util.HashMap;
import java.util.List;

public class Boat {
//    size : 3*1
    private List<Point> location;
    private HashMap<Point, Boolean> state;
    private boolean isSunk;
    private int length;
    private int hitCount;
    public Boat(List<Point> location) {
        this.location = location;
        this.state = new HashMap<>();
        this.isSunk = false;
        this.length = 3;
        this.hitCount = 0;
        for (Point p : location) {
            state.put(p, true);
        }
    }

    public List<Point> getLocation() {
        return location;
    }
    public HashMap<Point, Boolean> getState(){
        return state;
    }
    public void hit(Point target){
        hitCount++;
        this.state.replace(target,false);
        if(this.hitCount >= this.length) this.isSunk = true;
    }

    public boolean isSunk() {
        return isSunk;
    }
}
