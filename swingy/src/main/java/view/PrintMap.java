package main.java.view;

import main.java.model.Map;

public class PrintMap {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void printMap(Map map) {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_GREEN+"\n");
        for (int i = 0; i < map.gamemap.length; i++) {
            for (int j = 0; j < map.gamemap.length; j++) {
                if(map.gamemap[i][j].equals("[X]"))
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+map.gamemap[i][j]+ANSI_RESET); 
                }
                else if(map.gamemap[i][j].equals("[E]"))
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_RED+map.gamemap[i][j]+ANSI_RESET);
                }
                else if(map.gamemap[i][j].equals("[L]"))
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_CYAN+map.gamemap[i][j]+ANSI_RESET); 
                }
                else
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_GREEN+map.gamemap[i][j]+ANSI_RESET); 
                }
            }
            System.out.print("\n"+ANSI_RESET);
        }
    }
}