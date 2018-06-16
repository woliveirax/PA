package GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.ArcherAttackTrackSelection_state;
import gameLogic.StateMachine.BoilingAttackTrackSelection_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ArcherAttackTrackSelection_Panel extends JPanel implements Observer{
    private ObservableGame observableGame;
    private JButton ladders, battering_ram, siege_tower;
    
    public ArcherAttackTrackSelection_Panel(ObservableGame observableGame) {
        
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        setOpaque(false);
        
        ladders= new JButton("Ladders");
        battering_ram= new JButton("Battering Ram");
        siege_tower = new JButton("SiegeTower");
        
        add(ladders);
        add(battering_ram);
        add(siege_tower);
        
        ladders.addActionListener(new LaddersChoiceListener());
        battering_ram.addActionListener(new BatterimRamChoiceListener());
        siege_tower.addActionListener(new SiegeTowerChoiceListener());
      
        update(observableGame,null);
    }

    class LaddersChoiceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            observableGame.trackSelection(1);//1=Ladders
        }
    }
    class BatterimRamChoiceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            observableGame.trackSelection(2);//2=BatterimRam
        }
    }
    class SiegeTowerChoiceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            observableGame.trackSelection(3);//3=SiegeTower
        }
    }
    
    @Override
    public void update(Observable o,Object obj) {
        
        ladders.setEnabled(observableGame.getGamedata().getLadderPosition()>0);
        battering_ram.setEnabled(observableGame.getGamedata().getBatteringRamPosition()>0);
        siege_tower.setEnabled(observableGame.getGamedata().isTowerInGame() && 
                observableGame.getGamedata().getTowerPosition()>0);
        
        setVisible((observableGame.getState() instanceof ArcherAttackTrackSelection_state));
    }
    
    
}
 