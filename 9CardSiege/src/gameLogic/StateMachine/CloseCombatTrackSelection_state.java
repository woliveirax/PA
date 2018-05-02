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
public class CloseCombatTrackSelection_state extends StateAdapter{

    public CloseCombatTrackSelection_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public IStates endOfAction() {
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "Close Combat:\n\tTrack selection: (1)Left\t(2)Right\n";
    }
}
