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
public class AwaitEnemyLineAction_state extends StateAdapter{

    public AwaitEnemyLineAction_state(GameData gameData) {
        super(gameData);
    }

    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)Sabotage\t(6)Sabotage\t(7)Raid(8)EnterTunnel\n";
    }

    @Override
    public IStates endOfAction(GameData gameData) {
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
