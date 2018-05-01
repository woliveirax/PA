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
public class AwaitRestrictedAction_state extends StateAdapter{

    public AwaitRestrictedAction_state(GameData gameData) {
        super(gameData);
    }
    
    
    @Override
    public String toString() {
        return "Actions allowed:\n)1)Sabotage\t(2)Raid\n";
    }

}
