package main.java.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.model.Player;
import static main.java.control.GameAction.normalEncounter;

public class Map {
    public static final String RED = "\u001B[31m";
    public static Map map;
    public static String gamemap [][];
    public static int mapsize;
    public static int wallWarning = 0;


    public Map(Player player) {
        mapsize = (player.level-1)*5+10-(player.level%2);
        player.setCenterPos((mapsize/2)-1);
        this.gamemap = populateMap(player, mapsize);
        for (int i = 0; i < this.gamemap.length; i++) {
            for (int j = 0; j < this.gamemap.length; j++) {
                System.out.print(this.gamemap[i][j]); 
            }
             System.out.print("\n");
        }
       
    }
    
    public static String[][] populateMap(Player player, int mapsize) {
        String map [][] = new String [mapsize][mapsize];
        int lootBox = 1;
        int enemyPawn = mapsize + player.level;
         
        if(player.level > 1)
        {
            lootBox= (lootBox* player.level) + 2;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(j == player.posx && i== player.posy)
                {
                   map[i][j] = "[X]";
                }
                else
                {
                   map[i][j] = "[ ]";
                }            
            }
        }
             
        while(lootBox !=0)
        {
            int x = (int) ((Math.random() * ((mapsize - 1) + 1)) + 0);
            int y = (int) ((Math.random() * ((mapsize - 1) + 1)) + 0);
            if(x!= player.posx && y !=player.posy)
            {
                map[x][y] = "[L]";
                lootBox--;
            }
        }
        while(enemyPawn !=0)
        {
            int x = (int) ((Math.random() * ((mapsize - 1) + 1)) + 0);
            int y = (int) ((Math.random() * ((mapsize - 1) + 1)) + 0);
            if(x!= player.posx && y !=player.posy && !map[x][y].equalsIgnoreCase("[L]"))
            {
                map[x][y] = "[E]";
                enemyPawn--;
            }
        }
        return map;
    }
    
    public static void updateMap(String direction,Player player) {
        player.direction = direction.toLowerCase().charAt(0);
        if(direction.equalsIgnoreCase("N"))
        {
            if(checkMapLimits(player.posx-1))
            {
                if(gamemap[player.posx-1][player.posy].equals("[E]"))
                {
                    Opponent enemy = new Opponent(player.level);
                    normalEncounter(player, enemy,map);
                }
                else
                {
                    gamemap[player.posx][player.posy] = "[ ]";   
                    gamemap[player.posx-1][player.posy] = "[X]";
                    player.updatePlayerX(player.posx-1);
                    wallWarning = 0;
                }
            }
            else
            {
                hitAwall(player);
            }
         }
         else if(direction.equalsIgnoreCase("S"))
         {
            if(checkMapLimits(player.posx+1))
            {
                if(gamemap[player.posx+1][player.posy].equals("[E]"))
                {
                    Opponent enemy = new Opponent(player.level);
                    normalEncounter(player, enemy, map);
                }
                else
                {
                    gamemap[player.posx][player.posy] = "[ ]";
                    gamemap[player.posx+1][player.posy] = "[X]";
                    player.updatePlayerX(player.posx+1);
                    wallWarning = 0;
                }
            }
            else
            {
                hitAwall(player);
            }
        }
        else if(direction.equalsIgnoreCase("E"))
        {
            if(checkMapLimits(player.posy+1))
            {
                if(gamemap[player.posx][player.posy+1].equals("[E]"))
                {
                   
                    Opponent enemy = new Opponent(player.level);
                    normalEncounter(player, enemy,map);
                    
                }
                else
                {
                    gamemap[player.posx][player.posy] = "[ ]";
                    gamemap[player.posx][player.posy+1] = "[X]";
                    player.updatePlayerY(player.posy+1);
                    wallWarning = 0;
                }
                
            }
            else
            {
                hitAwall(player);
            }
        }
        else
        {
            if(checkMapLimits(player.posy-1))
            {
                if(gamemap[player.posx][player.posy-1].equals("[E]"))
                {
                   
                    Opponent enemy = new Opponent(player.level);
                    normalEncounter(player, enemy,map);
                 
                }
                else
                {
                    gamemap[player.posx][player.posy] = "[ ]";
                    gamemap[player.posx][player.posy-1] = "[X]";
                    player.updatePlayerY(player.posy-1);
                    wallWarning = 0;
                }
            }
            else
            {
                hitAwall(player);
            }
        }
    }
     
    public static boolean checkMapLimits(int varmap) {
        return varmap < mapsize && varmap>=0;
     }

     public static void hitAwall(Player player) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        if(wallWarning < 4)
        {
            if(player.guiConsole)
            {
                JOptionPane.showMessageDialog(null, "You cant walk through walls!\nFurther attempts will result in brain damage and death!");
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++            You cant walk through walls!                 +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++ Further attempts will result in brain damage and death! +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            }
        }
        else
        {
            if(player.guiConsole)
            {
                JOptionPane.showMessageDialog(null," Game Over|But Also win\nThe pdf says you win if you keep hitting a wall");
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++              Game Over | But Also win           +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++ The pdf says you win if you keep hitting a wall +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            }
            System.exit(0);
        }
        wallWarning++;
    }   
}