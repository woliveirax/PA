package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import static IU.GUI.Constants.FrameConstants.DIM_BOARD_PANEL_X;
import static IU.GUI.Constants.FrameConstants.DIM_BOARD_PANEL_Y;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.annotation.Resource;
import javax.swing.JPanel;

public class ViewCard_Panel extends JPanel implements Observer,FrameConstants {
    private ObservableGame observable;
    private Image card;
    
    public ViewCard_Panel(ObservableGame observable){
        this.observable = observable;
        this.observable.addObserver(this);
        
        card = Resources.getCard_image(this.observable.getGamedata().getCurrentCard().getId() - 1);
        
        //Set Dimensions
        Dimension a = new Dimension(DIM_BOARD_PANEL_X,DIM_BOARD_PANEL_Y);
        this.setPreferredSize(a);
        this.setMaximumSize(a);
        this.setMinimumSize(a);
        
        update(this.observable,null);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(card,0,0,CARD_DIM_X,CARD_DIM_Y, this);
    }
    
}