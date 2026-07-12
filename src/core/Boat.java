package core;

import java.util.HashMap;
import java.util.List;

public class Boat {
//    size : 3*1
    private List<Point> location;
    private HashMap<Point, Boolean> state;
    public Boat(List<Point> location){
        this.location = location;
        this.state = new HashMap<>();
        for(Point p : location){
            state.put(p,true);
        }
    }

    public List<Point> getLocation() {
        return location;
    }
    public HashMap<Point, Boolean> getState(){
        return state;
    };
}
