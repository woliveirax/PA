/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

public class AwaitTopCard_state extends StateAdapter{

    public AwaitTopCard_state(GameData gameData) {
        super(gameData);
    }
    
    
    @Override
    public IStates drawCard(){
        //Acrescentei getCurrentDay and Card to GameData
        if(getGameData().getCurrentCard().getSpecificDay(getGameData().getCurrentDay()).getCurrentEvent(0).actionRestriction())
            return new AwaitRestrictedAction_state(getGameData());
        
        else
            return getOldState();       
    }    
    
    @Override
    public String toString() {
        return "Obtain a card from deck.\n";
    }
}
