/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.Events;

import gameLogic.GameData;

/**
 *
 * @author Skully
 */
public class Collapsed_event extends _Event {
    
    public Collapsed_event(GameData gameData)
    {
        super("Collapsed!", "Siege Tower removed from game if on starting space", gameData);
    }

    @Override
    public void triggerEvent() {
        if(getGameData().getTowerPosition() == 4)
            getGameData().removeTowerFromGame();
    }
}
