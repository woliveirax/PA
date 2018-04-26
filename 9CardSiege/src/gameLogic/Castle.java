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
    private int wallStrenght;
    public Tunnel tunnel;
    
    
    //Criar ficheiro com dados constantes
    public enum tunnel_pos{
      CASTLE,
      TUNNEL_1,
      TUNNEL_2,
      ENEMY_LINES;
    };
    
    public enum tunnel_sup {
        EMPTY,
        HALF,
        FULL;
    };
    
    //Tunnel
    class Tunnel implements Serializable {
        private tunnel_pos position = tunnel_pos.CASTLE;
        private tunnel_sup raidSupplies = tunnel_sup.EMPTY;
        
    }
    
    
    public Castle(){
        supplies = 4;
        morale = 4;
        wallStrenght = 4;
        tunnel = new Tunnel();
    }
    
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

    
    //Wall Related functions
    
    public int getWallStrenght() {
        return wallStrenght;
    }

    public boolean setWallStrenght(int wallStrenght) {
        int reducedWall = this.wallStrenght - wallStrenght;
        
        if(reducedWall <= 0)
        {
            this.wallStrenght = 0;
            return false;
        }
        else
            this.wallStrenght = reducedWall;
        
        return true;
    }

//    public Tunnel getTunnel() {
//        return tunnel;
//    }
    
}
