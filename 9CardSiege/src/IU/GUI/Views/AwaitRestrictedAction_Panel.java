package GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitRestrictedAction_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AwaitRestrictedAction_Panel extends JPanel implements Observer {
    
    private ObservableGame observable;
    private JButton sabotage, raid;

    public AwaitRestrictedAction_Panel(ObservableGame observable) {
        this.observable = observable;
        observable.addObserver(this);
        
        setOpaque(false);
        
        sabotage = new JButton("Sabotage");
        raid = new JButton("Raid");
        
        add(sabotage);
        add(raid);
    
        sabotage.addActionListener(new SabotageListener());
        raid.addActionListener(new RaidListener());
        
        update(this.observable, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(observable.getState() instanceof AwaitRestrictedAction_state);
    }
    
    class SabotageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.sabotage();
        }
    }
    
    class RaidListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.raid();
        }
    }
    
    
}
