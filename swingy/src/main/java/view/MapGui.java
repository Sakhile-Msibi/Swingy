package main.java.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import main.java.model.Map;

public class MapGui extends javax.swing.JPanel {
    public MapGui mapgui;
    private JButton squares[][];
    
    public MapGui(Map map, ImageIcon playericon) {
        initComponents();
        this.setLayout(new GridLayout(map.mapsize,map.mapsize));
        squares = new JButton[map.mapsize][map.mapsize];
        buildButtons(map,playericon);
    }

    private void buildButtons(Map map, ImageIcon playericon) {
        String dir = System.getProperty("user.dir");
        for(int i=0;i<map.mapsize;i++) {
            for(int j=0;j<map.mapsize;j++) {
                squares[i][j] = new JButton();
                squares[i][j].setSize(map.mapsize,map.mapsize);
                if(map.gamemap[i][j].equals("[X]"))
                {
                    squares[i][j].setIcon(playericon);
                }
                else if(map.gamemap[i][j].equals("[L]"))
                {
                    ImageIcon block = new ImageIcon(dir+"//classes//assets//lootbox.jpg");
                    squares[i][j].setIcon(block);
                }
                else if(map.gamemap[i][j].equals("[E]"))
                {
                    ImageIcon block = new ImageIcon(dir+"//classes//assets//enemyicon.jpg");
                    squares[i][j].setIcon(block);
                }
                else
                {
                    ImageIcon block = new ImageIcon(dir+"//classes//assets//kl.jpg");
                    squares[i][j].setIcon(block);
                }
                squares[i][j].setBackground(Color.black);
                squares[i][j].setBorderPainted(false);
                this.add(squares[i][j]);
            }
        }
    }

    public  void moveTest()
    {
        mapgui.squares[0][0].setBackground(Color.red);
    }
 
    @SuppressWarnings("unchecked")
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
    }
}