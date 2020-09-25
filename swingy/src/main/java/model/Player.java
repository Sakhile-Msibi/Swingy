package main.java.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Player { 
    public static Player player;
    @Positive (message = "Level must be positive")public int level = 1;
    public static String classType;
    @Valid @Size(min = 1, max = 20, message = "File to be saved cannot be empty and must not exceed 20 characters")public String saveName;
    public String artifact [] = {"false", "false","false"};
    @Positive (message = "Attack must be positive") public int attack;
    public int xp = 0;
    public int posx = 0;
    public int posy = 0;
    @Positive (message = "HP must be positive") public  int hp;
    public int basehp;
    public int defense;
    public String action;
    public char direction;
    public boolean guiConsole = false;
    public int difficulty = 0;
    
    public Player(String classType,  @NotNull (message = "saved file name required")  @Size(min = 1, max = 20, message = "Saved file name cannot exceed 20 characters")
        String saveName, int mode) {  
        this.classType=classType;  
        this.saveName=saveName; 
        this.difficulty=mode;
        if(classType.equalsIgnoreCase("Zulu"))
        {   
            this.attack += 6;
            this.hp+=75;
            this.defense+=22;
            this.action="Phaselock";
        }
        if(classType.equalsIgnoreCase("Xhosa"))
        {
            this.attack += 5;
            this.hp+=75;
            this.defense+=23;
            this.action="Death-Trap";
        }
        if(classType.equalsIgnoreCase("Swati"))
        {
            this.attack += 10;
            this.hp+=80;
            this.defense+=13;
            this.action="Spear-Rampage";
        }
        if(classType.equalsIgnoreCase("Ndebele"))
        {
            this.attack += 7;
            this.hp+=76;
            this.defense+=20;
            this.action="Rack-Attack";
        }
        basehp = this.hp;
    }

    public void updateLevel() {
        if(xp >= 1000 && xp < 2450)
        {
            this.level = 2;
        }
        else if(xp >= 2450 && xp <4800)
        {
            this.level = 3;
        }
         else if(xp >= 4800 && xp <8050)
        {
            this.level = 4;
        }
          else if(xp >= 8050 && xp <12200)
        {
            this.level = 5;
        }
         else if(xp >= 12200 && xp <17250)
        {
            this.level = 6;
        }
         else if(xp >= 17250)
        {
            this.level = 7;
        }
        else
        {
            this.level = 1;
        }
    }
    
    public void updateAttack(int at) {
        this.attack += at;
    }
        
    public void updateDefense(int df) {
        this.defense += df;
    }
    
    public void updatePlayerXP(int xp) {
        this.xp += xp;
    }

    public void updatePlayerY(int y) {
        this.posy = y;
    }

    public void updatePlayerX(int x) {
        this.posx = x;
    }
    
    public  void setCenterPos(int center) {
        this.posx = center+1;
        this.posy = center+1;
    }

    public  void updatePlayerHp(int ah) {
        this.hp-=ah;
    }
}