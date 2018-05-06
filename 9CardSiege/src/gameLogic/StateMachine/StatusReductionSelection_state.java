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
public class StatusReductionSelection_state extends StateAdapter{

    public StatusReductionSelection_state(GameData gameData,IStates state) {
        super(gameData,state);
    }
    
    @Override
    public IStates endOfAction() {
        getGameData().setExtraActionUsed(true);
        return getOldState();
    }
    
    @Override
    public String toString() {
        return "Adittional action point by:(1)Reducing 1 pt of supplies\t(2)Reducing 1 pt of moral\n";
    }
}
