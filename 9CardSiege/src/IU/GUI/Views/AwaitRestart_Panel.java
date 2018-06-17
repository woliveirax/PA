package GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitRestart_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AwaitRestart_Panel extends JPanel implements Observer {
    
    private ObservableGame observable;
    private JButton restart, leave;

    public AwaitRestart_Panel(ObservableGame observable) {
        this.observable = observable;
        observable.addObserver(this);
        
        setOpaque(false);
        
        restart = new JButton("Restart Game");
        leave = new JButton("Quit");
        
        add(restart);
        add(leave);
    
        restart.addActionListener(new RestartListener());
        leave.addActionListener(new LeaveListener());
        
        update(this.observable, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(observable.getState() instanceof AwaitRestart_state);
    }
    
    class RestartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.restart();
        }
    }
    
    class LeaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if( JOptionPane.showConfirmDialog(AwaitRestart_Panel.this, "Do you realy want to LEAVE the game?", "Leave?", JOptionPane.YES_NO_OPTION) == 0)
            {
                System.exit(0);
            }
        }
    }    
}
