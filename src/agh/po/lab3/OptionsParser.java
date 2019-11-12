package agh.po.lab3;

import agh.po.lab2.MoveDirection;

import java.util.LinkedList;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input) throws IllegalArgumentException{
        LinkedList<MoveDirection> directsParse = new LinkedList<>();
        for(String direct: input){
            switch(direct){
                case "f":
                    case "forward": directsParse.add(MoveDirection.FORWARD); break;

                case "b":
                    case "backward": directsParse.add(MoveDirection.BACKWARD); break;

                case "r":
                    case "right": directsParse.add(MoveDirection.RIGHT); break;

                case "l":
                    case "left": directsParse.add(MoveDirection.LEFT); break;

                default:
                    throw new IllegalArgumentException(direct + " is not a valid argument");
            }
        }
        MoveDirection[] tmp = new MoveDirection[directsParse.size()];
        directsParse.toArray(tmp);
        return tmp;
    }
}
