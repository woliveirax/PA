/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

public class AwaitEnemyLineAction_state extends AwaitGeneralAction_state{

    public AwaitEnemyLineAction_state(GameData gameData) {
        super(gameData);
    }

    @Override
    public IStates raid() {
        switch (getGameData().diceRoll(getGameData().getDRMRaid())){
            case 1:
                getGameData().tunnelForcesCaptured();
                break;
                
            case 2:
                break;
                
            case 6:
                getGameData().increaseTunnelSupplies();
                getGameData().increaseTunnelSupplies();
                break;
                
            default:
                getGameData().increaseTunnelSupplies();
                break;
            
        }
        if(getGameData().inTurn_LoseCondition())
            new AwaitRestart_state(getGameData(), false);
        
        getGameData().reduceActionPoints();
        return this; 
    }

    @Override
    public IStates sabotage() {
        int diceResult= getGameData().diceRoll(getGameData().getDRMSabotage());
        
        if (diceResult==1)
            getGameData().tunnelForcesCaptured();
        else if(diceResult==5||diceResult==6)
            getGameData().destroyTrebuchets();
        
        if(getGameData().inTurn_LoseCondition())
            new AwaitRestart_state(getGameData(), false);
        
        getGameData().reduceActionPoints();
        
        return this;
    }
    
    @Override
    public IStates enterTunnel() {
        getGameData().moveSoldiersTorwardsCastle();
        getGameData().reduceActionPoints();
        
        return new AwaitPt2TunnelAction_state(getGameData()); 
    }

    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)Sabotage\t(6)Sabotage\t(7)Raid(8)EnterTunnel\n";
    }

}
