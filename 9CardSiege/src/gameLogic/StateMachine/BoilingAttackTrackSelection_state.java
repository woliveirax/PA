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
public class BoilingAttackTrackSelection_state extends StateAdapter{

    public BoilingAttackTrackSelection_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public String toString() {
        return "Boiling Water:\n\tEnemy selection: (1)Ladders\t(2)Battering Ram\t(3)Siege Tower\n";
    }
}
