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
public class AwaitPt2TunnelAction_state extends AwaitGeneralAction_state{

    public AwaitPt2TunnelAction_state(GameData gameData) {
        super(gameData);
    }
      
    @Override
    public IStates moveForward() {
        getGameData().moveSoldiersTorwardsEnemyLines();

        return new AwaitEnemyLineAction_state(getGameData());

    }
    
    @Override
    public IStates moveBackward() {
        if(!getGameData().getFreeTunnelMoveUsed()){
            getGameData().moveSoldiersTorwardsCastle();
            
            return new AwaitPt1TunnelAction_state(getGameData()); 
        }
        return this;
    }

    @Override
    public IStates fastTravel() {
        
        getGameData().fastTravelToCastle();
        getGameData().reduceActionPoints();

        return new AwaitGeneralAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates enterTunnel() {
        return this;
    }
    
    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)move to tunnel pt 1(6)Fast travel to Castle(7)exit tunnel to enemy line\n";
    }
}
