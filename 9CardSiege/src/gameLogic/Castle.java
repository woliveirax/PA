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
    
    private boolean freeMoveUsed;
    private TunnelPos position;
    private int tunnelSupplies;
    
    public Castle(){
        supplies = 4;
        morale = 4;
        wallStrength = 4;
        position = TunnelPos.CASTLE;
        tunnelSupplies = 0;
        freeMoveUsed = false;
    }
    
    
    //#### Tunnel Functions
    public boolean isFreeMoveUsed() {
        return freeMoveUsed;
    }

    public void setFreeMoveUsed(boolean freeMoveUsed) {
        this.freeMoveUsed = freeMoveUsed;
    }
    
    //Tunnel Supplies
    public void increaseTunnelSupplies()
    {
        if(tunnelSupplies > 1)
            return;
        
        tunnelSupplies++;
    }
    
    public int getTunnelSupplies()
    {
        return tunnelSupplies;
    }
    
    
    //Events
    public void tunnelForcesCaptured()
    {
        position = TunnelPos.CASTLE;
        tunnelSupplies = 0;
        
        if(morale > 0)
            morale--;
    }
    
    private void tunnelForcesSafe()
    {
        position = TunnelPos.CASTLE;
        
        if(tunnelSupplies != 0 && supplies < 4)
            if((supplies + tunnelSupplies) > 4)
                supplies = 4;
            else
                supplies += tunnelSupplies;
        
        tunnelSupplies = 0;
    }
    
    public void tunnelForcesEndOfDayAction()
    {
        if(position == TunnelPos.TUNNEL_1 || position == TunnelPos.TUNNEL_2)
            tunnelForcesSafe();
        else if(position == TunnelPos.ENEMY_LINES)
            tunnelForcesCaptured();
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
    public TunnelPos getTunnelPosition()
    {
        return position;
    }
    
    public void moveSoldiersTorwardsEnemyLines()
    {
        if(position.MoveTorwardsEnemyLines() != null)
            position = position.MoveTorwardsEnemyLines();
    }
    
    public void moveSoldiersTorwardsCastle()
    {
        if(position.MoveTorwardsCastle() != null)
            position = position.MoveTorwardsCastle();
        
        if(position == TunnelPos.CASTLE)
        {
            if(tunnelSupplies > 0 && supplies < 4)
                if((tunnelSupplies + supplies) > 4)
                    supplies = 4;
                else
                    supplies += tunnelSupplies;
        }
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
    
    public int isCastleOutOfResources()
    {
        int a = 0;
        
        if(supplies == 0)
            a++;
        if(wallStrength == 0)
            a++;
        if(morale == 0)
            a++;
        
        return a;
    }
}
