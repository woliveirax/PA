package GUI;

import GUI.Views.ArcherAttackTrackSelection_Panel;
import GUI.Views.AwaitRestartPanel;
import GUI.Views.AwaitRestrictedActionPanel;
import GUI.Views.AwaitTopCardPanel;
import GUI.Views.BoilingWaterTrackSelection_Panel;
import GUI.Views.CloseCombatTrackSelectionPanel;
import GUI.Views.EnemyLineOptions_Panel;
import GUI.Views.GeneralOptions_Panel;
import GUI.Views.Pt1TunnelOptions_Panel;
import GUI.Views.Pt2TunnelOptions_Panel;
import GUI.Views.RallySelectionPanel;
import GUI.Views.StatusReductionSelectionPanel;
import gameLogic.Model.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer{
    
    private ObservableGame observable;
    
    //Menu Panels
    private ArcherAttackTrackSelection_Panel    archerPanel;
    private AwaitRestartPanel                   restartPanel;
    private AwaitRestrictedActionPanel          restrictedPanel;
    private AwaitTopCardPanel                   drawCardPanel;
    private BoilingWaterTrackSelection_Panel    boilingWaterPanel;
    private CloseCombatTrackSelectionPanel      closeCombatTrackSelectionPanel;
    private EnemyLineOptions_Panel              enemyLineOptPanel;
    private GeneralOptions_Panel                generalOptPanel;
    private Pt1TunnelOptions_Panel              tunnel_pt1_panel;
    private Pt2TunnelOptions_Panel              tunnel_pt2_panel;
    private RallySelectionPanel                 rallyPanel;
    private StatusReductionSelectionPanel       statusReductionPanel;
    
    
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
        restartPanel = new AwaitRestartPanel(observable);
        restrictedPanel = new AwaitRestrictedActionPanel(observable);
        drawCardPanel = new AwaitTopCardPanel(observable);
        boilingWaterPanel = new BoilingWaterTrackSelection_Panel(observable);
        closeCombatTrackSelectionPanel = new CloseCombatTrackSelectionPanel(observable);
        enemyLineOptPanel = new EnemyLineOptions_Panel(observable);
        generalOptPanel = new GeneralOptions_Panel(observable);
        tunnel_pt1_panel = new Pt1TunnelOptions_Panel(observable);
        tunnel_pt2_panel = new Pt2TunnelOptions_Panel(observable);
        rallyPanel = new RallySelectionPanel(observable);
        statusReductionPanel = new StatusReductionSelectionPanel(observable);
        
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
        //falta criar views de cada carta de status
        //Criar view para baralho
        //Criar view para dado
        //Criar View para Carta atual
    }
    
    private void CreateTopInfo(){
        days = new JLabel("Days: n/d");
        days.setFont(new Font("Arial", Font.ITALIC, 12));
        days.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        actionPoints = new JLabel("Action Points: n/d");
        actionPoints.setFont(new Font("Arial", Font.ITALIC, 12));
        actionPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelTop = new JPanel();
        panelTop.add(days);
        panelTop.add(actionPoints);
    }
    
    private void SetupComponents(){
        CreateMenuPanels();
        CreateTopInfo();
    }
    
    private void SetupLayout(){
        
        setLayout(new BorderLayout());        
        add(panelTop, BorderLayout.NORTH);        
        add(panelBottom,BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable o, Object arg) {
        int day = observable.getGamedata().getCurrentDay();
        int ap = observable.getGamedata().getActionPoints();
        
        days.setText("Days: " + day);
        actionPoints.setText("Action Points: " + ap);
    }
}
