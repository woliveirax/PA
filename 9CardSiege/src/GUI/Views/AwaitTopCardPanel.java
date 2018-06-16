package GUI.Views;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitTopCard_state;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AwaitTopCardPanel extends JPanel implements Observer {
    
    private ObservableGame observable;
    private JButton drawCard;

    public AwaitTopCardPanel(ObservableGame observable) {
        this.observable = observable;
        observable.addObserver(this);
        
        setOpaque(false);
        
        drawCard = new JButton("Draw Card");
        
        add(drawCard);
    
        drawCard.addActionListener(new drawCardListener());
        
        update(this.observable, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(observable.getState() instanceof AwaitTopCard_state);
    }
    
    class drawCardListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            observable.drawCard();
        }
    }
}

