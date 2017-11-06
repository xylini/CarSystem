package agh.cs.lab2;

public enum MapDirection {
    North,
    South,
    West,
    East;

    public String toString(){
        switch(this){
            case North:      return "N";
            case South:      return "S";
            case West:       return "W";
            case East:       return "E";
        }
        return null;
    }

    public MapDirection next(){
        switch(this){
            case North:     return East;
            case South:     return West;
            case West:      return North;
            case East:      return South;
        }
        return null;
    }

    public MapDirection previous(){
        switch(this){
            case North:     return West;
            case South:     return East;
            case West:      return South;
            case East:      return North;
        }
        return null;
    }
}
