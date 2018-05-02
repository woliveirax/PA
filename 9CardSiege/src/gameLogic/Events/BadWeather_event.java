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
public class BadWeather_event extends _Event {

    public BadWeather_event(GameData gameData) {
        super("Bad Weather", "Only raid and sabotage actions allowed this turn", gameData);
    }
    
    @Override
    public boolean actionRestriction() {
        return true;
    }
}
