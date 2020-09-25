package main.java.control;

import java.awt.Frame;
import java.io.IOException;
import javax.swing.JOptionPane;
import main.java.view.ConsoleView;
import main.java.view.GuiView;

public class Swingy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void main(String[] args) {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++                                       +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++           Welcome To Swingy           +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++               OPTIONS                 +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++          'console' | 'gui'            +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++                                       +++++"+ANSI_RESET);
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
        if(args.length != 1)
        {
            if(args.length < 1)
            {
                JOptionPane.showMessageDialog(null, "Please enter one of the following options.\n console | gui","Error",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please only enter one option.\n console or gui","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(args[0].equalsIgnoreCase("console"))
        {
             ConsoleView.runConsole();
        }
        else if(args[0].equalsIgnoreCase("gui"))
        {
            GuiView gui = new GuiView();
           gui.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid option. Please enter one of the following options.\n console | gui ","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}