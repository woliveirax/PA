package IU.GUI;

import gameLogic.Model.ObservableGame;
import IU.GUI.Views.ArcherAttackTrackSelection_Panel;
import IU.GUI.Views.AwaitRestart_Panel;
import IU.GUI.Views.AwaitRestrictedAction_Panel;
import IU.GUI.Views.AwaitTopCard_Panel;
import IU.GUI.Views.BoilingWaterTrackSelection_Panel;
import IU.GUI.Views.CastleBoard_Panel;
import IU.GUI.Views.CloseCombatTrackSelection_Panel;
import IU.GUI.Views.Deck_Panel;
import IU.GUI.Views.DiceFaces_Panel;
import IU.GUI.Views.EnemyBoard_Panel;
import IU.GUI.Views.EnemyLineOptions_Panel;
import IU.GUI.Views.GameEnding_Panel;
import IU.GUI.Views.GamedataToString_Panel;
import IU.GUI.Views.GeneralOptions_Panel;
import IU.GUI.Views.ImgsRefletingGameStatus_Panel;
import IU.GUI.Views.NonRepeatableActionsPossible_Panel;
import IU.GUI.Views.Pt1TunnelOptions_Panel;
import IU.GUI.Views.Pt2TunnelOptions_Panel;
import IU.GUI.Views.RallySelection_Panel;
import IU.GUI.Views.StatusReductionSelection_Panel;
import IU.GUI.Views.ViewCard_Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel implements Observer{
    
    private ObservableGame observable;
    
    //Menu Panels
    private ArcherAttackTrackSelection_Panel   archerPanel;
    private AwaitRestart_Panel                 restartPanel;
    private AwaitRestrictedAction_Panel        restrictedPanel;
    private AwaitTopCard_Panel                 drawCardPanel;
    private BoilingWaterTrackSelection_Panel   boilingWaterPanel;
    private CloseCombatTrackSelection_Panel    closeCombatTrackSelectionPanel;
    private EnemyLineOptions_Panel             enemyLineOptPanel;
    private GeneralOptions_Panel               generalOptPanel;
    private Pt1TunnelOptions_Panel             tunnel_pt1_panel;
    private Pt2TunnelOptions_Panel             tunnel_pt2_panel;
    private RallySelection_Panel               rallyPanel;
    private StatusReductionSelection_Panel     statusReductionPanel;
    
    //Deck Panel
    private Deck_Panel deckPanel;
    
    //dice panel
    private DiceFaces_Panel dicePanel;
    
    //Game Status Panel
    private CastleBoard_Panel castlePanel;
    
    //Card Panel
    private ViewCard_Panel cardPanel;
            
    //Enemy Board Panel
    private EnemyBoard_Panel enemyPanel;
    
    //User info Board
    private NonRepeatableActionsPossible_Panel infoPanel;
    
    //Game Over Screen
    private GameEnding_Panel endingPanel;
    
    //Image Game Status Screen
    private ImgsRefletingGameStatus_Panel gameStatusPanel;
    
    //Panels
    private JPanel panelCenter;
    private JPanel panelTop;
    private JPanel panelBottom;
    
    //Labels info
    private JLabel days;
    private JLabel actionPoints;
    private JLabel turn;
    
    private Image backgroundImage; 
    
    public GamePanel(ObservableGame observable){
        this.observable = observable;
        observable.addObserver(this);
        
        SetupComponents();
        SetupLayout();
        
        update(observable, null);
    }
    
    private void CreateMenuPanels(){
        archerPanel                     = new ArcherAttackTrackSelection_Panel(observable);
        restartPanel                    = new AwaitRestart_Panel(observable);
        restrictedPanel                 = new AwaitRestrictedAction_Panel(observable);
        drawCardPanel                   = new AwaitTopCard_Panel(observable);
        boilingWaterPanel               = new BoilingWaterTrackSelection_Panel(observable);
        closeCombatTrackSelectionPanel  = new CloseCombatTrackSelection_Panel(observable);
        enemyLineOptPanel               = new EnemyLineOptions_Panel(observable);
        generalOptPanel                 = new GeneralOptions_Panel(observable);
        tunnel_pt1_panel                = new Pt1TunnelOptions_Panel(observable);
        tunnel_pt2_panel                = new Pt2TunnelOptions_Panel(observable);
        rallyPanel                      = new RallySelection_Panel(observable);
        statusReductionPanel            = new StatusReductionSelection_Panel(observable);
        
        panelBottom = new JPanel();
        panelBottom.add(archerPanel);        
        panelBottom.add(restartPanel);
        panelBottom.add(restrictedPanel);
        panelBottom.add(drawCardPanel);
        panelBottom.add(boilingWaterPanel);
        panelBottom.add(closeCombatTrackSelectionPanel);
        panelBottom.add(enemyLineOptPanel);
        panelBottom.add(generalOptPanel);
        panelBottom.add(tunnel_pt1_panel);
        panelBottom.add(tunnel_pt2_panel);
        panelBottom.add(rallyPanel);
        panelBottom.add(statusReductionPanel);
    }
    
    private void CreateComponents(){
        
        //Cria Paineis interativos
        deckPanel   = new Deck_Panel(observable);
        dicePanel   = new DiceFaces_Panel(observable);
        enemyPanel  = new EnemyBoard_Panel(observable);
        castlePanel = new CastleBoard_Panel(observable);
        cardPanel   = new ViewCard_Panel(observable);
        infoPanel   = new NonRepeatableActionsPossible_Panel(observable);
        endingPanel = new GameEnding_Panel(observable);
        gameStatusPanel = new ImgsRefletingGameStatus_Panel(observable);
        
        deckPanel.setOpaque(false);
        dicePanel.setOpaque(false);
        enemyPanel.setOpaque(false);
        castlePanel.setOpaque(false);
        cardPanel.setOpaque(false);
        endingPanel.setOpaque(false);
        gameStatusPanel.setOpaque(false);
        
        //Cria Borders
        infoPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        enemyPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        castlePanel.setBorder(BorderFactory.createRaisedBevelBorder());
        cardPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        //dicePanel.setBorder(BorderFactory.createRaisedBevelBorder());
        
        //Cria boxes iniciais
        Box verticalBox = Box.createVerticalBox();
        Box lowerHBox = Box.createHorizontalBox();
        Box upperHBox = Box.createHorizontalBox();
        Box endTextHBox = Box.createHorizontalBox();
        
        verticalBox.setOpaque(false);
        lowerHBox.setOpaque(false);
        upperHBox.setOpaque(false);
        endTextHBox.setOpaque(false);
        
        verticalBox.add(Box.createVerticalStrut(10));
        verticalBox.add(upperHBox);
        verticalBox.add(Box.createVerticalStrut(20));
        verticalBox.add(lowerHBox);
        verticalBox.add(Box.createVerticalStrut(20));
        verticalBox.add(endTextHBox);
        
        upperHBox.add(cardPanel);
        upperHBox.add(Box.createHorizontalStrut(20));
        upperHBox.add(castlePanel);
        upperHBox.add(Box.createHorizontalStrut(20));
        upperHBox.add(enemyPanel);
        
        //Cria 2 vertical boxes dentro lower Horizontal
        Box lowerVBoxLeft = Box.createVerticalBox();
        Box lowerVBoxCenter = Box.createVerticalBox();
        
        lowerHBox.setAlignmentX(CENTER_ALIGNMENT);
        lowerHBox.add(lowerVBoxLeft);
        lowerHBox.add(lowerVBoxCenter);
        
        //Add ending text panel to box
        endTextHBox.add(endingPanel);
        
        //Adiciona box horizontais dentro da box mais a esquerda.
        Box deckNdiceHBox = Box.createHorizontalBox();
        lowerVBoxLeft.add(deckNdiceHBox);
        
        
        //Adiciona dois paineis à box mais a esquerda.
        deckNdiceHBox.add(gameStatusPanel);
        deckNdiceHBox.add(Box.createHorizontalStrut(15));
        deckNdiceHBox.add(deckPanel);
        deckNdiceHBox.add(Box.createHorizontalStrut(15));
        deckNdiceHBox.add(dicePanel);
        deckNdiceHBox.add(Box.createHorizontalStrut(15));
        
        //Adiciona painel de info na box do centro
        deckNdiceHBox.add(infoPanel);
        
        
        panelCenter = new JPanel();
        panelCenter.add(verticalBox);
        
        panelCenter.setOpaque(false);
    }
    
    private void CreateTopInfo(){
        
        Dimension x = new Dimension(190,20);
        days = new JLabel();
        days.setFont(new Font("Helvetica", Font.BOLD, 18));
        days.setAlignmentX(Component.CENTER_ALIGNMENT);
        days.setPreferredSize(x);
        days.setMaximumSize(x);
        days.setMinimumSize(x);
        
        x = new Dimension(200,20);
        actionPoints = new JLabel();
        actionPoints.setFont(new Font("Helvetica", Font.BOLD, 18));
        actionPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionPoints.setPreferredSize(x);
        actionPoints.setMinimumSize(x);
        actionPoints.setMaximumSize(x);
        
        turn = new JLabel();
        turn.setFont(new Font("Helvetica", Font.BOLD, 18));
        turn.setAlignmentX(Component.CENTER_ALIGNMENT);
        turn.setPreferredSize(x);
        turn.setMaximumSize(x);
        turn.setMinimumSize(x);
        
        panelTop = new JPanel();
        panelTop.add(days);
        panelTop.add(actionPoints);
        panelTop.add(turn);
        panelTop.setAlignmentX(CENTER_ALIGNMENT);
        panelTop.setOpaque(true);
    }
    
    private void SetupComponents(){
        backgroundImage = Resources.getBackground();
        
        CreateMenuPanels();
        CreateTopInfo();
        CreateComponents();
    }
    
    
    private void SetupLayout(){
        setLayout(new BorderLayout());        
        add(panelTop, BorderLayout.NORTH);        
        add(panelBottom,BorderLayout.SOUTH);
        add(panelCenter,BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        int day = observable.getGamedata().getCurrentDay();
        int ap = observable.getGamedata().getActionPoints();
        int t = 7 - observable.getGamedata().getSizeOfDeck();
        
        days.setText("Current Day: " + day);
        actionPoints.setText("Action Points: " + ap);
        turn.setText("Current Turn: " + t);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(backgroundImage,0,0,this.getWidth(), this.getHeight(),this);
    }
    
}
