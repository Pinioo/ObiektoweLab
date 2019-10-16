package agh.po.lab3;

import agh.po.lab2.MoveDirection;

import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input){
        ArrayList<MoveDirection> directsParse = new ArrayList<>();
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
        Object[] tmp = directsParse.toArray();
        return (MoveDirection[])tmp;
    }
}
