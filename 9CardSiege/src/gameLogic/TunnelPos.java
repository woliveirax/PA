/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

import java.io.Serializable;

/**
 *
 * @author Skully
 */
public enum TunnelPos implements Serializable {
      CASTLE,
      TUNNEL_1,
      TUNNEL_2,
      ENEMY_LINES;
      
    public TunnelPos MoveTorwardsCastle(){
        return this.ordinal() == 0 ?
                null : TunnelPos.values()[this.ordinal() - 1];
    }
    
    public TunnelPos MoveTorwardsEnemyLines(){
        return this.ordinal() < TunnelPos.values().length - 1?
                TunnelPos.values()[(this.ordinal() + 1)] : null;
    }
}
