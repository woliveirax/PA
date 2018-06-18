package IU.GUI.Views;

import IU.GUI.Constants.GameConstants;
import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitRestrictedAction_state;
import gameLogic.StateMachine.RallySelection_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RallySelection_Panel extends JPanel implements Observer,GameConstants {
    
    private ObservableGame observable;
    private JButton normalRoll, rollWithExtraDRM;

    public RallySelection_Panel(ObservableGame observable) {
        this.observable = observable;
        this.observable.addObserver(this);
        
        setOpaque(false);
        
        normalRoll = new JButton("Rally Troops");
        rollWithExtraDRM = new JButton("Rally Troops With +1 DRM");
        
        add(normalRoll);
        add(rollWithExtraDRM);
    
        normalRoll.addActionListener(new normalRollListener());
        rollWithExtraDRM.addActionListener(new rollWithExtraDRMListener());
        
        update(this.observable, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        rollWithExtraDRM.setEnabled(observable.getGamedata().getSupplies() > 0 &&
                observable.getGamedata().getMorale() < MAX_STATUS);
        
        setVisible(observable.getState() instanceof RallySelection_state);
    }
    
    class normalRollListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.extraMoral(false);
        }
    }
    
    class rollWithExtraDRMListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.extraMoral(true);
        }
    }
}
