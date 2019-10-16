package agh.po.lab3;

import agh.po.lab2.MoveDirection;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input){
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

                default: break;
            }
        }
        return (MoveDirection[]) directsParse.toArray();
    }
}