package GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitRestrictedAction_state;
import gameLogic.StateMachine.StatusReductionSelection_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusReductionSelectionPanel extends JPanel implements Observer {
    
    private ObservableGame observable;
    private JButton morale, supplies;
    private JLabel desc;

    public StatusReductionSelectionPanel(ObservableGame observable) {
        this.observable = observable;
        observable.addObserver(this);
        
        setOpaque(false);
        
        desc = new JLabel("Exchange for Action Points: ");
        morale = new JButton("Morale");
        supplies = new JButton("Supplies");
        
        add(desc);
        add(morale);
        add(supplies);
    
        morale.addActionListener(new MoraleListener());
        supplies.addActionListener(new SuppliesListener());
        
        update(this.observable, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        morale.setEnabled(observable.getGamedata().getMorale() > 0 && !observable.getGamedata().isExtraActionUsed());
        supplies.setEnabled(observable.getGamedata().getSupplies() > 0 && !observable.getGamedata().isExtraActionUsed());
        setVisible(observable.getState() instanceof StatusReductionSelection_state);
    }
    
    class MoraleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.statusSelection('m');
        }
    }
    
    class SuppliesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.statusSelection('s');
        }
    }    
}
