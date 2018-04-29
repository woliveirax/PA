/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;
import java.io.Serializable;

public class Castle implements Serializable{
    
    private int supplies;
    private int morale;
    private int wallStrength;
    
    private TunnelPos position;
    private int tunnelSupplies;
    
    
    public Castle(){
        supplies = 4;
        morale = 4;
        wallStrength = 4;
        position = TunnelPos.CASTLE;
        tunnelSupplies = 0;
    }
    
    
    //Tunnel Functions
    //TODO: tunnel movement functions
    //      - Reset Movement,
    //      - Fast Travel,
    //      - etc.
    //TODO: Increase / decrease tunnel supplies
    
    //Supplies functions
    
    public int getSupplies() {
        return supplies;
    }

    public boolean reduceSupplies(int supplies) {
        int reducedSup = this.supplies - supplies;
        
        if(reducedSup <= 0)
        {
            this.supplies = 0;
            return false;
        }
        else
            this.supplies = reducedSup;
        
        return true;
    }
    
    public boolean increaseSupplies(int inc) {
        int incSup = supplies + inc;
        
        if(incSup >= 4)
        {
            supplies = 4;
            return false;
        }
        else
            supplies = incSup;
        
        return true;
    }

    //Morale functions
    
    public int getMorale() {
        return morale;
    }
    
    public boolean reduceMorale(int morale) {
        int reducedMorale = this.morale - morale;
        
        if(reducedMorale <= 0)
        {
            this.morale = 0;
            return false;
        }
        else
            this.morale = reducedMorale;
        
        return true;
    }
    
    public boolean increaseMorale(int inc) {
        int incMorale = morale + inc;
        
        if(incMorale >= 4)
        {
            morale = 4;
            return false;
        }
        else
            morale = incMorale;
        
        return true;
    }

    
    //Wall Related functions
    
    public int getWallStrenght() {
        return wallStrength;
    }

    public boolean reduceWallStrength(int wallStrength) {
        int reducedWall = this.wallStrength - wallStrength;
        
        if(reducedWall <= 0)
        {
            this.wallStrength = 0;
            return false;
        }
        else
            this.wallStrength = reducedWall;
        
        return true;
    }
    
    public boolean increaseWallStrenght(int inc) {
        int incWall = wallStrength + inc;
        
        if(incWall >= 4)
        {
            wallStrength = 4;
            return false;
        }
        else
            wallStrength = incWall;
        
        return true;
    }
}
