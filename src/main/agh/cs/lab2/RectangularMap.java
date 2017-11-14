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

    @Override
    public boolean place(Car car) {
        if(isOccupied(car.getPosition()) || !canMoveTo(car.getPosition())) return false;
        else cars.add(car);
        return true;
        //else if (cars.add(car)) return true;
        //return false;
    }

    public boolean isOccupied(Position position){
        if(objectAt(position) != null)
            return true;
        return false;
    }

    @Override
    public String toString(){
        MapVisualizer map = new MapVisualizer();
        return map.dump(this, new Position(0,0), new Position(this.width, this.height));
    }

    public Object objectAt(Position position){
        for(Car c:cars){
            if(c.getPosition().equals(position))
                return c;
        }
        return null;
    }

    public void run(MoveDirection[] direction){
        for(int i = 0; i < direction.length; i++){
            Car temp = cars.get(i % cars.size());
            temp.move(direction[i]);
            cars.set(i % cars.size(), temp);
        }

    }



}
