package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Deck_Panel extends JPanel implements Observer, ImageConstants,FrameConstants
{
    private ObservableGame observableGame;
    private JLabel deck_size;
    private Image image = Resources.getBackHorizontal();
    
    public Deck_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        Dimension x = new Dimension(DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y);
        setMaximumSize(new Dimension(x));
        setPreferredSize(new Dimension(x));
        setMinimumSize(new Dimension(x));
                
        deck_size = new JLabel();
        deck_size.setFont(new Font("Arial", Font.BOLD, 44));
        deck_size.setForeground(Color.WHITE);

        setLayout(new GridBagLayout());
        add(deck_size);
        setOpaque(false);
        
        update(observableGame, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        String str = "";
        deck_size.setText(str+observableGame.getGamedata().getSizeOfDeck());
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image,0,0, DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y, this);  
        g.drawImage(image,0,3, DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y, this);  
        g.drawImage(image,0,6, DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y, this);  
        g.drawImage(image,0,9, DIM_FRAME_DECK_X, DIM_FRAME_DECK_Y, this);  
    }
}
