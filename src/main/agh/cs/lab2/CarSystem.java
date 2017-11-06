package agh.cs.lab2;

public class CarSystem {
    public static void main(String args[]){
        Car car = new Car();
        MoveDirection[] moves = new OptionsParser().parse(args);
        for(int i = 0; i < args.length; i++){
            car.move(moves[i]);
        }
        System.out.println(car.toString());
    }
}