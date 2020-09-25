package main.java.control;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.model.Map;
import static main.java.model.Map.updateMap;
import main.java.model.Player;
import static main.java.control.Vaulthunter.CreateSaveFile;
import static main.java.view.PrintMap.printMap;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void guiEvent(String cmd, Player player) {
        if(cmd.equals("n")||cmd.equals("s")||cmd.equals("w")||cmd.equals("e"))
        {
            updateMap(cmd, player);
        }
    }

    public static void startGameLoop(Player player, Map map) {
        boolean gamerun = true;
        
        while(gamerun)
        {
            printDirection();
            Scanner input = new Scanner(System.in);
            String option;
           
            while(input.hasNext())
            {
                option = input.nextLine();
                if(option.equalsIgnoreCase("EXIT"))
                {
                    gamerun = false;
                    break;
                }
                else if(option.equalsIgnoreCase("save"))
                {
                    CreateSaveFile(player);
                    break;
                }
                else if(option.equalsIgnoreCase("n")|option.equalsIgnoreCase("s")|option.equalsIgnoreCase("e")|option.equalsIgnoreCase("w"))
                {
                    updateMap(option, player);
                    printMap( map);
                    break;
                }
                else
                {
                    printDirection();
                }
                printMap( map);
            }
        }
        printMap( map);
    }
    
    public static void printDirection() {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++               OPTIONS                 +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++   'N' to move up | 'S' to move down   +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++ 'W' to move left | 'E' to move right  +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++       'exit'      |       'save'      +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
    }
}