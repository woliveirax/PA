package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_DICE_X;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_DICE_Y;
import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceFaces_Panel extends JPanel implements Observer, ImageConstants,FrameConstants {
    private ObservableGame observableGame;
    private List <Image> images = Resources.getDice_faces();
    
    public DiceFaces_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
//        setMaximumSize(new Dimension(DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y));
        setPreferredSize(new Dimension(DIM_FRAME_DICE_X, DIM_FRAME_DICE_Y));
//        setMinimumSize(new Dimension(DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y));

        setOpaque(false);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int index = observableGame.getGamedata().getDiceNumber() -1;
        super.paintComponent(g);
        g.drawImage(images.get(index),0,0, DIM_FRAME_DICE_X-2, DIM_FRAME_DICE_Y-2, this);  
    }
    
}
