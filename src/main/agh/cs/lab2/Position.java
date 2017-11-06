package agh.cs.lab2;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position operand){
        return this.x <= operand.x && this.y <= operand.y;
    }

    public boolean larger(Position operand){
        return this.x >= operand.x && this.y >= operand.y;
    }

    public Position add(Position operand) {
        return new Position(this.x + operand.x, this.y + operand.y);
    }
    //public Position change (Position operand) { return new Position ()};


    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Position)) return false;
        Position position = (Position) obj;

        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode(){
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
