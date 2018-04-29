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
public class GateFortified_event extends _Event {
    
     public GateFortified_event(GameData gameData)
    {
        super("Gate Fortified","+1 to attacks on the Battering Ram",gameData);
    }

    @Override
    public int getDRMAttackBatteringRam() {
        return 1;
    }
}
