package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_TOSTRING_X;
import static IU.GUI.Constants.FrameConstants.DIM_FRAME_TOSTRING_Y;
import IU.GUI.Constants.ImageConstants;
import gameLogic.GameData;
import gameLogic.Model.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.beans.PropertyEditorManager;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NonRepeatableActionsPossible_Panel extends JPanel implements Observer, ImageConstants,FrameConstants{
    private ObservableGame observableGame;
    private JLabel boilling,extraAction,freeTunnelMove,MOTD; 

    public NonRepeatableActionsPossible_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        MOTD            = new JLabel("Available Actions");
        boilling        = new JLabel();
        extraAction     = new JLabel();
        freeTunnelMove  = new JLabel();
        
        Dimension x = new Dimension(DIM_FRAME_TOSTRING_X,DIM_FRAME_TOSTRING_Y);
        setMinimumSize(x);
        setPreferredSize(x);
        setMaximumSize(x);
        
        MOTD.setAlignmentX(CENTER_ALIGNMENT);
        MOTD.setFont(new Font("Helvetica",Font.BOLD,12));
        MOTD.setForeground(Color.BLACK);
        
        boilling.setFont(new Font("Helvetica",Font.BOLD,12));
        boilling.setAlignmentX(LEFT_ALIGNMENT);
        
        extraAction.setFont(new Font("Helvetica",Font.BOLD,12));
        extraAction.setAlignmentX(LEFT_ALIGNMENT);
        
        freeTunnelMove.setFont(new Font("Helvetica",Font.BOLD,12));
        freeTunnelMove.setAlignmentX(LEFT_ALIGNMENT);
        
        setAlignmentX(LEFT_ALIGNMENT);
        
        add(MOTD);
        add(boilling);
        add(extraAction);
        add(freeTunnelMove);
        setOpaque(true);
        
        setBackground(Color.LIGHT_GRAY);
        
        update(observableGame, null);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        GameData data = observableGame.getGamedata();
        String s = "";
        
        //Check for boiling available
        s += "Boilling water available: ";
        s += !(data.isBoillingWaterUsed())? "yes" : "no";
        
        boilling.setText(s);
        
        if(!data.isBoillingWaterUsed())
            boilling.setForeground(Color.WHITE);
        else
            boilling.setForeground(Color.RED);
        
        s = "";
        s += "\nExtra action available:   ";
        s += !(data.isExtraActionUsed())? "yes" : "no";
        
        extraAction.setText(s);
        if(!data.isExtraActionUsed())
            extraAction.setForeground(Color.WHITE);
        else
            extraAction.setForeground(Color.RED);
        
        s = "";
        s += "\nFree Tunnel move available:   ";
        s += !(data.isFreeTunnelMoveUsed())? "yes" : "no";
        
        freeTunnelMove.setText(s);
        if(!data.isFreeTunnelMoveUsed())
            freeTunnelMove.setForeground(Color.WHITE);
        else
            freeTunnelMove.setForeground(Color.RED);
    }
}
