package agh.po.lab1;

import static java.lang.System.out;

public class CarSystem {
    private double angle;

    private static void run(Direction[] directions) {
        for(Direction i: directions){
            switch(i){
                case FORWARD:
                    out.print("Moving forward"); break;
                case BACKWARD:
                    out.print("Moving backward"); break;
                case RIGHT:
                    out.print("Moving right"); break;
                case LEFT:
                    out.print("Moving left"); break;
                default:
                    out.print("Wrong argument"); break;
            }
            out.print(", ");
        }
        out.print("\b\b\n");
    }

    public static void main(String[] args){
        out.println("Start");

        Direction[] directs = new Direction[args.length];
        for(int i = 0; i < args.length; ++i){
            directs[i] = Direction.fromString(args[i]);
        }
        run(directs);

        out.println("Finish");
    }
}
