package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_TOSTRING_X;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_TOSTRING_Y;
import IU.GUI.Constants.ImageConstants;
import gameLogic.GameData;
import gameLogic.Model.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class NonRepeatableActionsPossible_Panel extends JPanel implements Observer, ImageConstants,FrameConstants{
    private ObservableGame observableGame;
    private TextArea info_possibilities; 

    public NonRepeatableActionsPossible_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
                setPreferredSize(new Dimension(DIM_FRAME_TOSTRING_X,DIM_FRAME_TOSTRING_Y));

        setBackground(Color.GRAY);
        info_possibilities=new TextArea();
        info_possibilities.setBounds(0,0,300,200);
        add(info_possibilities);
        setOpaque(false);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        GameData data = observableGame.getGamedata();
        String s = "";
        //Check your actions availability:
        s += "Boilling water available: ";
        s += !(data.isBoillingWaterUsed())? "yes" : "no";
        s += "\nExtra action available:   ";
        s += !(data.isExtraActionUsed())? "yes" : "no";
        s += "\nFree Tunnel move available:   ";
        s += !(data.isFreeTunnelMoveUsed())? "yes" : "no";
        info_possibilities.append(s);
    }
}
