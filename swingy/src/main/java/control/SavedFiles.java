package main.java.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.view.ConsoleView;
import javax.swing.JOptionPane;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Validator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import static main.java.control.Game.startGameLoop;
import main.java.model.Map;
import main.java.model.Player;
import static main.java.view.GuiView.callToPlayerGui;
import static main.java.view.ConsoleView.displayStats;
import static main.java.view.ConsoleView.getDifficulty;
import static main.java.view.ConsoleView.runConsole;

public class SavedFiles {
    public static boolean checkNameAvailable(String savename)
    {
        File dir = new File("classes//saveFiles");
        String[] directorylist = dir.list();
        savename+=".txt";
        if(directorylist.length > 0)
        {
            for (int i = 0; i < directorylist.length; i++) 
            {
                String filename = directorylist[i];
                if(filename.equalsIgnoreCase(savename))
                {
                    return true;
                }
            }
        } 
        return false;
    }
    
    public static boolean loadsaves(String mode)
    {
        File dir = new File("classes//saveFiles");
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
      
        String[] directorylist = dir.list();
        if(directorylist.length > 0)
        {
            String outFiles = "";

            for (int i = 0; i < directorylist.length; i++) 
            {
                outFiles+="\n"+directorylist[i]+"\n";
            }

            if(mode.equalsIgnoreCase("console"))
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++                 Saved Files                +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+outFiles+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n"+ANSI_RESET);
            }
            else
            {
                guiOpenSaves(outFiles);
            }           
            return true;
        }
        else
        {
            if(mode.equalsIgnoreCase("console"))
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++    There are no save files to be loaded    +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"There are no availabe saved files to be loaded","Available Saved Files",JOptionPane.PLAIN_MESSAGE);
            }
            return false;
        }
        
    }
    
    public static void guiOpenSaves(String outFiles)
    {
        boolean violation = false;
        String name=JOptionPane.showInputDialog(null,"Enter a name of the file to be loaded\n"+outFiles,"Available Saved Files",JOptionPane.PLAIN_MESSAGE);
        try {
            BufferedReader frd = new BufferedReader(new FileReader("classes//saveFiles//"+name+".txt"));
            String out = "";
            try {
                out = frd.readLine();
            } catch (IOException ex) {
                Logger.getLogger(SavedFiles.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Failed to load file(s)");
            }
            String[] buttons = { "Yes", "No",}; 
            int returnValue = JOptionPane.showOptionDialog(null, out+"\n---------------------------------------------------\nIs this the file you would like to load?", "Preview of save file : "+name, JOptionPane.PLAIN_MESSAGE,0,null,buttons,buttons);
            if(returnValue == 0)
            {
                JOptionPane.showMessageDialog(null, "loading your saved file(s)");
                String [] savefile = out.split(" ");
                Player player = new Player(savefile[0],name,getDifficulty());
                
                player.level = Integer.parseInt(savefile[1]);
                player.hp = Integer.parseInt(savefile[2]);
                player.attack = Integer.parseInt(savefile[3]);
                player.defense = Integer.parseInt(savefile[4]);
                player.artifact[0] = savefile[6];
                player.artifact[1] = savefile[7];
                player.artifact[2] = savefile[8];
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Player>> constraintViolations = validator.validate(player);
                if (constraintViolations.size() > 0)
                {
                    ConstraintViolation<Player> firstViolation = constraintViolations.iterator().next();
                    final String error = "ERROR !!! "+ firstViolation.getPropertyPath() + " -> " + firstViolation.getMessage() + " ('" + firstViolation.getInvalidValue() + "' given)";
                    JOptionPane.showMessageDialog(null, error);
                }
                else
                {
                    callToPlayerGui(player);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SavedFiles.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed to load saved file(s)");
        }
    }
    
    private static boolean loadfile()
    {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
      
        Scanner input2 = new Scanner(System.in);
        while(input2.hasNext())
        {
            String op = input2.nextLine();

            if(op.equalsIgnoreCase("yes"))
            {
                return true;
            }
            else if(op.equalsIgnoreCase("no"))
            {
                return false;
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"Invalid entry! [Options] 'yes' | 'no'"+ANSI_RESET);
            }    
        }
        return false;
    }

    public static void openSave()
    {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++ Enter the name of the saved file you want to load +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        
        Scanner input = new Scanner(System.in);
        String filename = "";
        
        while(input.hasNext())
        {
            filename = input.nextLine();
            if(checkNameAvailable(filename))
            {
                try {
                    BufferedReader frd = new BufferedReader(new FileReader("classes//saveFiles//"+filename+".txt"));
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Output of saved file"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"---------------------------------------------------"+ANSI_RESET);
                    
                    String out = "";
                    try {
                        out = frd.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(SavedFiles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+out+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"---------------------------------------------------"+ANSI_RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"Is this the file you would like to load? [Options] 'yes' | 'no'"+ANSI_RESET);
                    if(loadfile())
                    {
                        String [] savefile = out.split(" ");
                        Player player = new Player(savefile[0],filename,getDifficulty());
                        player.level = Integer.parseInt(savefile[1]);
                        player.hp = Integer.parseInt(savefile[2]);
                        player.attack = Integer.parseInt(savefile[3]);
                        player.defense = Integer.parseInt(savefile[4]);
                        player.artifact[0] = savefile[6];
                        player.artifact[1] = savefile[7];
                        player.artifact[2] = savefile[8];
                        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                        Validator validator = factory.getValidator();
                        boolean violation = false;
                        Set<ConstraintViolation<Player>> constraintViolations = validator.validate(player);
                        if (constraintViolations.size() > 0)
                        {
                            ConstraintViolation<Player> firstViolation = constraintViolations.iterator().next();
                            final String error = "ERROR !!! "+ firstViolation.getPropertyPath() + " -> " + firstViolation.getMessage() + " ('" + firstViolation.getInvalidValue() + "' given)";
                            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+error+ANSI_RESET);
                            violation = true;
                        }
                        else
                        {
                            displayStats(player);
                            Map map = new Map(player);
                            startGameLoop(player, map);
                        }
                       if(violation)
                       {
                           runConsole();
                       }
                    }
                    else
                    {
                        runConsole();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SavedFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            else
            {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++              The file does not exist                 +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"+++++   Please enter a existing file from the list below   +++++"+ANSI_RESET);
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
                loadsaves("Console");
            }
        }
    }

    public static void writeSavefile(String savename, String classtype, int level, int hp, int attack, int deffence, String action, String []artifact)
    {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("classes//saveFiles//"+savename+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SavedFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        writer.println(classtype+" "+level+" "+hp+" "+attack+" "+deffence+" "+action+" "+artifact[0]+" "+artifact[1]+" "+artifact[2]);
        writer.close(); 
    }
}