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
public class RallySelection_state extends StateAdapter{

    public RallySelection_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public String toString() {
        return "(1)Normal roll dice\t(2)Adittional DRM by reducing 1 pt of supplies\n";
    }

//    @Override
//    public IStates extraMoral() {
//        return this;
//    }

    @Override
    public IStates endOfAction() {
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }
}
