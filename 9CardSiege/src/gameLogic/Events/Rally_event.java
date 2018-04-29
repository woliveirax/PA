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
public class Rally_event extends _Event{
    
    public Rally_event(GameData gameData)
    {
        super("Rally!", "+1 to attacks on Close Combat or Circle Spaces", gameData);
    }

    @Override
    public int getDRMAttackCloseCombat() {
        return 1;
    }

    @Override
    public int getDRMCircleSpaces() {
        return 1;
    }
}
