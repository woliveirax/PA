package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.GameData;
import gameLogic.Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class ImgsRefletingGameStatus_Panel extends JPanel implements Observer, ImageConstants,FrameConstants{
    private ObservableGame observableGame;
    private Image winPopUp = Resources.getWinPopUp();
    private Image loosePopUp = Resources.getLoosePopUp();
    private Image neutralPopUp = Resources.getNeutralPopUp();

    public ImgsRefletingGameStatus_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        Dimension x = new Dimension(POPUP_DIM_X,POPUP_DIM_Y);
        setMinimumSize(new Dimension(x));
        setPreferredSize(new Dimension(x));
        setMaximumSize(new Dimension(x));
        
        setOpaque(false);
        update(observableGame, null);
    }
     
    @Override
    public void update(Observable obs, Object o){
        repaint();
    }
    

    @Override
    public void paintComponent(Graphics g)
    {
        GameData game = observableGame.getGamedata();
        super.paintComponent(g);

        if(game.winningCondition())
            g.drawImage(winPopUp,0,0, POPUP_DIM_X, POPUP_DIM_Y, this);
        else if(game.inTurn_LoseCondition() || game.endOfTurn_LoseCodition())
            g.drawImage(loosePopUp,0,0, POPUP_DIM_X, POPUP_DIM_Y, this);
        else
            g.drawImage(neutralPopUp,0,0, POPUP_DIM_X, POPUP_DIM_Y, this);

    }
}
