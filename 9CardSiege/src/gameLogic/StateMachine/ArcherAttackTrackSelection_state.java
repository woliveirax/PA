/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

public class ArcherAttackTrackSelection_state extends StateAdapter{

    public ArcherAttackTrackSelection_state(GameData gameData) {
        super(gameData);
    }

    @Override
    public IStates endOfAction(GameData gameData) {
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Archer Attack:\n\tEnemy selection: (1)Ladders\t(2)Battering Ram\t(3)Siege Tower\n";
    }

  
}
