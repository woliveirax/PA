package GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitEnemyLineAction_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;


public class EnemyLineOptions_Panel extends JPanel implements Observer{
    private ObservableGame observableGame;
    private JButton archer_attack, boiling_attack, close_combat,coupure,
            extra_action,rally,sabotage,raid,enter_tunnel;

    public EnemyLineOptions_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        setOpaque(false);
        
        archer_attack = new JButton("Archer Attack");
        boiling_attack = new JButton("Boiling Attack");
        close_combat = new JButton("Close Combat");
        coupure = new JButton("Coupure");
        extra_action = new JButton("Extra Action");
        rally= new JButton("Rally");
        sabotage= new JButton("Sabotage");
        raid = new JButton("Raid");
        enter_tunnel = new JButton("Enter Tunnel");
                
         add(archer_attack);
         add(boiling_attack);
         add(close_combat);
         add(coupure);
         add(extra_action);
         add(rally);
         add(sabotage);
         add(raid);
         add(enter_tunnel);
         
        archer_attack.addActionListener(new ArcherAttackChoiceListener());
        boiling_attack.addActionListener(new BoilingAttackChoiceListener());
        close_combat.addActionListener(new CloseCombatChoiceListener());
        coupure.addActionListener(new CoupureChoiceListener());
        extra_action.addActionListener(new ExtraActionChoiceListener());
        rally.addActionListener(new RallyChoiceListener());
        sabotage.addActionListener(new SabotageChoiceListener());
        raid.addActionListener(new RaidChoiceListener());
        enter_tunnel.addActionListener(new EnterTunnelChoiceListener());
        
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
    
    class SabotageChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.sabotage();
        }
        
    }
    
    class RaidChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.raid();
        }
        
    }
    
    class EnterTunnelChoiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observableGame.enterTunnel();
        }
        
    }
    

   @Override
   public void update(Observable o, Object bjo){
       boiling_attack.setEnabled(!observableGame.getGamedata().isBoillingWaterUsed() &&
               (observableGame.getGamedata().getLadderPosition()==1 ||
               observableGame.getGamedata().getBatteringRamPosition()==1 ||
               observableGame.getGamedata().getTowerPosition()==1));
       close_combat.setEnabled(observableGame.getGamedata().getCloseCombatArea().size()==1);
       extra_action.setEnabled(!observableGame.getGamedata().isExtraActionUsed());
       
       setVisible(observableGame.getState() instanceof AwaitEnemyLineAction_state);
   }
    
    
}
