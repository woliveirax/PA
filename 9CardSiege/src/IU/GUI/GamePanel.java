package IU.GUI;

import gameLogic.Model.ObservableGame;
import IU.GUI.Views.ArcherAttackTrackSelection_Panel;
import IU.GUI.Views.AwaitRestart_Panel;
import IU.GUI.Views.AwaitRestrictedAction_Panel;
import IU.GUI.Views.AwaitTopCard_Panel;
import IU.GUI.Views.BoilingWaterTrackSelection_Panel;
import IU.GUI.Views.CastleBoardPanel;
import IU.GUI.Views.CloseCombatTrackSelection_Panel;
import IU.GUI.Views.Deck_Panel;
import IU.GUI.Views.DiceFaces_Panel;
import IU.GUI.Views.EnemyBoard_Panel;
import IU.GUI.Views.EnemyLineOptions_Panel;
import IU.GUI.Views.GamedataToString_Panel;
import IU.GUI.Views.GeneralOptions_Panel;
import IU.GUI.Views.Pt1TunnelOptions_Panel;
import IU.GUI.Views.Pt2TunnelOptions_Panel;
import IU.GUI.Views.RallySelection_Panel;
import IU.GUI.Views.StatusReductionSelection_Panel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    
    private EnemyBoard_Panel enemyPanel;
    
    //Panels
    private JPanel panelCenter;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JPanel panelLeft;
    private JPanel panelRight;
    
    //Labels info
    private JLabel days;
    private JLabel actionPoints;
    
    private Image backgroundImage; 
    
    public GamePanel(ObservableGame observable){
        this.observable = observable;
        observable.addObserver(this);
        
        SetupComponents();
        SetupLayout();        
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
        panelCenter = new JPanel();
        
        deckPanel = new Deck_Panel(observable);
        dicePanel = new DiceFaces_Panel(observable);
        enemyPanel = new EnemyBoard_Panel(observable);
        panelCenter.add(deckPanel);
        panelCenter.add(dicePanel);
        panelCenter.add(enemyPanel);
        
        
        panelRight = new JPanel();
        panelRight.setOpaque(false);
        panelRight.add(new CastleBoardPanel(observable));
        //falta criar views de cada carta de status
        //Criar view para dado
        //Criar View para Carta atual
    }
    
    private void CreateTopInfo(){
       Dimension d = new Dimension(150,20);
        days = new JLabel("Days: n/d");
        days.setFont(new Font("Arial", Font.BOLD, 18));
        days.setAlignmentX(Component.CENTER_ALIGNMENT);
        days.setMaximumSize(d);
        days.setPreferredSize(d);
        days.setMinimumSize(d);
        
        
        d = new Dimension(200,20);
        actionPoints = new JLabel("Action Points: n/d");
        actionPoints.setFont(new Font("Arial", Font.BOLD, 18));
        actionPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionPoints.setMaximumSize(d);
        actionPoints.setMinimumSize(d);
        actionPoints.setPreferredSize(d);
        
        panelTop = new JPanel();
        panelTop.add(days);
        panelTop.add(actionPoints);
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
        add(panelCenter,BorderLayout.WEST);
        add(panelRight,BorderLayout.EAST);
        add(new GamedataToString_Panel(observable),BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        int day = observable.getGamedata().getCurrentDay();
        int ap = observable.getGamedata().getActionPoints();
        
        days.setText("Days: " + day);
        actionPoints.setText("Action Points: " + ap);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage,0,0,this.getWidth(), this.getHeight(),this);
    }
    
}
