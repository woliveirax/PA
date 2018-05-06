/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;


public class AwaitPt1TunnelAction_state extends AwaitGeneralAction_state{

    public AwaitPt1TunnelAction_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public IStates moveForward() {
   
        if(!getGameData().isFreeTunnelMoveUsed()){
            getGameData().moveSoldiersTorwardsEnemyLines();
            
            return new AwaitPt2TunnelAction_state(getGameData()); 
        }
        return this;
    }
    
    @Override
    public IStates moveBackward() {
        
        getGameData().moveSoldiersTorwardsCastle();
        return getOldState(); 
    }

    @Override
    public IStates fastTravel() {
        //to enemy line
        getGameData().fastTravelToEnemyLines();
        getGameData().reduceActionPoints();

        return new AwaitEnemyLineAction_state(getGameData()); 
    }

    @Override
    public IStates enterTunnel() {
        return this;
    }
    
    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)Move to tunnel pt 2(6)Fast travel to enemy line\t(7)Exit tunnel\n";
    }
}
