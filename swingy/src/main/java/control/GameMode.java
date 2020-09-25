package main.java.control;

import java.util.Random;
import javax.swing.JOptionPane;
import main.java.model.Opponent;
import main.java.model.Player;

public class GameMode {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    protected static boolean combatEasy(Player player, Opponent enemy) {
        int NH = getNumHits(player, enemy, 4 , player.level);
        NH = (NH/4) - 1;
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You get the first "+NH+" hits!"+ANSI_RESET);
        return fight(player, enemy, NH);
    }
    
    protected static boolean combatNormal(Player player, Opponent enemy) {
        int NH = getNumHits(player, enemy, 3 , player.level);
        NH = (NH/3) - 1;
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You get the first "+NH+" hits!"+ANSI_RESET);
        return fight(player, enemy,NH);
    }
    
      
    protected static boolean combatHard(Player player, Opponent enemy) {
        int NH = getNumHits(player, enemy, 2 , player.level) - 1;
        NH = (NH/2);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You get the first "+NH+" hits!"+ANSI_RESET);
        return fight(player, enemy,NH);
    }

    protected static boolean combatVaulthunter(Player player, Opponent enemy) {
        int NH = getNumHits(player, enemy, 1 , player.level);
        NH = (NH/1);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You get the first "+NH+" hits!"+ANSI_RESET);
        return fight(player, enemy,NH);
    }
    
    private static int getNumHits(Player player, Opponent enemy, int y , int x) {
        return (enemy.hp * y)/(player.attack * x);
    }

    private static boolean fight(Player player, Opponent enemy, int NH) {
        String out = "";
        out+=(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"You hit "+enemy.enemyType+" for "+ (player.attack*NH)+ANSI_RESET)+"\n";
        boolean ret = false;
        
        for (int i = 0; i < NH; i++) 
        {
            if(enemy.hp <= 0)
            {
                return true;
            }
            enemy.updateHp(player.attack);
        }
        
        int fightloop = 1;
        while(fightloop == 1)
        {
            if(enemy.hp <= 0)
            {
                ret = true;
                break;
            }
            if(player.hp <=0)
            {
                ret = false;
                break;
            }
            out+=ANSI_YELLOW_BACKGROUND + ANSI_BLUE+EnemyHit(player, enemy)+"\n"+ANSI_RESET;
            if(enemy.hp <= 0)
            {
                ret = true;
                break;
            }
            if(player.hp <=0)
            {
                ret = false;
                break;
            }
            out += ANSI_YELLOW_BACKGROUND + ANSI_BLUE+playerHit(player, enemy)+"\n"+ANSI_RESET;
        }
        
        if(player.guiConsole)
        {
            JOptionPane.showMessageDialog(null,out,"COMBAT", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            System.out.println(out);
        }
        return ret;
    }

    private static String playerHit(Player player, Opponent enemy) {
        String otp = "";
        if(player.difficulty == 0)
        {
            enemy.updateHp(player.attack);
            otp += ("You hit "+enemy.enemyType+" for "+ player.attack+"\n");
        }
        else if(player.difficulty == 1)
        {
            int num = new Random().nextInt(4)+1;
            if(num == 1)
            {
                if((player.attack - enemy.defense) > 0)
                {
                    enemy.updateHp((player.attack - enemy.defense));
                    otp+=("You hit "+enemy.enemyType+" for "+ (player.attack - enemy.defense)+"\n");
                }
            }
            else
            {
                enemy.updateHp(player.attack);
                otp+=("You hit "+enemy.enemyType+" for "+ player.attack+"\n");
            }
        }
        else if(player.difficulty == 2)
        {
            int num = new Random().nextInt(3)+1;
            if(num == 1)
            {
                if((player.attack - enemy.defense) > 0)
                {
                    enemy.updateHp((player.attack - enemy.defense));
                    otp+=("You hit "+enemy.enemyType+" for "+ (player.attack - enemy.defense)+"\n");
                }
            }
            else
            {
                enemy.updateHp(player.attack);
                otp+=("You hit "+enemy.enemyType+" for "+ player.attack+"\n");
            }
        }
        else
        {
            int num = new Random().nextInt(2)+1;
            if(num == 1)
            {
                if((player.attack - enemy.defense) > 0)
                {
                    enemy.updateHp((player.attack - enemy.defense));
                    otp+=("You hit "+enemy.enemyType+" for "+ (player.attack - enemy.defense)+"\n");
                }
            }
            else
            {
                enemy.updateHp(player.attack);
                otp+=("You hit "+enemy.enemyType+" for "+ player.attack+"\n");
            }
        }
        return otp;
    }

    private static String EnemyHit(Player player,Opponent enemy) {
        String otp = "";

        if(player.difficulty == 3)
        {
            player.updatePlayerHp(enemy.attack);
            otp+=("You got hit by "+enemy.enemyType+" for "+ enemy.attack)+"\n";
        }
        else if(player.difficulty == 2)
        {
            int num = new Random().nextInt(4)+1;
            if(num == 1)
            {
                if((enemy.attack - player.defense) > 0)
                {
                    player.updatePlayerHp((enemy.attack - player.defense));
                    otp+=("You got hit by "+enemy.enemyType+" for "+ (enemy.attack - player.defense)+"\n");
                }
            }
            else
            {
                player.updatePlayerHp(enemy.attack);
                otp+=("You got hit by "+enemy.enemyType+" for "+ enemy.attack+"\n");
            }
        }
        else if(player.difficulty == 1)
        {
            int num = new Random().nextInt(3)+1;
            if(num == 1)
            {
                if((enemy.attack - player.defense) > 0)
                {
                    player.updatePlayerHp((enemy.attack - player.defense));
                    otp+=("You got hit by "+enemy.enemyType+" for "+ (enemy.attack - player.defense)+"\n");
                }
            }
            else
            {
                player.updatePlayerHp(player.attack);
                otp+=("You got hit by "+enemy.enemyType+" for "+ enemy.attack)+"\n";
            }
        }
        else
        {
            int num = new Random().nextInt(2)+1;
            if(num == 1)
            {
                if((enemy.attack - player.defense) > 0)
                {
                    player.updatePlayerHp((enemy.attack - player.defense));
                    otp+=("You got hit by"+enemy.enemyType+" for "+ (enemy.attack - player.defense)+"\n");
                }
            }
            else
            {
                player.updatePlayerHp(enemy.attack);
                otp+=("You got hit by "+enemy.enemyType+" for "+ enemy.attack+"\n");
            }
        }
        return otp;
    }
}