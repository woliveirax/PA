package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import static IU.GUI.Constants.FrameConstants.DIM_BOARD_PANEL_X;
import static IU.GUI.Constants.FrameConstants.DIM_BOARD_PANEL_Y;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class ViewCard_Panel extends JPanel implements Observer,FrameConstants {
    private ObservableGame observable;
    private Image card;
    
    public ViewCard_Panel(ObservableGame observable){
        this.observable = observable;
        this.observable.addObserver(this);
        
        //Set Dimensions
        Dimension a = new Dimension(DIM_BOARD_PANEL_X,DIM_BOARD_PANEL_Y);
        this.setPreferredSize(a);
        this.setMaximumSize(a);
        this.setMinimumSize(a);
        
        //update(this.observable,null);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        try{
            card = Resources.getCard_image(this.observable.getGamedata().getCurrentCard().getId() - 1);
            g.drawImage(card,0,0,CARD_DIM_X,CARD_DIM_Y, this);
            
            int day = observable.getGamedata().getCurrentDay();
            
            Graphics2D graphics2 = (Graphics2D) g;
            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(11, 10 + (day * 129), 278,120, 40, 40);
            graphics2.setColor(Color.CYAN);
            graphics2.setStroke(new BasicStroke(5));
            graphics2.draw(roundedRectangle);
            
        } catch (Exception e) {
            g.drawImage(Resources.getCard_image(9),0,0,CARD_DIM_X,CARD_DIM_Y, this);
            //e.printStackTrace();
        }
    }
    
}
