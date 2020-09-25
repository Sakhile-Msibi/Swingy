package main.java.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.logging.Level;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;
import javax.validation.Validation;
import javax.validation.ConstraintViolation;
import java.util.logging.Logger;
import main.java.control.SavedFiles;
import static main.java.control.SavedFiles.loadsaves;
import static main.java.control.SavedFiles.openSave;
import main.java.model.Map;
import main.java.model.Player;
import static main.java.control.Vaulthunter.CreateSaveFile;
import static main.java.control.Game.startGameLoop;

public class ConsoleView {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void runConsole() {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++                                       +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++           Welcome To Swingy           +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++               OPTIONS                 +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++     'create' | 'open saved' | 'gui'   +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++                                       +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        try (Scanner input = new Scanner(System.in)) {
            String option;
            while(input.hasNext())
            {
                option = input.nextLine();
                if(option.equalsIgnoreCase("create"))
                {
                    createCharacter();
                    break;
                }
                else if(option.equalsIgnoreCase("open saved"))
                {
                   opensaved("console");
                    break;
                }
                else if(option.equalsIgnoreCase("gui"))
                {
                    break;
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++                                       +++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++           Welcome To Swingy           +++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++               OPTIONS                 +++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++     'create' | 'open saved' | 'gui'   +++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++                                       +++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                }
            }
        }

    }
    private static void opensaved(String mode) 
    {
         if(loadsaves(mode))
         {
            openSave();
         }
         else
         {
             runConsole();
         }
    }
    public static void createCharacter()
    {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++               Select hero class              ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++                   OPTIONS                    ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++        'Zulu'|'Xhosa'|'Swati'|'Ndebele'      ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++                                              ++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        try (Scanner input = new Scanner(System.in)) {
            String option;
            
            while(input.hasNext())
            {
                option = input.nextLine();
                if(option.equalsIgnoreCase("Zulu"))
                {
                    inputHeroName(option);
                    break;
                }
                else if(option.equalsIgnoreCase("Xhosa"))
                {
                    inputHeroName(option);
                    break;
                }
                else if(option.equalsIgnoreCase("Swati"))
                {
                    inputHeroName(option);
                    break;
                }
                else if(option.equalsIgnoreCase("Ndebele"))
                {
                    inputHeroName(option);
                    break;
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++               Select hero class              ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                   OPTIONS                    ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++        'Zulu'|'Xhosa'|'Swati'|'Ndebele'      ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++                                              ++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                }
            }
        }
    }
    public static void displayStats(Player player)
    {
        System.out.println(ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        if(player.classType.equalsIgnoreCase("zulu"))
        {
             System.out.println("                 Shaka WakaZulu                 ");
        }
        else if(player.classType.equalsIgnoreCase("swati"))
        {
            System.out.println("                Sobhuza WaseSwatini                 ");
        }
        else if(player.classType.equalsIgnoreCase("ndebele"))
        {
             System.out.println("             Mzilikazi WamaNdebele                ");
        }
        else
        {
             System.out.println("            Hinsta WamaXhosa               ");
        }  
        System.out.println("                  Level : "+player.level);
        System.out.println("             Hit Points : "+player.hp);
        System.out.println("                 Attack : "+player.attack);
        System.out.println("                Defense : "+player.defense);
        System.out.println("                 Shield : "+player.artifact[0]);
        System.out.println("                    Gun : "+player.artifact[1]);
        System.out.println("                  Relic : "+player.artifact[2]);
        if(player.level>2)
        {
            System.out.println("           Experience : "+player.action);
        }
        else
        {
            System.out.println("           Experience : Unlocks at level 3");
        }
        System.out.println(ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
    }
    
    public static int getDifficulty()
    {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++            Select difficulty mode          +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++ 'easy' | 'normal' | 'hard' | 'vaulthunter' +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        Scanner input = new Scanner(System.in);
        int modeCounter = 0;
        
        while(input.hasNext())
        {
            String mode = input.nextLine();
            if(mode.equalsIgnoreCase("easy"))
            {
                modeCounter = 0;
                break;
            }
            else if(mode.equalsIgnoreCase("normal"))
            {
                modeCounter =1;
                break;
            }
            else if(mode.equalsIgnoreCase("hard"))
            {
                modeCounter = 2;
                break;
            }
            else if(mode.equalsIgnoreCase("vaulthunter"))
            {
                modeCounter = 3;
                break;
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++               Invalid entry                +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++            Select difficulty mode          +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++ 'easy' | 'normal' | 'hard' | 'vaulthunter' +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            }
        }
        return modeCounter;
    }
    
    private static void inputHeroName(String classType)
    {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++          Create a file name           +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        Scanner input = new Scanner(System.in);
        boolean nameAvailable = false;
        boolean violation = false;
        @NotNull (message = "File name is required")  @Size(min = 1, max = 20, message = "File name cannot exceed 20 characters") String saveName;
        while(input.hasNext())
        {
            saveName = input.nextLine();
            if(!saveName.isEmpty())
            {
                nameAvailable = SavedFiles.checkNameAvailable(saveName);
                if(!nameAvailable)
                {
                    Player player = new Player(classType,saveName,getDifficulty());
                    player.guiConsole = false;

                    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		            Validator validator = factory.getValidator();
                    Set<ConstraintViolation<Player>> constraintViolations = validator.validate(player);
                    if (constraintViolations.size() > 0) {
                        ConstraintViolation<Player> firstViolation = constraintViolations.iterator().next();
                        final String error = "ERROR !!! "+ firstViolation.getPropertyPath() + " -> " + firstViolation.getMessage() + " ('" + firstViolation.getInvalidValue() + "' given)";
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+error+ANSI_RESET);
                        violation = true;
                       break;
    
                    }
                    else
                    {
                        CreateSaveFile(player);
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++  Your Vault Hunter has been created   +++++"+ANSI_RESET);
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                        displayStats(player);
                        Map map = new Map(player);
                        startGameLoop(player, map);
                        break;
                    }
                }
                else
                {
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++    A file with that name already exist    +++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++ Please give another name for your warrior +++"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                }
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++   Give your warrior a name warrior    +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            }
        }
        if( violation)
        {
            inputHeroName(classType);
        }
    }
}