package agh.cs.lab2;

public class OptionsParser {
    /*
    private String[] args;
    public OptionsParser(String[] args){
        this.args = args;
    }
    */

    public MoveDirection[] parse(String[] args){
        MoveDirection result[] = new MoveDirection[args.length];
        for(int i = 0; i < args.length; i++){
            String argument = args[i];

            switch(argument){
                case "f":
                    result[i] = MoveDirection.Forward;
                    break;

                case "forward":
                    result[i] = MoveDirection.Forward;
                    break;

                case "b":
                    result[i] = MoveDirection.Backward;
                    break;

                case "backward":
                    result[i] = MoveDirection.Backward;
                    break;

                case "r":
                    result[i] = MoveDirection.Right;
                    break;

                case "right":
                    result[i] = MoveDirection.Right;
                    break;

                case "l":
                    result[i] = MoveDirection.Left;
                    break;

                case "left":
                    result[i] = MoveDirection.Left;
                    break;

                default:
                    result[i] = MoveDirection.def;
                    break;
            }
        }
        return result;
    }
}
