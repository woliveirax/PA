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
    
    
    //#### Tunnel Functions
    
    //Tunnel Supplies
    public void increaseTunnelSupplies()
    {
        if(tunnelSupplies > 1)
            return;
        
        tunnelSupplies++;
    }
    
    //Events
    public void tunnelForcesCaptured()
    {
        position = TunnelPos.CASTLE;
        tunnelSupplies = 0;
        
        if(morale > 0)
            morale--;
    }
    
    //Fast travel functions
    
    public void fastTravelToCastle()
    {
        if(position != TunnelPos.TUNNEL_1 && position != TunnelPos.TUNNEL_2)
            return;
        
        position = TunnelPos.CASTLE;
        
        if(tunnelSupplies > 0 && supplies < 4)
            if((tunnelSupplies + supplies) > 4)
                supplies = 4;
            else
                supplies += tunnelSupplies;
    }
    
    public void fastTravelToEnemyLines()
    {
        if(position != TunnelPos.TUNNEL_1 && position != TunnelPos.TUNNEL_2)
            return;
        
        position = TunnelPos.ENEMY_LINES;
    }
    
    //Tunnel movement
    
    public void moveSoldiersTorwardsEnemyLines()
    {
        if(position.MoveTorwardsEnemyLines() != null)
            position = position.MoveTorwardsEnemyLines();
    }
    
    public void moveSoldiersTorwardsCastle()
    {
        if(position.MoveTorwardsCastle() != null)
            position = position.MoveTorwardsCastle();
    }
    
    //Supplies functions
    
    public int getSupplies() {
        return supplies;
    }

    public boolean reduceSupplies() {
        if(supplies < 1)
            return false;
        
        supplies--;
        
        return true;
    }
    
    public boolean increaseSupplies() {
        if(supplies >= 4)
            return false;
        
        supplies++;
        
        return true;
    }
    
    //Morale functions
    
    public int getMorale() {
        return morale;
    }
    
    public boolean reduceMorale() {
        if(morale < 1)
            return false;
        
        morale--;
        
        return true;
    }
    
    public boolean increaseMorale() {
        if(morale >= 4)
            return false;
        
        morale++;
        
        return true;
    }
    
    //Wall Related functions
    
    public int getWallStrength() {
        return wallStrength;
    }

    public boolean reduceWallStrength() {
        if(wallStrength < 1)
            return false;
        
        wallStrength--;
        
        return true;
    }
    
    public boolean increaseWallStrength() {
        if(wallStrength >= 4)
            return true;

        wallStrength++;
        
        return true;
    }
}
