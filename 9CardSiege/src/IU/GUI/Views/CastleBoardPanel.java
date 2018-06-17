package IU.GUI.Views;

import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class CastleBoardPanel extends JPanel implements ImageConstants, Observer {
    private ObservableGame observable;
    private Image supplies,wallStrength,morale,tunnelSupplies;
    private Image board;
    
    public CastleBoardPanel(ObservableGame observable){
        this.observable = observable;
        observable.addObserver(this);
        
        //Get Images
        
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
