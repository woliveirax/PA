package IU.GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitPt1TunnelAction_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Pt1TunnelOptions_Panel extends JPanel implements Observer{
    private ObservableGame observableGame;
    private JButton archer_attack, boiling_attack, close_combat,coupure,
            extra_action,rally,move_pt2,fast_travel,exit_tunnel;

    public Pt1TunnelOptions_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        setOpaque(false);
        
        archer_attack = new JButton("Archer Attack");
        boiling_attack = new JButton("Boiling Attack");
        close_combat = new JButton("Close Combat");
        coupure = new JButton("Coupure");
        extra_action = new JButton("Extra Action");
        rally= new JButton("Rally");
        move_pt2= new JButton("Tunnel Pt2");
        fast_travel= new JButton("Fast Travel (EL)");
        exit_tunnel= new JButton("Exit Tunnel (Castle)"); 
                
         add(archer_attack);
         add(boiling_attack);
         add(close_combat);
         add(coupure);
         add(extra_action);
         add(rally);
         add(move_pt2);
         add(fast_travel);
         add(exit_tunnel);
         
        archer_attack.addActionListener(new ArcherAttackChoiceListener());
        boiling_attack.addActionListener(new BoilingAttackChoiceListener());
        close_combat.addActionListener(new CloseCombatChoiceListener());
        coupure.addActionListener(new CoupureChoiceListener());
        extra_action.addActionListener(new ExtraActionChoiceListener());
        rally.addActionListener(new RallyChoiceListener());
        move_pt2.addActionListener(new MoveToPt2ChoiceListener());
        fast_travel.addActionListener(new FastTravelChoiceListener());
        exit_tunnel.addActionListener(new ExitTunnelChoiceListener());
        
        update(observableGame, null);
    }
    
    class ArcherAttackChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.archerAttack();
        }
        
    }
    
    class BoilingAttackChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.boilingWater();        
        }
        
    }
    
    class CloseCombatChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.closeCombat1();        
        }
        
    }
    
    class CoupureChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.coupure();
        }
        
    }
    class ExtraActionChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.extraAction();
        }
        
    }
    class RallyChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.rally();
        }
        
    }
    
    class MoveToPt2ChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.moveForward();
        }
        
    }
    
    class FastTravelChoiceListener implements ActionListener{ //towards EnemyLines

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.fastTravel();
        }
        
    }
  
    class ExitTunnelChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.moveBackward();
        }
        
    }
    

   @Override
   public void update(Observable o, Object bjo){
       boiling_attack.setEnabled(!observableGame.getGamedata().isBoillingWaterUsed() &&
               observableGame.getGamedata().isAnyEnemyIn(1).size()>0);
       close_combat.setEnabled(observableGame.getGamedata().getCloseCombatArea().size()==1);
       extra_action.setEnabled(!observableGame.getGamedata().isExtraActionUsed());
       move_pt2.setEnabled(!observableGame.getGamedata().isFreeTunnelMoveUsed());
       exit_tunnel.setEnabled(!observableGame.getGamedata().isFreeTunnelMoveUsed());
       
       setVisible(observableGame.getState() instanceof AwaitPt1TunnelAction_state);
   }
    
    
}
