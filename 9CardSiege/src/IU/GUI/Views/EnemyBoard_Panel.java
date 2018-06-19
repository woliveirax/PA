package IU.GUI.Views;

import IU.GUI.Constants.FrameConstants;
import IU.GUI.Constants.ImageConstants;
import IU.GUI.Resources;
import gameLogic.Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class EnemyBoard_Panel extends JPanel implements Observer, ImageConstants,FrameConstants{
    private ObservableGame observableGame;
    private Image enemyBoard = Resources.getCard_image(8);
    private Image trebuchets = Resources.getTrebuchetToken();
    private Image ladders = Resources.getLadderToken();
    private Image batering_ram = Resources.getRamToken();
    private Image tower = Resources.getTowerToken();
    int initialPosX = 25,initialPosY = 72,separateSpaceX=101,separateSpaceY=66;
            
    public EnemyBoard_Panel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        Dimension x = new Dimension(DIM_BOARD_PANEL_X,DIM_BOARD_PANEL_Y);
        setPreferredSize(x);
        setMaximumSize(x);
        setMinimumSize(x);
        setOpaque(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
//
    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        
         g.drawImage(enemyBoard,0,0, DIM_BOARD_PANEL_X-2, DIM_BOARD_PANEL_Y-2, this);
         int posLadders = observableGame.getGamedata().getLadderPosition() - 1;
         int posRam = observableGame.getGamedata().getBatteringRamPosition() - 1;
         int posTower = observableGame.getGamedata().getTowerPosition() - 1;
         int posTrebuchet = observableGame.getGamedata().getActiveTrebuchets()-1;
         
         if(observableGame.getGamedata().getActiveTrebuchets()>0)
            g.drawImage(trebuchets,initialPosX+posTrebuchet*separateSpaceX,initialPosY*5-12, DIM_TOKEN_X, DIM_TOKEN_Y, this);
         
         if(posLadders> -1)
            g.drawImage(ladders,initialPosX,initialPosY+posLadders*separateSpaceY, DIM_TOKEN_X, DIM_TOKEN_Y, this);
         
         if(posRam > -1)
            g.drawImage(batering_ram,initialPosX+separateSpaceX,initialPosY+posRam*separateSpaceY, DIM_TOKEN_X, DIM_TOKEN_Y, this);
         
         if(observableGame.getGamedata().isTowerInGame() && posTower > -1)
            g.drawImage(tower,initialPosX+separateSpaceX*2,initialPosY+posTower*separateSpaceY, DIM_TOKEN_X, DIM_TOKEN_Y, this);
         
         if(observableGame.getGamedata().getCloseCombatArea().size()==1){
            switch(observableGame.getGamedata().getCloseCombatArea().get(0).getName()){
                case "Ladder":
                    g.drawImage(ladders,initialPosX+separateSpaceX-25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                case "BatteringRam":
                    g.drawImage(batering_ram,initialPosX+separateSpaceX-25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                case "Tower":
                    g.drawImage(tower,initialPosX+separateSpaceX-25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
            };
         }
            if(observableGame.getGamedata().getCloseCombatArea().size()==2){
                switch(observableGame.getGamedata().getCloseCombatArea().get(0).getName()){
                case "Ladder":
                    g.drawImage(ladders,initialPosX+separateSpaceX-25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                case "BatteringRam":
                    g.drawImage(batering_ram,initialPosX+separateSpaceX-25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                case "Tower":
                    g.drawImage(tower,initialPosX+separateSpaceX-25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                };
            
                switch(observableGame.getGamedata().getCloseCombatArea().get(1).getName()){
                case "Ladder":
                    g.drawImage(ladders,initialPosX+separateSpaceX+25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                case "BatteringRam":
                    g.drawImage(batering_ram,initialPosX+separateSpaceX+25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
                case "Tower":
                    g.drawImage(tower,initialPosX+separateSpaceX+25,initialPosY-separateSpaceY+5, DIM_TOKEN_X, DIM_TOKEN_Y, this);
                    break;
            };
            }
            
         
              
    }
    
    
}
