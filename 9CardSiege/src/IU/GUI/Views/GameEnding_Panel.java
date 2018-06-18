package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_DECK_X;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_DECK_Y;
import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.GameData;
import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine.AwaitRestart_state;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameEnding_Panel extends JPanel implements Observer, ImageConstants,FrameConstants{
    private ObservableGame observableGame;
    private boolean haveWon = false;
    private JLabel text;
    private Image winPopUp = Resources.getWinPopUp();
    private Image loosePopUp = Resources.getLoosePopUp();

    public GameEnding_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        setMinimumSize(new Dimension(DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y));
        setPreferredSize(new Dimension(DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y));
        setMaximumSize(new Dimension(DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y));
          
        text = new JLabel();
        text.setLocation(300,1100/2 - POPUP_DIM_Y/2);
        text.setFont(new Font("Arial", Font.BOLD, 68));
        endingStringOutput();
        add(text);
        
        setOpaque(true);

        update(observableGame, null);
    }
    //TODO
    @Override
    public void update(Observable o, Object arg) {
        setVisible(observableGame.getState() instanceof AwaitRestart_state);
        repaint();//check if its for before or after
    }
    
    private void endingStringOutput(){
        GameData game = observableGame.getGamedata();
        int turn = 7 - game.getSizeOfDeck();
        String end_turn = "Too bad, by the end of the turn " + turn;
        String in_turn = "Too bad, you've not survived the turn "+turn;
        
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
            text.setText("Congrats! (づ｡◕‿‿◕｡)づ You've beaten the system (ง'̀-'́)ง !!");
            haveWon = true;
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        int SuperiorBorder_x = getWidth()/2 - POPUP_DIM_X/2;
        int SuperiorBorder_y = getHeight()/2 - POPUP_DIM_Y/2;
        super.paintComponent(g);
        
        if(haveWon)
            g.drawImage(winPopUp,SuperiorBorder_x,SuperiorBorder_y + 20, POPUP_DIM_X, POPUP_DIM_Y, this);
        else
            g.drawImage(loosePopUp,SuperiorBorder_x,SuperiorBorder_y + 20, POPUP_DIM_X, POPUP_DIM_Y, this);
    }
}
