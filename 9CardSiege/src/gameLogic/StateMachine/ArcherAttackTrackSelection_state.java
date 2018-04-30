/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

public class ArcherAttackTrackSelection_state extends StateAdapter{
    private GameData gameData;

    public ArcherAttackTrackSelection_state(GameData gameData) {
        super(gameData);
        this.gameData = gameData;
    }

  
}
