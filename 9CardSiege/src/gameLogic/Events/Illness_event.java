/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.Events;

import gameLogic.GameData;

public class Illness_event extends _Event{

    public Illness_event(GameData gameData) {
        super("Illness","Reduce morale by 1\nReduce suppplies by 1", gameData);
    }

    @Override
    public void triggerEvent() {
        getGameData().ReduceMorale(1);
        getGameData().ReduceSupplies(1);
    }
}
