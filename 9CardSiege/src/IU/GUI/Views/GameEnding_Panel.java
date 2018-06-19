package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.GameData;
import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitRestart_state;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameEnding_Panel extends JPanel implements Observer, ImageConstants,FrameConstants{
    private ObservableGame observableGame;
    private JLabel text;
    private Image winPopUp = Resources.getWinPopUp();
    private Image loosePopUp = Resources.getLoosePopUp();

    public GameEnding_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        
        Dimension x = new Dimension(700,35);
        setMinimumSize(new Dimension(x));
        setPreferredSize(new Dimension(x));
        setMaximumSize(new Dimension(x));
          
        text = new JLabel();
        text.setFont(new Font("Monospaced", Font.BOLD, 16));
        
        add(text);
        
        setAlignmentY(CENTER_ALIGNMENT);
        setBorder(BorderFactory.createRaisedBevelBorder());
        setOpaque(false);
        update(observableGame, null);
    }
    @Override
    public void update(Observable o, Object arg) {
        endingStringOutput();
        setVisible(observableGame.getState() instanceof AwaitRestart_state);
    }
    
    private void endingStringOutput(){
        GameData game = observableGame.getGamedata();
        int turn = 7 - game.getSizeOfDeck();
        String end_turn = "Too bad, by the end of the turn " + turn;
        String in_turn = "Too bad, you've not survived the turn "+turn;
        
        text.setForeground(Color.red);
        if(game.endOfTurn_LosingBy_Castle())
            text.setText( end_turn +", you've lost for not having any " 
                    + game.endOfTurn_getStatusFor_LosingBy_Castle()+"!");
        
        if(game.endOfTurn_LosingBy_CloseCombat())
            text.setText(end_turn + ", you've lost for having 2 enemeis in close range!");
        
        if(game.inTurn_LosingBy_Castle())
            text.setText( in_turn +", you've lost for not having: " 
                    + game.inTurn_getStatusFor_LosingBy_Castle()+"!");
        
        if(game.inTurn_LosingBy_CloseCombat())
            text.setText(end_turn + ", you've lost for having 3 enemis in close range!");
        
        //winning
        if(game.winningCondition()){
            text.setForeground(Color.blue);
            text.setText("Congratulations! You've survived the siege (づ｡◕‿‿◕｡)づ !!!");
        }
    }
}
