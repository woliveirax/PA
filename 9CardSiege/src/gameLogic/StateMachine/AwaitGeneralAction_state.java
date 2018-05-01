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
public class AwaitGeneralAction_state extends StateAdapter{

    public AwaitGeneralAction_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)EnterTunnel";
    }

    @Override
    public IStates endOfAction(GameData gameData) {
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }
}
