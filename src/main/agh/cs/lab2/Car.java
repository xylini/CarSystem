package agh.cs.lab2;

import static agh.cs.lab2.MapDirection.North;

public class Car implements IWorldMap {
    private Position position = new Position(2, 2);
    private MapDirection direction = North;
    private Position newPos = position;
    private Position minPos = new Position(0, 0);
    private Position maxPos = new Position(4, 4);

    public Car(IWorldMap map){};

    @Override
    public String toString() {
        return "Samochód znajduje się na pozycji" + this.position.toString() + " a kierunek " + this.direction.toString();
    }

    public boolean canMoveTo(Position newPos) {
        //if (newPos.larger(this.minPos) && newPos.smaller(this.maxPos)) System.out.println("Dziala");
        return newPos.larger(this.minPos) && newPos.smaller(this.maxPos);
    }

    private Position makeMove(MoveDirection direction, MapDirection mapDir) {
        switch (direction) {
            case Forward: {
                switch (mapDir) {
                    case North: {
                        return this.newPos.add(new Position(0, 1));
                        //break;
                    }

                    case South: {
                        return this.newPos.add(new Position(0,-1));
                       // break;
                    }

                    case West: {
                        return this.newPos.add(new Position(-1, 0));
                        //break;
                    }

                    case East: {
                        return this.newPos.add(new Position(1, 0));
                       // break;
                    }
                }
            }
            case Backward: {
                switch (mapDir) {
                    case North: {
                        return this.newPos.add(new Position(0, -1));
                       // break;
                    }

                    case South: {
                        return this.newPos.add(new Position(0, 1));
                       // break;
                    }

                    case West: {
                        return this.newPos.add(new Position(1, 0));
                      //  break;
                    }

                    case East: {
                        return this.newPos.add(new Position(-1, 0));
                        //break;
                    }
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
                if (canMoveTo(this.newPos)) this.position = new Position(0,0).add(this.newPos);
                //else this.newPos = makeMove(MoveDirection.Backward, this.direction);
                else this.newPos = this.position;
                break;
            }


            case Backward: {
                this.newPos = makeMove(direction, this.direction);
                if (canMoveTo(this.newPos)) this.position = new Position(0,0).add(this.newPos);
                //else this.newPos = makeMove(MoveDirection.Forward, this.direction);
                else this.newPos = this.position;
                break;
            }

        }
    }


}
