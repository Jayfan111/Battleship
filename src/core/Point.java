package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
