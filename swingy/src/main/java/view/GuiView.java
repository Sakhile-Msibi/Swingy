package main.java.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Validator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import main.java.control.SavedFiles;
import static main.java.control.GameAction.playerRespawnHp;
import static main.java.control.Vaulthunter.CreateSaveFile;
import static main.java.control.Game.guiEvent;
import static main.java.control.Game.startGameLoop;
import main.java.model.Map;
import static main.java.model.Map.updateMap;
import main.java.model.Player;

public class GuiView extends javax.swing.JFrame {
    String directory = System.getProperty("user.dir");

    ImageIcon swati = new ImageIcon(directory+"//classes//assets//sobhuza.jpg");
    ImageIcon zulu = new ImageIcon(directory+"//classes//assets//zulu0.jpg");
    ImageIcon xhosa = new ImageIcon(directory+"//classes//assets//hintsa1.jpg");
    ImageIcon ndebele = new ImageIcon(directory+"//classes//assets//mzilikazi1.jpg");
    Player player;
    Map map;
    public GuiView gui;

    public GuiView() {
        initComponents();
        homeScreen.setVisible(false);
        therules.setVisible(false);
        createscreen.setVisible(false);
        gameScreen.setVisible(false);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        String dir = System.getProperty("user.dir");
        loadingPannel = new javax.swing.JPanel();
        loadingScreen = new javax.swing.JLabel();
        gameStart = new javax.swing.JButton();
        homeScreen = new javax.swing.JPanel();
        createCharbtn = new javax.swing.JButton();
        loadSavebtn = new javax.swing.JButton();
        gameRulesbtn = new javax.swing.JButton();
        creditsbtn = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        therules = new javax.swing.JPanel();
        rules = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        go_backrules = new javax.swing.JButton();
        createscreen = new javax.swing.JPanel();
        logo1 = new javax.swing.JLabel();
        selectcharIcon = new javax.swing.JLabel();
        charname = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        xp = new javax.swing.JLabel();
        hp = new javax.swing.JLabel();
        attack = new javax.swing.JLabel();
        deffence = new javax.swing.JLabel();
        confirmchar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        swatiselected = new javax.swing.JButton();
        zuluselected = new javax.swing.JButton();
        xhosaselected = new javax.swing.JButton();
        ndebeleselected = new javax.swing.JButton();
        actionskill = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        go_backrules1 = new javax.swing.JButton();
        gameScreen = new javax.swing.JPanel();
        logo3 = new javax.swing.JLabel();
        selectcharIcon1 = new javax.swing.JLabel();
        playerType = new javax.swing.JLabel();
        playerLevel = new javax.swing.JLabel();
        xpText = new javax.swing.JLabel();
        hpText = new javax.swing.JLabel();
        playerAttack = new javax.swing.JLabel();
        playerDefense = new javax.swing.JLabel();
        playerskill = new javax.swing.JLabel();
        skillAD = new javax.swing.JLabel();
        playerShield = new javax.swing.JLabel();
        hpBar = new javax.swing.JProgressBar();
        xpBar = new javax.swing.JProgressBar();
        playerGun = new javax.swing.JLabel();
        playerRelic = new javax.swing.JLabel();
        mapOutput = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        killsCount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        killsCount1 = new javax.swing.JLabel();
        back2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lootboxcount = new javax.swing.JLabel();
        upMove = new javax.swing.JButton();
        downMove = new javax.swing.JButton();
        leftMove = new javax.swing.JButton();
        rightMove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 204));

        loadingPannel.setBackground(new java.awt.Color(0, 0, 204));

        loadingScreen.setBackground(new java.awt.Color(0, 0, 204));
        loadingScreen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingScreen.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//load.gif")  );
        loadingScreen.setAlignmentY(-1.0F);
        loadingScreen.setAutoscrolls(true);

        gameStart.setBackground(new java.awt.Color(0, 0, 204));
        gameStart.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//pressstart.gif")  );
        gameStart.setAlignmentY(0.0F);
        gameStart.setAutoscrolls(true);
        gameStart.setBorder(null);
        gameStart.setBorderPainted(false);
        gameStart.setFocusPainted(false);
        gameStart.setFocusable(false);
        gameStart.setRequestFocusEnabled(false);
        gameStart.setSelected(true);
        gameStart.setSelectedIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//pressstart.gif")  );
        gameStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loadingPannelLayout = new javax.swing.GroupLayout(loadingPannel);
        loadingPannel.setLayout(loadingPannelLayout);
        loadingPannelLayout.setHorizontalGroup(
            loadingPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPannelLayout.createSequentialGroup()
                .addGroup(loadingPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingPannelLayout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(loadingScreen))
                    .addGroup(loadingPannelLayout.createSequentialGroup()
                        .addGap(574, 574, 574)
                        .addComponent(gameStart)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loadingPannelLayout.setVerticalGroup(
            loadingPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPannelLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(loadingScreen)
                .addGap(18, 18, 18)
                .addComponent(gameStart)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        homeScreen.setBackground(new java.awt.Color(0, 0, 204));

        createCharbtn.setBackground(new java.awt.Color(0, 0, 204));
        createCharbtn.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//createchar.gif")  );
        createCharbtn.setAlignmentY(0.0F);
        createCharbtn.setAutoscrolls(true);
        createCharbtn.setBorder(null);
        createCharbtn.setBorderPainted(false);
        createCharbtn.setFocusPainted(false);
        createCharbtn.setFocusable(false);
        createCharbtn.setRequestFocusEnabled(false);
        createCharbtn.setSelected(true);
        createCharbtn.setSelectedIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//createchar.gif")  );
        createCharbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCharbtnActionPerformed(evt);
            }
        });

        loadSavebtn.setBackground(new java.awt.Color(0, 0, 204));
        loadSavebtn.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//loadsave.gif")  );
        loadSavebtn.setAlignmentY(0.0F);
        loadSavebtn.setAutoscrolls(true);
        loadSavebtn.setBorder(null);
        loadSavebtn.setBorderPainted(false);
        loadSavebtn.setFocusPainted(false);
        loadSavebtn.setFocusable(false);
        loadSavebtn.setRequestFocusEnabled(false);
        loadSavebtn.setSelected(true);
        loadSavebtn.setSelectedIcon(   new javax.swing.ImageIcon(dir+"//classes//assets//loadsave.gif")  );
        loadSavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSavebtnActionPerformed(evt);
            }
        });

        gameRulesbtn.setBackground(new java.awt.Color(0, 0, 204));
        gameRulesbtn.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//rules.gif")  );
        gameRulesbtn.setAlignmentY(0.0F);
        gameRulesbtn.setAutoscrolls(true);
        gameRulesbtn.setBorder(null);
        gameRulesbtn.setBorderPainted(false);
        gameRulesbtn.setFocusPainted(false);
        gameRulesbtn.setFocusable(false);
        gameRulesbtn.setRequestFocusEnabled(false);
        gameRulesbtn.setSelected(true);
        gameRulesbtn.setSelectedIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//rules.gif")  );
        gameRulesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameRulesbtnActionPerformed(evt);
            }
        });

        creditsbtn.setBackground(new java.awt.Color(0, 0, 204));
       // creditsbtn.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//credith.gif")  );
        creditsbtn.setAlignmentY(0.0F);
        creditsbtn.setAutoscrolls(true);
        creditsbtn.setBorder(null);
        creditsbtn.setBorderPainted(false);
        creditsbtn.setFocusPainted(false);
        creditsbtn.setFocusable(false);
        creditsbtn.setRequestFocusEnabled(false);
        creditsbtn.setSelected(true);
        //creditsbtn.setSelectedIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//credith.gif")  );
        creditsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsbtnActionPerformed(evt);
            }
        });

        logo.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//logo.gif")  );

        jLabel1.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//africalegends.png")  );

        javax.swing.GroupLayout homeScreenLayout = new javax.swing.GroupLayout(homeScreen);
        homeScreen.setLayout(homeScreenLayout);
        homeScreenLayout.setHorizontalGroup(
            homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeScreenLayout.createSequentialGroup()
                .addGap(591, 591, 591)
                .addGroup(homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameRulesbtn)
                    .addGroup(homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(createCharbtn)
                        .addComponent(loadSavebtn)))
                .addGap(0, 584, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeScreenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeScreenLayout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(448, 448, 448))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeScreenLayout.createSequentialGroup()
                        .addComponent(creditsbtn)
                        .addGap(611, 611, 611))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeScreenLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(602, 602, 602))))
        );
        homeScreenLayout.setVerticalGroup(
            homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeScreenLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(logo)
                .addGap(40, 40, 40)
                .addComponent(createCharbtn)
                .addGap(35, 35, 35)
                .addComponent(loadSavebtn)
                .addGap(29, 29, 29)
                .addComponent(gameRulesbtn)
                .addGap(18, 18, 18)
                .addComponent(creditsbtn)
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        therules.setBackground(new java.awt.Color(0, 0, 204));

        rules.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//the rules.gif")  );

        logo2.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//logo.gif")  );

        go_backrules.setBackground(new java.awt.Color(0, 0, 204));
        go_backrules.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//back_f.gif")  );
        go_backrules.setBorder(null);
        go_backrules.setBorderPainted(false);
        go_backrules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_backrulesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout therulesLayout = new javax.swing.GroupLayout(therules);
        therules.setLayout(therulesLayout);
        therulesLayout.setHorizontalGroup(
            therulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(therulesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(therulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, therulesLayout.createSequentialGroup()
                        .addComponent(logo2)
                        .addGap(448, 448, 448))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, therulesLayout.createSequentialGroup()
                        .addGroup(therulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(go_backrules, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rules, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(372, 372, 372))))
        );
        therulesLayout.setVerticalGroup(
            therulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(therulesLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(logo2)
                .addGap(93, 93, 93)
                .addComponent(rules, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(go_backrules, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        createscreen.setBackground(new java.awt.Color(0, 0, 204));

        logo1.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//logo.gif")  );

        selectcharIcon.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//sobhuza.jpg")  );
        selectcharIcon.setToolTipText("");

        charname.setFont(new java.awt.Font("Impact", 1, 14));
        charname.setForeground(new java.awt.Color(255, 153, 0));
        charname.setText("Sobhuza WaseSwatini");

        level.setForeground(new java.awt.Color(255, 102, 0));
        level.setText("Level : 1");

        xp.setForeground(new java.awt.Color(255, 102, 0));
        xp.setText("Experience : 0/1000");

        hp.setForeground(new java.awt.Color(255, 102, 0));
        hp.setText("Hit Points : 80/80");

        attack.setForeground(new java.awt.Color(255, 102, 0));
        attack.setText("Attack : 30");

        deffence.setForeground(new java.awt.Color(255, 102, 0));
        deffence.setText("Deffence : 15");

        confirmchar.setBackground(new java.awt.Color(0, 0, 204));
        confirmchar.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//confirmsel.gif")  );
        confirmchar.setBorder(null);
        confirmchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmcharActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18));
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("CLASS SELECT");

        swatiselected.setBackground(new java.awt.Color(0, 0, 204));
        swatiselected.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//sobhuza1.jpg")  );
        swatiselected.setToolTipText("salt the wound");
        swatiselected.setBorder(null);
        swatiselected.setBorderPainted(false);
        swatiselected.setSelected(true);
        swatiselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swatiselectedActionPerformed(evt);
            }
        });

        zuluselected.setBackground(new java.awt.Color(0, 0, 204));
        zuluselected.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//zulu.png")  );
        zuluselected.setBorder(null);
        zuluselected.setBorderPainted(false);
        zuluselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zuluselectedActionPerformed(evt);
            }
        });

        xhosaselected.setBackground(new java.awt.Color(0, 0, 204));
        xhosaselected.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//mzilikazi.jpg")  );
        xhosaselected.setBorder(null);
        xhosaselected.setBorderPainted(false);
        xhosaselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ndebeleselectedActionPerformed(evt);
            }
        });

        ndebeleselected.setBackground(new java.awt.Color(0, 0, 204));
        ndebeleselected.setIcon(  new javax.swing.ImageIcon(dir+"//classes//assets//hintsa.jpg")  );
        ndebeleselected.setBorder(null);
        ndebeleselected.setBorderPainted(false);
        ndebeleselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xhosaselectedActionPerformed(evt);
            }
        });

        actionskill.setForeground(new java.awt.Color(255, 102, 0));
        actionskill.setText("Experience: Spear rampage");

        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("unlocks at level 3");

        go_backrules1.setBackground(new java.awt.Color(0, 0, 204));
        go_backrules1.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//back_f.gif"));
        go_backrules1.setBorder(null);
        go_backrules1.setBorderPainted(false);
        go_backrules1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_backrules1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createscreenLayout = new javax.swing.GroupLayout(createscreen);
        createscreen.setLayout(createscreenLayout);
        createscreenLayout.setHorizontalGroup(
            createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createscreenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(go_backrules1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294)
                .addComponent(logo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createscreenLayout.createSequentialGroup()
                .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createscreenLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ndebeleselected, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zuluselected, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(swatiselected, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xhosaselected, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createscreenLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createscreenLayout.createSequentialGroup()
                        .addComponent(confirmchar)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createscreenLayout.createSequentialGroup()
                        .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actionskill, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(deffence, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attack, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(charname, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createscreenLayout.createSequentialGroup()
                        .addComponent(selectcharIcon)
                        .addGap(150, 150, 150))))
        );
        createscreenLayout.setVerticalGroup(
            createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createscreenLayout.createSequentialGroup()
                .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(createscreenLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectcharIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(charname, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(level)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(attack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deffence)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionskill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(confirmchar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createscreenLayout.createSequentialGroup()
                        .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createscreenLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(logo1))
                            .addGroup(createscreenLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(go_backrules1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zuluselected, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(swatiselected, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(createscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(xhosaselected, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ndebeleselected, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(299, Short.MAX_VALUE))
        );

        gameScreen.setBackground(new java.awt.Color(0, 0, 204));

        logo3.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//logo.gif"));

        selectcharIcon1.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//sobhuza.jpg"));
        selectcharIcon1.setToolTipText("");

        playerType.setFont(new java.awt.Font("Impact", 1, 14));
        playerType.setForeground(new java.awt.Color(255, 153, 0));
        playerType.setText("Sobhuza WaseSwatini");

        playerLevel.setForeground(new java.awt.Color(255, 102, 0));
        playerLevel.setText("Level : 1");

        xpText.setForeground(new java.awt.Color(255, 102, 0));
        xpText.setText("Experience :");

        hpText.setForeground(new java.awt.Color(255, 102, 0));
        hpText.setText("Hit Points : ");

        playerAttack.setForeground(new java.awt.Color(255, 102, 0));
        playerAttack.setText("Attack : 30");

        playerDefense.setForeground(new java.awt.Color(255, 102, 0));
        playerDefense.setText("Defense : 15");

        playerskill.setForeground(new java.awt.Color(255, 102, 0));
        playerskill.setText("Experience: Spear rampage");

        skillAD.setForeground(new java.awt.Color(255, 51, 0));
        skillAD.setText("unlocks at level 3");

        playerShield.setForeground(new java.awt.Color(255, 102, 0));
        playerShield.setText("Shield : None");

        hpBar.setForeground(new java.awt.Color(0, 255, 0));
        hpBar.setMaximum(80);

        xpBar.setForeground(new java.awt.Color(255, 255, 0));

        playerGun.setForeground(new java.awt.Color(255, 102, 0));
        playerGun.setText("Gun : None");

        playerRelic.setForeground(new java.awt.Color(255, 102, 0));
        playerRelic.setText("Relic : None");

        mapOutput.setBackground(new java.awt.Color(0, 0, 204));
        mapOutput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 10, true));

        jLabel4.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//1.png"));
        jLabel4.setToolTipText("kills");

        killsCount.setFont(new java.awt.Font("Times New Roman", 1, 24));
        killsCount.setForeground(new java.awt.Color(255, 51, 0));
        killsCount.setText("0");

        // jLabel5.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//boss (2).png"));
        // jLabel5.setToolTipText("Boss Kills");

        // killsCount1.setFont(new java.awt.Font("Times New Roman", 1, 24));
        // killsCount1.setForeground(new java.awt.Color(255, 51, 0));
        // killsCount1.setText("0");

        back2.setBackground(new java.awt.Color(0, 0, 204));
        back2.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//back_f.gif"));
        back2.setBorder(null);
        back2.setBorderPainted(false);
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//chest.png"));
        jLabel6.setToolTipText("Loot box opened");

        lootboxcount.setFont(new java.awt.Font("Times New Roman", 1, 24));
        lootboxcount.setForeground(new java.awt.Color(255, 51, 0));
        lootboxcount.setText("0");

        upMove.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//up.png"));
        upMove.setBorder(null);
        upMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upMoveActionPerformed(evt);
            }
        });

        downMove.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//down.png"));
        downMove.setBorder(null);
        downMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downMoveActionPerformed(evt);
            }
        });

        leftMove.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//left.png"));
        leftMove.setBorder(null);
        leftMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftMoveActionPerformed(evt);
            }
        });

        rightMove.setIcon(new javax.swing.ImageIcon(dir+"//classes//assets//right.png"));
        rightMove.setToolTipText("");
        rightMove.setBorder(null);
        rightMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameScreenLayout = new javax.swing.GroupLayout(gameScreen);
        gameScreen.setLayout(gameScreenLayout);
        gameScreenLayout.setHorizontalGroup(
            gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameScreenLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gameScreenLayout.createSequentialGroup()
                                .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(301, 301, 301)
                                .addComponent(logo3)
                                .addGap(26, 26, 26))
                            .addGroup(gameScreenLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(killsCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(killsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lootboxcount, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(342, Short.MAX_VALUE))
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectcharIcon1)
                            .addComponent(playerAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerShield, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerGun, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerRelic, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerskill, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(gameScreenLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(skillAD))
                            .addGroup(gameScreenLayout.createSequentialGroup()
                                .addComponent(hpText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hpBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gameScreenLayout.createSequentialGroup()
                                .addComponent(xpText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xpBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(playerLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(mapOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameScreenLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(downMove, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(upMove, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(102, 102, 102))
                            .addGroup(gameScreenLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(leftMove, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rightMove, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))))
        );
        gameScreenLayout.setVerticalGroup(
            gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameScreenLayout.createSequentialGroup()
                .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(logo3)))
                .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(selectcharIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(playerType, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(playerLevel)
                        .addGap(18, 18, 18)
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xpText)
                            .addComponent(xpBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hpText)
                            .addComponent(hpBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerAttack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerDefense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerShield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerGun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerRelic)
                        .addGap(18, 18, 18)
                        .addComponent(playerskill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skillAD))
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(killsCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lootboxcount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(killsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameScreenLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(upMove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leftMove)
                            .addComponent(rightMove))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downMove, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(createscreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gameScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loadingPannel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(therules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loadingPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(therules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createscreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void gameStartActionPerformed(java.awt.event.ActionEvent evt) {
        // sets the loading panel to false when start game is clicked
        loadingPannel.setVisible(false);
        homeScreen.setVisible(true);
    }

    private void createCharbtnActionPerformed(java.awt.event.ActionEvent evt) {
         homeScreen.setVisible(false);
         charname.setText("Sobhuza WaseSwatini");
         hp.setText("Hit Points : 80/80");
         attack.setText("Attack : 10");
         deffence.setText("Defense : 13");
         actionskill.setText("experience : Spear rampage");
         createscreen.setVisible(true);
    }

    private void loadSavebtnActionPerformed(java.awt.event.ActionEvent evt) {
        SavedFiles.loadsaves("gui");
    }

    private void gameRulesbtnActionPerformed(java.awt.event.ActionEvent evt) {
        therules.setVisible(true);
        homeScreen.setVisible(false);
    }

    private void creditsbtnActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void go_backrulesActionPerformed(java.awt.event.ActionEvent evt) {
        therules.setVisible(false);
        homeScreen.setVisible(true);
    }

    private void swatiselectedActionPerformed(java.awt.event.ActionEvent evt) {
        selectcharIcon.setIcon(swati);
        charname.setText("Sobhuza WaseSwatini");
        hp.setText("Hit Points : 80/80");
        attack.setText("Attack : 10");
        deffence.setText("Defense : 13");
        actionskill.setText("Experience : Spear rampage");
    }

    private void zuluselectedActionPerformed(java.awt.event.ActionEvent evt) {
        selectcharIcon.setIcon(zulu);
        charname.setText("Shaka WakaZulu");
        hp.setText("Hit Points : 75/75");
        attack.setText("Attack : 6");
        deffence.setText("Defense : 22");
        actionskill.setText("Experience : Phase Lock");
    }

    private void ndebeleselectedActionPerformed(java.awt.event.ActionEvent evt) {
        selectcharIcon.setIcon(ndebele);
        charname.setText("Mzilikazi WamaNdebele");
        hp.setText("Hit Points : 76/76");
        attack.setText("Attack : 7");
        deffence.setText("Defense : 20");
        actionskill.setText("Experience : Rack attack");
    }

    private void xhosaselectedActionPerformed(java.awt.event.ActionEvent evt) {
        selectcharIcon.setIcon(xhosa);
        charname.setText("Hinsta WamaXhosa");
        hp.setText("Hit Points : 75/75");
        attack.setText("Attack : 5");
        deffence.setText("Defense : 23");
        actionskill.setText("Experience : Death trap");
    }

    private String returnClassType(String charlable)
    {
        if(charlable.equalsIgnoreCase("Mzilikazi WamaNdebele"))
        {
            return "Ndebele";
        }
        else if (charlable.equalsIgnoreCase("Hinsta WamaXhosa"))
        {
            return "Xhosa";
        }
        else if (charlable.equalsIgnoreCase("Shaka WakaZulu"))
        {
            return "Zulu";
        }
        else
        {
           return "Swati" ;
        }
    }

    private int getDificulty()
    {
        String[] buttons = { "Easy", "Normal","Hard", "Vaulthunter"}; 
         int returnValue = JOptionPane.showOptionDialog(null, "Difficulty Settings "+charname.getText(),"\tSelect your Difficulty Mode",
        JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
        return returnValue;
    }

    public static void callToPlayerGui(Player player)
    {
        GuiView gui = new GuiView();
        gui.loadPlayerGui(player);
    }

    public void loadPlayerGui(Player player)
    {
        String dir = System.getProperty("user.dir");
        createscreen.setVisible(false);
        gameScreen.setVisible(true);
        JOptionPane.showMessageDialog(null,"By using this station, you have forfeited your right to reproduce.");
        map = new Map(player);
        playerRespawnHp(player);
        ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pUp.jpg");
        MapGui mapgui = new MapGui(map, playericon);
        this.add(mapgui);
        mapOutput.setViewportView(mapgui);
        Rectangle bounds = mapOutput.getViewport().getViewRect();
        Dimension size = mapOutput.getViewport().getViewSize();
        int x = (size.width - bounds.width) / 2;
        int y = (size.height - bounds.height) / 2;  
        mapOutput.getViewport().setViewPosition(new Point(x, y));
        hpBar.setMaximum(player.hp);
        setCharacterStats(player);
    }

    public  void respawnGui(Player player)
    {
        String dir = System.getProperty("user.dir");
        JOptionPane.showMessageDialog(null," The bright light you saw after death is Hyperion corporation digistruct technology");
        map = new Map(player);
        playerRespawnHp(player);
        ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pUp.jpg");
        MapGui mapgui = new MapGui(map, playericon);
        this.add(mapgui);
        mapOutput.setViewportView(mapgui);
        Rectangle bounds = mapOutput.getViewport().getViewRect();
        Dimension size = mapOutput.getViewport().getViewSize();
        int x = (size.width - bounds.width) / 2;
        int y = (size.height - bounds.height) / 2;  
        mapOutput.getViewport().setViewPosition(new Point(x, y));
        hpBar.setMaximum(player.hp);
        setCharacterStats(player);
    }

    public static void callToRespawn(Player player)
    {
        GuiView gui = new GuiView();
        gui.respawnGui(player);
    }

    private void confirmcharActionPerformed(java.awt.event.ActionEvent evt) {
        String dir = System.getProperty("user.dir");
        String[] buttons = { "Yes", "No",}; 
        boolean savefile = false;
        String saveFile ;
        int returnValue = JOptionPane.showOptionDialog(null, "Play game as "+charname.getText(),"Confirm Character",
        JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons);
        if(returnValue == 0)
        {
           saveFile = JOptionPane.showInputDialog(null,"Enter a name for your game save");
           savefile = SavedFiles.checkNameAvailable(saveFile);
           while(savefile){
                saveFile = JOptionPane.showInputDialog(null,"Save file already exist.Please input a different name");
                savefile = SavedFiles.checkNameAvailable(saveFile);
            }
            player = new Player(returnClassType(charname.getText()),saveFile,getDificulty());
            player.guiConsole = true;
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            boolean violation = false;
            Set<ConstraintViolation<Player>> constraintViolations = validator.validate(player);
            if (constraintViolations.size() > 0) {
                ConstraintViolation<Player> firstViolation = constraintViolations.iterator().next();
                final String error = "ERROR !!! "+ firstViolation.getPropertyPath() + " -> " + firstViolation.getMessage() + " ('" + firstViolation.getInvalidValue() + "' given)";
                JOptionPane.showMessageDialog(null, error);
                violation = true;
            }
            else
            {
                map = new Map(player);
             
                CreateSaveFile(player);
                JOptionPane.showMessageDialog(rootPane, "Your save file '"+saveFile+"' has been created");
                createscreen.setVisible(false);
                gameScreen.setVisible(true);
                ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pUp.jpg");
                MapGui mapgui = new MapGui(map, playericon);
                this.add(mapgui);
                mapOutput.setViewportView(mapgui);
                Rectangle bounds = mapOutput.getViewport().getViewRect();
                Dimension size = mapOutput.getViewport().getViewSize();
                int x = (size.width - bounds.width) / 2;
                int y = (size.height - bounds.height) / 2;
                mapOutput.getViewport().setViewPosition(new Point(x, y));
                hpBar.setMaximum(player.hp);
                setCharacterStats(player);
            }
        }
    }
        
    private void setCharacterStats(Player player) {
        hpBar.setValue(player.hp);
        if(player.classType.equals("Zulu"))
        {
            selectcharIcon1.setIcon(zulu);
            playerType.setText("Shaka WakaZulu");
        }
        else if(player.classType.equals("Xhosa"))
        {
            playerType.setText("Hinsta WamaXhosa");
           selectcharIcon1.setIcon(xhosa);
        }
        else if(player.classType.equals("Swati"))
        {
           playerType.setText("Sobhuza WaseSwatini");
          selectcharIcon1.setIcon(swati);
        }
        else
        {
          playerType.setText("Mzilikazi WamaNdebele");
          selectcharIcon1.setIcon(ndebele);
        }
        playerLevel.setText("Level : "+player.level);
        xpBar.setValue(player.xp);
        playerAttack.setText("Attack : "+player.attack);
        playerDefense.setText("Defense : "+player.defense);
        playerShield.setText("Shield : "+player.artifact[0]);
        playerGun.setText("Gun : "+player.artifact[1]);
        playerRelic.setText("Relic : "+player.artifact[2]);
        playerskill.setText("Experience : "+player.action);
        if(player.level > 2)
        {
            skillAD.setText("[Skill Available]");
        }
    }
    
    private void go_backrules1ActionPerformed(java.awt.event.ActionEvent evt) {
        homeScreen.setVisible(true);
        createscreen.setVisible(false);
    }
    
    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {
        homeScreen.setVisible(true);
        gameScreen.setVisible(false);
    }
    
    private void upMoveActionPerformed(java.awt.event.ActionEvent evt) {
        String dir = System.getProperty("user.dir");
        sendCommand("n");
        ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pUp.jpg");
        MapGui mapgui = new MapGui(map, playericon);
        this.add(mapgui);
        mapOutput.setViewportView(mapgui);
    }
    
    public void sendCommand(String cmd)
    {
        guiEvent(cmd, player);
    }
    
    private void downMoveActionPerformed(java.awt.event.ActionEvent evt) {
        String dir = System.getProperty("user.dir");
        sendCommand("s");
        ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pDown.jpg");
        MapGui mapgui = new MapGui(map, playericon);
        this.add(mapgui);
        mapOutput.setViewportView(mapgui);
        loadingPannel.isVisible();
    }
    
    private void leftMoveActionPerformed(java.awt.event.ActionEvent evt) {
        String dir = System.getProperty("user.dir");
        sendCommand("w");
        ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pLeft.jpg");
         MapGui mapgui = new MapGui(map, playericon);
        this.add(mapgui);
        mapOutput.setViewportView(mapgui);
    }
    
    private void rightMoveActionPerformed(java.awt.event.ActionEvent evt) {
        String dir = System.getProperty("user.dir");
        sendCommand("e");
        ImageIcon playericon = new ImageIcon(dir+"//classes//assets//pRight.jpg");
        MapGui mapgui = new MapGui(map, playericon);
        this.add(mapgui);
        mapOutput.setViewportView(mapgui);
    }

    private javax.swing.JLabel actionskill;
    private javax.swing.JLabel attack;
    private javax.swing.JButton back2;
    private javax.swing.JButton ndebeleselected;
    private javax.swing.JLabel charname;
    private javax.swing.JTextArea combatArea;
    private javax.swing.JButton confirmchar;
    private javax.swing.JButton createCharbtn;
    private javax.swing.JPanel createscreen;
    private javax.swing.JButton creditsbtn;
    private javax.swing.JLabel deffence;
    private javax.swing.JButton downMove;
    private javax.swing.JButton gameRulesbtn;
    private javax.swing.JPanel gameScreen;
    private javax.swing.JButton gameStart;
    private javax.swing.JButton go_backrules;
    private javax.swing.JButton go_backrules1;
    private javax.swing.JPanel homeScreen;
    private javax.swing.JLabel hp;
    private javax.swing.JProgressBar hpBar;
    private javax.swing.JLabel hpText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel killsCount;
    private javax.swing.JLabel killsCount1;
    private javax.swing.JButton leftMove;
    private javax.swing.JLabel level;
    private javax.swing.JButton loadSavebtn;
    private javax.swing.JPanel loadingPannel;
    private javax.swing.JLabel loadingScreen;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel logo3;
    private javax.swing.JLabel lootboxcount;
    private javax.swing.JScrollPane mapOutput;
    private javax.swing.JButton xhosaselected;
    private javax.swing.JLabel playerAttack;
    private javax.swing.JLabel playerDefense;
    private javax.swing.JLabel playerGun;
    private javax.swing.JLabel playerLevel;
    private javax.swing.JLabel playerRelic;
    private javax.swing.JLabel playerShield;
    private javax.swing.JLabel playerType;
    private javax.swing.JLabel playerskill;
    private javax.swing.JButton swatiselected;
    private javax.swing.JButton rightMove;
    private javax.swing.JLabel rules;
    private javax.swing.JLabel selectcharIcon;
    private javax.swing.JLabel selectcharIcon1;
    private javax.swing.JButton zuluselected;
    private javax.swing.JLabel skillAD;
    private javax.swing.JPanel therules;
    private javax.swing.JButton upMove;
    private javax.swing.JLabel xp;
    private javax.swing.JProgressBar xpBar;
    private javax.swing.JLabel xpText;
}