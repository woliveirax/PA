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
public class FlamingArrows_event extends _Event{
    
    public FlamingArrows_event(GameData gameData)
    {
        super("Framing Arrows","+1 to attacks on the Siege Tower",gameData);
    }

    @Override
    public int getDRMAttackSiegeTower() {
        return 1;
    }
}
