/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.Enemy;
import gameLogic.GameData;
import java.util.ArrayList;

/**
 *
 * @author Olympus
 */
public class CloseCombatTrackSelection_state extends StateAdapter{

    public CloseCombatTrackSelection_state(GameData gameData,IStates state) {
        super(gameData,state);
    }

    @Override
    public IStates PositionSelection(int pos) {
        int res = 0;
        
        if(pos == 1)
        {
            if((res = getGameData().diceRoll(getGameData().getDRMAttackCloseCombat())) > 4)
                getGameData().getCloseCombatArea().get(0).retreat();
            else if(res == 1)
                getGameData().ReduceMorale();
        }
        else if(pos == 2)
        {
            if((res = getGameData().diceRoll(getGameData().getDRMAttackCloseCombat())) > 4)
                getGameData().getCloseCombatArea().get(1).retreat();
            else if(res == 1)
                getGameData().ReduceMorale();
        }
        
        if(getGameData().inTurn_LoseCondition())
            return new AwaitRestart_state(getGameData(), false);
        
        getGameData().reduceActionPoints();
        
        return getOldState();
    }
    
    @Override
    public IStates endOfAction() {
        return getOldState();
    }
    
    @Override
    public String toString() {
            return "Close Combat:\n\tTrack selection: (1)Left\t(2)Right";
    }
}
