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
public class DeathOfALeader_event extends _Event {
    
    public DeathOfALeader_event(GameData gameData)
    {
        super("Death of a Leader","Reduce morale by 1",gameData);
    }

    @Override
    public void triggerEvent() {
        getGameData().ReduceMorale();
    }
}
