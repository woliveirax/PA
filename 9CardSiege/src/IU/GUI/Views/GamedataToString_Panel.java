package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import IU.GUI.Constants.ImageConstants;
import gameLogic.Model.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class GamedataToString_Panel extends JPanel implements Observer, ImageConstants,FrameConstants {
    
    private ObservableGame observableGame;
    private TextArea textGameData; 
;
    public GamedataToString_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
                setPreferredSize(new Dimension(DIM_FRAME_TOSTRING_X,DIM_FRAME_TOSTRING_Y));

        setBackground(Color.GRAY);
        textGameData=new TextArea();
        add(textGameData);
        setOpaque(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        String str = "";
        textGameData.append(str + observableGame.getGamedata().toString());
    }
}
