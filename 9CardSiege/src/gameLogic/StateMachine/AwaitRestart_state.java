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
public class AwaitRestart_state extends StateAdapter{

    public AwaitRestart_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public String toString() {
        return "(1)Restart game\t(2)Sair\n";
    }

    @Override
    public IStates endOfAction(GameData gameData) {
        return new AwaitTopCard_state(gameData); //To change body of generated methods, choose Tools | Templates.
    }
}
