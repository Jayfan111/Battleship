import core.*;

import java.util.ArrayList;
import java.util.List;

import static core.Grid.setBoats;
import static core.Point.randomSet;

public class Game {
    static void main() {
        List<Boat> boats = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            boats.add(new Boat(randomSet()));
        }
        setBoats(boats);
    }
}
