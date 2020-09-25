package main.java.control;

import main.java.model.Player;

public class Vaulthunter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void CreateSaveFile(Player player) {
        SavedFiles.writeSavefile(player.saveName, player.classType, player.level, player.hp, player.attack, player.defense, player.action, player.artifact);
        System.out.println("");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+  Your File has been created successfully +"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++\n"+ANSI_RESET);
    }
}