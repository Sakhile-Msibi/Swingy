package main.java.control;

import java.awt.Frame;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static main.java.control.GameMode.combatEasy;
import static main.java.control.GameMode.combatHard;
import static main.java.control.GameMode.combatNormal;
import static main.java.control.GameMode.combatVaulthunter;
import static main.java.control.Game.startGameLoop;
import static main.java.model.Artifact.*;
import main.java.model.Opponent;
import main.java.model.Map;
import main.java.model.Player;
import static main.java.view.ConsoleView.displayStats;
import static main.java.view.ConsoleView.runConsole;
import main.java.view.GuiView;
import static main.java.view.GuiView.callToRespawn;

public class GameAction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void normalEncounter(Player player, Opponent enemy, Map map) {
        if(player.guiConsole)
        {
            JOptionPane.showMessageDialog(null,"You have encountered "+ enemy.enemyType);
        }
        else
        {
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You have encountered "+ enemy.enemyType+ANSI_RESET);
        }
        if(enemy.enemyType.equals("bhubesi"))
        {
            if(player.guiConsole)
            {
                JOptionPane.showMessageDialog(null,"Better defeat this enemy or they will rip out your eyes");
            }
            else
            {
              System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Better defeat this enemy or they will rip out your eyes"+ANSI_RESET); 
            }
        }
        else if(enemy.enemyType.equals("tikoloshe"))
        {
            if(player.guiConsole)
            {
              JOptionPane.showMessageDialog(null,"tikoloshe says: What are you looking at? Don't look at me!");
            }
            else
            {
              System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"tikoloshe says: What are you looking at? Don't look at me!"+ANSI_RESET); 
            }
        }
       else if(enemy.enemyType.equals("Impisi"))
       {
           if(player.guiConsole)
           {
               if(enemy.enemyRampage == 1)
               {
                   JOptionPane.showMessageDialog(null,"Impisi says: I am gonna floss with your spine!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Impisi says: I am angry!");
                }
            }
            else
            {
                if(enemy.enemyRampage == 1)
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Impisi says: I am gonna floss with your spine!"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Impisi says: I am angry!"+ANSI_RESET);
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Impisi says: I am angry!"+ANSI_RESET);
                }
            }
        }
        else
        {
            if(player.guiConsole)
            {
                if(enemy.enemyRampage == 1)
                {
                    JOptionPane.showMessageDialog(null,"Isitha says: I am gonna floss with your spine!");
                   
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Isitha says: I am gonna crush you with my bare hands!");
                }
            }
            else
            {
                if(enemy.enemyRampage == 1)
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Isitha says: I am gonna floss with your spine!"+ANSI_RESET); 
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Isitha says: I am gonna crush you with my bare hands!"+ANSI_RESET);
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Isitha says: I am gonna crush you with my bare hands!"+ANSI_RESET);
                }
            }
        }
        fightORflight(player,enemy,map);
    }

    public static void fightORflight(Player player, Opponent enemy,Map map) {
        if(player.guiConsole)
        {
            String[] buttons = { "Fight", "Run",}; 
            int returnValue = JOptionPane.showOptionDialog(null, "Will you fight "+enemy.enemyType+" or run away?","FIGHT! FIGHT! FIGHT!",JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
            if(returnValue == 0)
            {
                JOptionPane.showMessageDialog(null,"Not backing down from a fight");
                fightEnemy(player,enemy,map);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Trying to run away?");
                int num = new Random().nextInt(2)+1;
                if(num == 1)
                {
                    JOptionPane.showMessageDialog(null,"There is no way out, you have to fight");
                    fightEnemy(player,enemy,map);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You were a coward and ran away");
                }
            }
        }
        else
        {
            Scanner input = new Scanner(System.in);
            String option;
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++                   OPTIONS                   ++"+ANSI_RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++                'fight' | 'run'              ++"+ANSI_RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            while(input.hasNext())
            {
                option = input.nextLine();
                if(option.equalsIgnoreCase("fight"))
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Not backing down from the fight"+ANSI_RESET);
                    fightEnemy(player,enemy,map);
                    break;
                }
                else if(option.equalsIgnoreCase("run"))
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Trying to run away?"+ANSI_RESET);
                    int num = new Random().nextInt(2)+1;
                    if(num == 1)
                    {
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"There is no way out, you have to fight"+ANSI_RESET);
                        fightEnemy(player,enemy,map);
                    }
                    else
                    {
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You were a coward and ran away"+ANSI_RESET);
                    }
                    break;
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                 INVALID ENTRY               ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                   OPTIONS                   ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                'fight' | 'run'              ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                }
            } 
        }
    }

    public static void respawnOp(Player player) {
        Scanner input = new Scanner(System.in);
        String option;
        while(input.hasNext())
        {
            option = input.nextLine();
            if(option.equalsIgnoreCase("respawn"))
            {
                respawn(player);      
                break;
            }
            else if(option.equalsIgnoreCase("main menu"))
            {
                runConsole ();
                break;
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++       FAILED TO FIGHT FOR YOUR LIFE         ++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                 OPTIONS                     ++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++          'respawn' | 'main menu'            ++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            }
               
        }
    }

    public static void fightEnemy(Player player, Opponent enemy,Map map) {
        if(player.level < 3 && enemy.enemyRampage == 1 && player.difficulty <= 2 &&player.difficulty !=0)
        {
            if(enemy.enemyType.equalsIgnoreCase("Impisi"))
             {
                if(player.guiConsole)
                {
                    String[] buttons = { "Respawn", "Quit Game",}; 
                    int returnValue = JOptionPane.showOptionDialog(null, "Impisi says: Why stop moving?\nYou Failed To Fight For Your Life","Game Over!",JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
                    if(returnValue == 0)
                    {
                        callToRespawn(player);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Goodbye");
                        System.exit(0);
                    }
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Impisi says: Why stop moving?"+ANSI_RESET);
                    printDeathMess();
                    respawnOp(player);
                }
            }
            else
            {
                if(player.guiConsole)
                {
                    String[] buttons = { "Respawn", "Quit Game",}; 
                    int returnValue = JOptionPane.showOptionDialog(null, "Isitha says: Weakness leads to death!\nYou Failed To Fight For Your Life","Game Over!",JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
                    if(returnValue == 0)
                    {
                        callToRespawn( player);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Goodbye");
                        System.exit(0);
                    }      
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Isitha says: Weakness leads to death!"+ANSI_RESET);
                    printDeathMess();
                    respawnOp(player);  
                }
            }
        }
        else if(player.level < 3 && enemy.enemyRampage == 1 && player.difficulty == 0)
        {
            if(player.guiConsole)
            {
                if(enemy.enemyType.equalsIgnoreCase("Impisi"))
                {
                    JOptionPane.showMessageDialog(null,"Woah, you actually took him down. Good job warrior\nImpisi says:I was so... close...  *Impisi dies*");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Woah, you actually took him down. Good job wariior\nIsitha says:My blood... it's salty. *Isitha dies*");
                }
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Woah, you actually took him down. Good job warrior"+ANSI_RESET);
                if(enemy.enemyType.equalsIgnoreCase("Impisi"))
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Impisi says:I was so... close...  *Impisi dies*"+ANSI_RESET);
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Isitha says:My blood... it's salty. *Isitha dies*"+ANSI_RESET);
                }
            }
            playerWonUpdate(player, enemy,map);
        }
        else if(player.level < 3 && enemy.enemyRampage == 1 && player.difficulty == 1)
        {
            int num = new Random().nextInt(2)+1;
            if(num == 1)
            {
                if(player.guiConsole)
                {
                    String[] buttons = { "Respawn", "Quit Game",}; 
                    int returnValue = JOptionPane.showOptionDialog(null, "You Failed To Fight For Your Life","Game Over!",JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
                    if(returnValue == 0)
                    {
                        callToRespawn(player);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Goodbye");
                        System.exit(0);
                    }      
                }
                else
                {
                    printDeathMess();
                    respawnOp(player);
                }
            }
            else
            {
                if(player.guiConsole)
                {
                    if(enemy.enemyType.equalsIgnoreCase("Impisi"))
                    {
                        JOptionPane.showMessageDialog(null,"Woah, you actually took him down. Good job warrior\nImpisi says:I was so... close...*Impisi dies*");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Woah, you actually took him down. Good job warrior\nIsitha says: My blood... it's salty. *Isitha dies*");
                    }      
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Woah, you actually took him down. Good job warrior"+ANSI_RESET);
                    if(enemy.enemyType.equalsIgnoreCase("Impisi"))
                    {
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Impisi says:I was so... close...  *Impisi dies*"+ANSI_RESET);
                    }
                    else
                    {
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Isitha says:My blood... it's salty. *Isitha dies*"+ANSI_RESET);
                    }
                }
                playerWonUpdate(player, enemy,map);
            }  
         }
         else
         {
            if(combat(player, enemy))
            {
                playerWonUpdate(player, enemy,map);
            }
            else
            {
                if(player.guiConsole)
                {
                    String[] buttons = { "Respawn", "Quit Game",}; 
                    int returnValue = JOptionPane.showOptionDialog(null, "You Failed To Fight For Your Life","Game Over!",JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
                    if(returnValue == 0)
                    {
                        callToRespawn(player);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Goodbye");
                        System.exit(0);
                    }      
                }
                else
                {
                    printDeathMess();
                    respawnOp(player);
                }
            }
        }
    }

    public static boolean combat(Player player, Opponent enemy) {
        if(player.difficulty == 0)
        {
            return combatEasy(player, enemy);
        }
        else if(player.difficulty == 1)
        {
            return combatNormal(player, enemy);
        }
        else if(player.difficulty == 2)
        {
            return combatHard(player, enemy);
        }
        else
        {
            return combatVaulthunter(player, enemy);
        }
    }
     
    public static void playerWonUpdate(Player player, Opponent enemy, Map map) {
        if(player.guiConsole)
        {
           JOptionPane.showMessageDialog(null,enemy.enemyType+" taken down!");  
        }
        else
        {
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+enemy.enemyType+" taken down!"+ANSI_RESET);
        }
        
        if(player.hp < player.basehp)
        {
            int syringe = (player.basehp - player.hp) / 2;
            if(player.guiConsole)
            {
                JOptionPane.showMessageDialog(null,enemy.enemyType+" dropped a syring +"+syringe+" health");  
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+enemy.enemyType+" dropped a syring +"+syringe+" health"+ANSI_RESET);
            }
            updateHp(player,syringe);
        }

        if(player.direction == 's')
        {
            Map.gamemap[player.posx][player.posy] = "[ ]";
            Map.gamemap[player.posx+1][player.posy] = "[X]";
            player.updatePlayerX(player.posx+1);
        }
        else if(player.direction == 'n')
        {
            Map.gamemap[player.posx][player.posy] = "[ ]";   
            Map.gamemap[player.posx-1][player.posy] = "[X]";
            player.updatePlayerX(player.posx-1);
        }
        else if(player.direction == 'e')
        {
            Map.gamemap[player.posx][player.posy] = "[ ]";
            Map.gamemap[player.posx][player.posy+1] = "[X]";
            player.updatePlayerY(player.posy+1);
        }
        else
        {
            Map.gamemap[player.posx][player.posy] = "[ ]";
            Map.gamemap[player.posx][player.posy-1] = "[X]";
            player.updatePlayerY(player.posy-1);
        }
        player.updatePlayerXP(enemy.xp);
        player.updateLevel();
        
        if(enemy.lootdrop > 0)
        {
            generateLoot(player, enemy);
        }
        displayStats(player);
    }

    private static int listLoot(String loot, String enemyType, boolean guiConsole) {
        String [] out = loot.split("-");
        
        if(guiConsole)
        {
            JOptionPane.showMessageDialog(null,enemyType+" dropped "+ out[0]+"\n+"+out[2]+" "+out[1]);
        }
        else
        {
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+enemyType+" dropped "+ out[0]+ANSI_RESET);
            System.out.println("+"+out[2]+" "+out[1]);
        }
        return Integer.parseInt(out[2]);
    }
    
    public static boolean pickOrleave(boolean guiConsole) {
        if(guiConsole)
        {
            String[] buttons = { "Pickup Loot", "Leave loot",}; 
            int returnValue = JOptionPane.showOptionDialog(null, "Will you pick up the loot","LOOT! LOOT! LOOT!",JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
            if(returnValue == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            Scanner input = new Scanner(System.in);
            String option;
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++                   OPTIONS                   ++"+ANSI_RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++             'pickup' | 'leave'              ++"+ANSI_RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            while(input.hasNext())
            {
                option = input.nextLine();
                if(option.equalsIgnoreCase("pickup"))
                {
                    return true;
                }
                else if(option.equalsIgnoreCase("leave"))
                {
                    return false;
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                 INVALID ENTRY               ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                   OPTIONS                   ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++             'pickup' | 'leave'              ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                }
            }
        }
        return false;
    }

    public static void generateLoot(Player player, Opponent enemy) {
        int rarity = 0;
        String loot = "";
        if(enemy.enemyType.equalsIgnoreCase("bhubesi") ||enemy.enemyType.equalsIgnoreCase("tikoloshe"))
        {
            rarity = 1;
            if(enemy.enemyType.equalsIgnoreCase("bhubesi"))
            {
                loot = shield( rarity);
                int var = listLoot(loot, enemy.enemyType, player.guiConsole);
                if(pickOrleave(player.guiConsole))
                {
                    player.artifact[0] = loot;
                    player.updateDefense(var);
                }
            }
            else
            {
                loot = gun(rarity);
                int var =listLoot(loot, enemy.enemyType,player.guiConsole);
                if(pickOrleave(player.guiConsole))
                {
                    player.artifact[1] = loot;
                    player.updateAttack(var);
                }
            }
        }
        else
        {
            if((enemy.enemyType.equalsIgnoreCase("Impisi") || enemy.enemyType.equalsIgnoreCase("Isitha")) && enemy.enemyRampage == 1)
            {
                rarity = 3;
                loot = gun(rarity);
                int var = listLoot(loot, enemy.enemyType, player.guiConsole);
                
                if(pickOrleave(player.guiConsole))
                {
                    player.artifact[1] = loot;
                    player.updateAttack(var);
                }
                loot = shield(rarity);
                var = listLoot(loot, enemy.enemyType, player.guiConsole);
                if(pickOrleave(player.guiConsole))
                {
                    player.artifact[0] = loot;
                    player.updateDefense(var);
                }
                loot =relic(rarity);
                var = listLoot(loot, enemy.enemyType, player.guiConsole);
                if(pickOrleave(player.guiConsole))
                {
                    player.artifact[2] = loot;
                    player.updateDefense(var);
                }
            }
            else
            {
                rarity = 2;
                int num = new Random().nextInt(2)+1;
                int var = 0;
                if(num == 1)
                {
                    loot = shield(rarity);
                    var = listLoot(loot, enemy.enemyType, player.guiConsole);
                    if(pickOrleave(player.guiConsole))
                    {
                        player.artifact[0] = loot;
                        player.updateDefense(var);
                    }
                }
                else
                {
                   loot = gun(rarity);
                   var =listLoot(loot, enemy.enemyType, player.guiConsole);
                   if(pickOrleave(player.guiConsole))
                    {
                        player.artifact[1] = loot;
                        player.updateAttack(var);
                    }
                }
            }
        }
    }

    public static void printDeathMess() {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++       FAILED TO FIGHT FOR YOUR LIFE         ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                 OPTIONS                     ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++          'respawn' | 'main menu'            ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
    }
     
     public static void respawn(Player player)
     {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++   The bright light you saw after death is Hyperion corporation digistruct technology   +++");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        playerRespawnHp(player);
        displayStats(player);
        Map map = new Map(player);
        startGameLoop(player, map);
    }

    public static void playerRespawnHp(Player player) {
        if(player.classType.equalsIgnoreCase("Zulu"))
        {   
            player.hp=75;
        }
        if(player.classType.equalsIgnoreCase("Xhosa"))
        {
            player.hp=75;
        }
        if(player.classType.equalsIgnoreCase("Swati"))
        {
           player.hp=80;
        }
        if(player.classType.equalsIgnoreCase("Ndebele"))
        {
            player.hp=70;
        }
    }

    private static void updateHp(Player player,int syringe) {
        player.hp += syringe;
    }
}