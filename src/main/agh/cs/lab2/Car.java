package agh.cs.lab2;

import static agh.cs.lab2.MapDirection.North;

public class Car {
    private Position position;
    private MapDirection direction;
    private IWorldMap map;
    private Position newPos;
   // private Position minPos = new Position(0, 0);
   // private Position maxPos = new Position(4, 4);

    public Car(IWorldMap map){
        this.direction = MapDirection.North;
        this.position = new Position(2,2);
        this.map = map;
        this.newPos = this.position;
    }

    public Car(IWorldMap map, int x, int y){
        this.direction = MapDirection.North;
        this.position = new Position(x,y);
        this.map = map;
        this.newPos = this.position;
    }

    @Override
    public String toString() {
        return this.direction.toString();
    }

    //public boolean canMoveTo(Position newPos) {
    //    return newPos.larger(this.minPos) && newPos.smaller(this.maxPos);
    //}

    public Position getPosition() {
        return position;
    }

    private Position makeMove(MoveDirection direction, MapDirection mapDir) {
        switch (direction) {
            case Forward: {
                switch (mapDir) {
                    case North:
                        return this.newPos.add(new Position(0, 1));

                    case South:
                        return this.newPos.add(new Position(0,-1));

                    case West:
                        return this.newPos.add(new Position(-1, 0));

                    case East:
                        return this.newPos.add(new Position(1, 0));

                }
            }
            case Backward: {
                switch (mapDir) {
                    case North:
                        return this.newPos.add(new Position(0, -1));

                    case South:
                        return this.newPos.add(new Position(0, 1));

                    case West:
                        return this.newPos.add(new Position(1, 0));

                    case East:
                        return this.newPos.add(new Position(-1, 0));
                }
            }
            case Right:
                break;
            case Left:
                break;
        }
        return null;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case Left: {
                this.direction = this.direction.previous();
                break;
            }


            case Right: {
                this.direction = this.direction.next();
                break;
            }


            case Forward: {
                this.newPos = makeMove(direction, this.direction);
                if (map.canMoveTo(this.newPos)) this.position = new Position(0,0).add(this.newPos);
                //else this.newPos = makeMove(MoveDirection.Backward, this.direction);
                else this.newPos = this.position;
                break;
            }


            case Backward: {
                this.newPos = makeMove(direction, this.direction);
                if (map.canMoveTo(this.newPos)) this.position = new Position(0,0).add(this.newPos);
                //else this.newPos = makeMove(MoveDirection.Forward, this.direction);
                else this.newPos = this.position;
                break;
            }
        }
    }


}
