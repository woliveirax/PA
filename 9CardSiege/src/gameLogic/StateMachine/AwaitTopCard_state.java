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
public class AwaitTopCard_state extends StateAdapter{

    public AwaitTopCard_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public String toString() {
        return "Obtain a card from deck.\n";
    }
}
