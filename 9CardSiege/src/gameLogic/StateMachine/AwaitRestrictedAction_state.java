/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

public class AwaitRestrictedAction_state extends StateAdapter{

    public AwaitRestrictedAction_state(GameData gameData) {
        super(gameData);
    }

    @Override
    //TODO: if restricted action and oldstate instanceof enemyline
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
        getGameData().reduceActionPoints();//TODO: Estado verificar sempre action points ser = 0 
        return this; 
    }

    @Override
    public IStates sabotage() {
        int diceResult= getGameData().diceRoll(getGameData().getDRMSabotage());
        
        if (diceResult==1)
            getGameData().tunnelForcesCaptured();
        else if(diceResult==5||diceResult==6)
            getGameData().destroyTrebuchets();

        
        getGameData().reduceActionPoints();//TODO: Estado verificar sempre action points ser = 0 
        
        return this;
    }
    
    @Override
    public String toString() {
        return "Actions allowed:\n)1)Sabotage\t(2)Raid\n";
    }

}
