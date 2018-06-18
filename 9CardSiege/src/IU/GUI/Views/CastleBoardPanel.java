package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class CastleBoardPanel extends JPanel implements FrameConstants, Observer {
    private ObservableGame observable;
    private Image supplies,wallStrength,morale;
    private Image tunnelSupplies, tunnelSoldiers;
    private Image board;
    
    //Token Allingment
    private static final int TOKEN_X_ALLINGMENT = 21;
    private static final int TOKEN_X_NEXT_SPACING = 96;
    
    private static final int TOKEN_Y_ALLINGMENT = 15;
    private static final int TOKEN_Y_NEXT_SPACING = 66;
    
    private static final int TUNNEL_X_NEXT_SPACING = 48;
    private static final int TUNNEL_X_ALLINGMENT = 10;
    
    
    public CastleBoardPanel(ObservableGame observable){
        this.observable = observable;
        observable.addObserver(this);
        
        //Get Images
        supplies        = Resources.getSuppliesToken();
        wallStrength    = Resources.getWallStrengthToken();
        morale          = Resources.getMoraleToken();
        tunnelSupplies  = Resources.getTunnelSuppliesToken();
        tunnelSoldiers  = Resources.getTunnelPosToken();
        board           = Resources.getCard_image(7);
        
        
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
        super.paintComponent(g);
        int val = 0;
        
        //Draw Board
        g.drawImage(board,0, 0,DIM_BOARD_PANEL_X-2, DIM_BOARD_PANEL_Y-2, this);
        
        //Draw WallStrength Icon
        val = observable.getGamedata().getWallStrength();
        if(val > 0)
            g.drawImage(wallStrength,TOKEN_X_ALLINGMENT,TOKEN_Y_ALLINGMENT + (TOKEN_Y_NEXT_SPACING * Math.abs(val - 4)),40,40,this);
        else
            g.drawImage(supplies,TOKEN_X_ALLINGMENT + TOKEN_X_NEXT_SPACING,TOKEN_Y_ALLINGMENT +(TOKEN_Y_NEXT_SPACING * 4),40,40,this);
        
        
        //Draw Morale Icon
        val = observable.getGamedata().getMorale();
        if(val > 0)
            g.drawImage(morale,TOKEN_X_ALLINGMENT + TOKEN_X_NEXT_SPACING,TOKEN_Y_ALLINGMENT +(TOKEN_Y_NEXT_SPACING * Math.abs(val - 4)),40,40,this);
        else
            g.drawImage(supplies,TOKEN_X_ALLINGMENT + TOKEN_X_NEXT_SPACING,TOKEN_Y_ALLINGMENT +(TOKEN_Y_NEXT_SPACING * 4),40,40,this);
        
        
        //Draw SuppliesIcon
        val = observable.getGamedata().getSupplies();
        if(val > 0)
            g.drawImage(supplies,TOKEN_X_ALLINGMENT + (TOKEN_X_NEXT_SPACING * 2),TOKEN_Y_ALLINGMENT + (TOKEN_Y_NEXT_SPACING * Math.abs(val - 4)),40,40,this);
        else
            g.drawImage(supplies,TOKEN_X_ALLINGMENT + TOKEN_X_NEXT_SPACING,TOKEN_Y_ALLINGMENT + (TOKEN_Y_NEXT_SPACING * 4),40,40,this);
        
        
        //Draw Tunnel Pos Icon
        int pos = observable.getGamedata().getTunnelPosition().ordinal();
        g.drawImage(tunnelSoldiers,TUNNEL_X_ALLINGMENT + (TUNNEL_X_NEXT_SPACING * pos),TOKEN_Y_ALLINGMENT +(TOKEN_Y_NEXT_SPACING * 5),40,40,this);
        
        
        //Draw Tunnel Supplies Icon
        switch(observable.getGamedata().getTunnelSupplies()){
            case 0:
                g.drawImage(tunnelSupplies,TOKEN_X_ALLINGMENT + 150,15 + 288,40,40,this);
                break;
            
            case 1:
                g.drawImage(tunnelSupplies,TOKEN_X_ALLINGMENT + 200,15 + 333,40,40,this);
                break;
                
            case 2:
                g.drawImage(tunnelSupplies,TOKEN_X_ALLINGMENT + 200,15 + 288,40,40,this);
                break;
        }
    }
}
