/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

/**
 *
 * @author Olympus
 */
public class AwaitPt2TunnelAction_state extends StateAdapter{

    public AwaitPt2TunnelAction_state(GameData gameData) {
        super(gameData);
    }
    
    
    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)move to tunnel pt 1(6)Fast travel to Castle(7)exit tunnel to enemy line\n";
    }
}
