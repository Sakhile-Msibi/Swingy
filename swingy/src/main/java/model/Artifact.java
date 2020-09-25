package main.java.model;

public class Artifact {
    public static String gun(int rarity) {
        String loot;
        String guns [][] = {{"Smooth SMG gun-attack-3","Casual Carnage gun-attack-4","Sledge's Shotgun-attack-6"},
                            {"Royal Octal shotgun-attack-8","consummate provocateur gun-attack-7","Purging Stalker gun-attack-9"},
                            {"Emarald Fox pistol-attack-10","Social Conference Call shotgun-attack-12"," Cohesion Invader sniper-attack-11"}};
        
        int guncounter  =(int) ((Math.random() * ((2 - 0) + 1)) + 0);
        if(rarity == 1)
        {
            loot = guns[0][guncounter];
        }
        else if(rarity == 2)
        {
            loot = guns[1][guncounter];
        }
        else
        {
            loot = guns[2][guncounter];
        }
        return loot;
    }

    public static String shield(int rarity) {
        String loot;
        String guns [][] = {{"Restrictive Absorb shield-defense-5","Corrosive Spike shield-defense-7","Turtle Shield-defense-8"},
                            {"Tuff Maylay Shield-defense-9","Wide Eyed Booster Shield-defense-10","Shield of Ages Shield-defense-11"},
                            {"The Sham Shield-defense-13","The Bee Shield-defense-15","Alkaline Impaler Shield-defense-14"}};
        
        int shieldcounter  =(int) ((Math.random() * ((2 - 0) + 1)) + 0);
        if(rarity == 1)
        {
            loot = guns[0][shieldcounter];
        }
        else if(rarity == 2)
        {
            loot = guns[1][shieldcounter];
        }
        else
        {
            loot = guns[2][shieldcounter];
        }
        return loot;
    }

    public static String relic(int rarity) {
        String loot;
        String guns [][] = {{"Moon Shoes Relic-HP-6","Bone of the Ancients Relic-HP-7","Elemental Relic-HP-9"},
                            {"Sherrif's Badge Relic-HP-11","Blood of the Seraphs Relic-HP-12","Moxxi's Endowment Relic-HP-14"},
                            {"Heart of the Ancients Relic-HP-16","Blood of Teramorphous Relic-HP-18","Protection Relic-HP-20"}};
        
        int relic  =(int) ((Math.random() * ((2 - 0) + 1)) + 0);
        if(rarity == 1)
        {
            loot = guns[0][relic];
        }
        else if(rarity == 2)
        {
            loot = guns[1][relic];
        }
        else
        {
            loot = guns[2][relic];
        }
        return loot;
    }
}