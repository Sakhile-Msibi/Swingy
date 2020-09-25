package main.java.model;

public class Opponent {
    public Opponent enemy;
    public String enemyType;
    public int lootdrop;
    public int attack;
    public int xp;
    public  int hp;
    public int defense;
    public int enemyRampage = 0;

    public Opponent(int playerlevel){
        int eType = (int) ((Math.random() * ((3 - 0)+ 1)) + 1);
        
        if(eType == 1)
        {
            this.attack = 25*playerlevel;
            this.hp = 70*playerlevel;
            this.defense =20*playerlevel;
            this.lootdrop = (int) ((Math.random() * ((5 - 0)+ 0)) + 0);
            this.enemyType = "bhubesi";
            this.xp = 200*playerlevel;
        }
        else if(eType == 2)
        {
            this.enemyType = "isitha";
            this.attack = 35*playerlevel;
            this.hp = 80*playerlevel;
            this.defense =15*playerlevel;
            this.lootdrop = (int) ((Math.random() * ((5 - 0)+ 0)) + 0);
            int ramp = (int) ((Math.random() * (((9-(playerlevel -1)) - 0)+ 1)) + 1);
            if(ramp == 10)
            {
                this.enemyRampage = 1;
                this.xp = 350*playerlevel;
            }
            else
            {
                this.enemyRampage = 0;
                this.xp = 330*playerlevel;
            }
        }
        else if(eType == 2)
        {
            this.enemyType = "tikoloshe";
            this.attack = 70*playerlevel;
            this.hp = 275*playerlevel;
            this.defense =25*playerlevel;
            this.lootdrop = (int) ((Math.random() * ((5 - 0)+ 0)) + 0);
            this.xp = 350*playerlevel ;
              
        }
        else
        {
            enemyType = "impisi";
            this.attack = 35*playerlevel;
            this.hp = 75*playerlevel;
            this.defense = 30*playerlevel;
            this.lootdrop = (int) ((Math.random() * ((5 - 0)+ 0)) + 0);
            int ramp = (int) ((Math.random() * (((9-(playerlevel -1)) - 0)+ 1)) + 1);
            if(ramp == 10)
            {
                this.enemyRampage = 1;
                this.xp = 420*playerlevel;
            }
            else
            {
                this.enemyRampage = 0;
                this.xp = 400*playerlevel;
            }
        }
    }

    public  void updateHp(int ah) {
        this.hp-=ah;
    }
}