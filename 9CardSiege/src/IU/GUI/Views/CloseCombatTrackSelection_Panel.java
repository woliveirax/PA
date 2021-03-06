package IU.GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.CloseCombatTrackSelection_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CloseCombatTrackSelection_Panel extends JPanel implements Observer {
    
    private ObservableGame observable;
    private JButton enemy1, enemy2;
    
    
    public CloseCombatTrackSelection_Panel(ObservableGame observable) {
        this.observable = observable;
        observable.addObserver(this);
        
        setOpaque(false);
        
        enemy1 = new JButton("n.d.");
        enemy2 = new JButton("n.d.");
        
        add(enemy1);
        add(enemy2);
    
        enemy1.addActionListener(new AttackEnemy1Listener());
        enemy2.addActionListener(new AttackEnemy2Listener());
        
        update(this.observable, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.observable.getGamedata().getCloseCombatArea().size() == 2)
        {
            enemy1.setText(this.observable.getGamedata().getCloseCombatArea().get(0).toString());
            enemy2.setText(this.observable.getGamedata().getCloseCombatArea().get(1).toString());
        }
        setVisible(observable.getState() instanceof CloseCombatTrackSelection_state);
    }
    
    class AttackEnemy1Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.positionSelection(1);
        }
    }
    
    class AttackEnemy2Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.positionSelection(2);
        }
    }    
}
