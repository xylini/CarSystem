package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int height;
    private int width;
    List<Car> cars = new ArrayList<>();

    public RectangularMap(int height, int width){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Position position) {
        return position.larger(new Position(0,0)) && position.smaller(new Position(this.width,this.height));
    }

    public boolean isOccupied(Position position){
        if(objectAt(position) != null)
            return true;
        return false;
    }

    @Override
    public String toString(String string){

    }

    Object objectAt(Position position){
        for(Car c:cars){
            if(c.getPosition().equals(position))
                return c;
            return null;
        }
    }

}
