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
            return new AwaitRestart_state(getGameData(), false);
        
        getGameData().reduceActionPoints();
        return this; 
    }

    @Override
    public IStates sabotage() {
        int diceResult= getGameData().diceRoll(getGameData().getDRMSabotage());
        
        if(getGameData().getActiveTrebuchets() == 0)
            return this;
        
        if (diceResult==1)
            getGameData().tunnelForcesCaptured();
        else if(diceResult==5||diceResult==6)
            getGameData().destroyTrebuchets();

        
        if(getGameData().inTurn_LoseCondition())
            return new AwaitRestart_state(getGameData(), false);
        
        getGameData().reduceActionPoints();
        
        return this;
    }
    
    @Override
    public IStates endOfTurn(IStates oldstate) {
        
        if(getGameData().endOfTurn_LoseCodition())
            return new AwaitRestart_state(getGameData(),false);
        
        if(getGameData().getSizeOfDeck() == 0){
            if(getGameData().getCurrentDay()==2)
                return new AwaitRestart_state(getGameData(),true);

            getGameData().endOfDay();
        }
        //restaurar dados antes de retirar nova carta
        getGameData().setExtraActionUsed(false);
        getGameData().setBoillingWaterUsed(false);
        getGameData().setFreeTunnelMoveUsed(false);
        //
        return new AwaitTopCard_state(getGameData(),oldstate); 
    }
    
    
    @Override
    public String toString() {
        return "Actions allowed:\n)1)Sabotage\t(2)Raid\n";
    }

}
