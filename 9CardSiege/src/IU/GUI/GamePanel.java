package IU.GUI;

import IU.GUI.Views.ArcherAttackTrackSelection_Panel;
import IU.GUI.Views.AwaitRestart_Panel;
import IU.GUI.Views.AwaitRestrictedAction_Panel;
import IU.GUI.Views.AwaitTopCard_Panel;
import IU.GUI.Views.BoilingWaterTrackSelection_Panel;
import IU.GUI.Views.CloseCombatTrackSelection_Panel;
import IU.GUI.Views.Deck_Panel;
import IU.GUI.Views.DiceFaces_Panel;
import IU.GUI.Views.EnemyLineOptions_Panel;
import IU.GUI.Views.GeneralOptions_Panel;
import IU.GUI.Views.Pt1TunnelOptions_Panel;
import IU.GUI.Views.Pt2TunnelOptions_Panel;
import IU.GUI.Views.RallySelection_Panel;
import IU.GUI.Views.StatusReductionSelection_Panel;
import gameLogic.Model.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer{
    
    private ObservableGame observable;
    
    //Menu Panels
    private ArcherAttackTrackSelection_Panel    archerPanel;
    private AwaitRestart_Panel                   restartPanel;
    private AwaitRestrictedAction_Panel          restrictedPanel;
    private AwaitTopCard_Panel                   drawCardPanel;
    private BoilingWaterTrackSelection_Panel    boilingWaterPanel;
    private CloseCombatTrackSelection_Panel      closeCombatTrackSelectionPanel;
    private EnemyLineOptions_Panel              enemyLineOptPanel;
    private GeneralOptions_Panel                generalOptPanel;
    private Pt1TunnelOptions_Panel              tunnel_pt1_panel;
    private Pt2TunnelOptions_Panel              tunnel_pt2_panel;
    private RallySelection_Panel                 rallyPanel;
    private StatusReductionSelection_Panel       statusReductionPanel;
    
    //Deck Panel
    private Deck_Panel deckPanel;//ALTEREI
    //dice panel
    private DiceFaces_Panel dicePanel;
    
    //Panels
    private JPanel panelCenter;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JPanel panelLeft;
    private JPanel panelRight;
    
    
    //Labels info
    private JLabel days;
    private JLabel actionPoints;
    
    
    public GamePanel(ObservableGame observable){
        this.observable = observable;
        observable.addObserver(this);
        
        SetupComponents();
        SetupLayout();        
    }
    
    private void CreateMenuPanels(){
        archerPanel = new ArcherAttackTrackSelection_Panel(observable);
        restartPanel = new AwaitRestart_Panel(observable);
        restrictedPanel = new AwaitRestrictedAction_Panel(observable);
        drawCardPanel = new AwaitTopCard_Panel(observable);
        boilingWaterPanel = new BoilingWaterTrackSelection_Panel(observable);
        closeCombatTrackSelectionPanel = new CloseCombatTrackSelection_Panel(observable);
        enemyLineOptPanel = new EnemyLineOptions_Panel(observable);
        generalOptPanel = new GeneralOptions_Panel(observable);
        tunnel_pt1_panel = new Pt1TunnelOptions_Panel(observable);
        tunnel_pt2_panel = new Pt2TunnelOptions_Panel(observable);
        rallyPanel = new RallySelection_Panel(observable);
        statusReductionPanel = new StatusReductionSelection_Panel(observable);
        
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
        
        deckPanel = new Deck_Panel(observable);//ALTEREI
        dicePanel = new DiceFaces_Panel(observable);
        panelCenter.add(deckPanel);//ALTEREI
        panelCenter.add(dicePanel);
        
        //falta criar views de cada carta de status
        //Criar view para baralho
        //Criar view para dado
        //Criar View para Carta atual
    }
    
    private void CreateTopInfo(){
        //TODO: make this bold and with more spacing in between
        days = new JLabel("Days: n/d");
        days.setFont(new Font("Arial", Font.BOLD, 18));
        days.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        actionPoints = new JLabel("Action Points: n/d");
        actionPoints.setFont(new Font("Arial", Font.BOLD, 18));
        actionPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelTop = new JPanel();
        panelTop.add(days);
        panelTop.add(actionPoints);
    }
    
    private void SetupComponents(){
        CreateMenuPanels();
        CreateTopInfo();
        CreateComponents();
    }
    
    private void SetupLayout(){
        
        setLayout(new BorderLayout());        
        add(panelTop, BorderLayout.NORTH);        
        add(panelBottom,BorderLayout.SOUTH);
        add(panelCenter,BorderLayout.WEST);//ALTEREI
    }

    @Override
    public void update(Observable o, Object arg) {
        int day = observable.getGamedata().getCurrentDay();
        int ap = observable.getGamedata().getActionPoints();
        
        days.setText("Days: " + day);
        actionPoints.setText("Action Points: " + ap);
    }
}
