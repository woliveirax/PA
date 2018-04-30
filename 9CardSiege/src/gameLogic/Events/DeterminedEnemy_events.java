/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.Events;

import gameLogic.GameData;

/**
 *
 * @author Olympus
 */
public class DeterminedEnemy_events extends _Event{

    public DeterminedEnemy_events(GameData gameData) {
        super("Determined Enemy","-1 to attacks on the Battering Ram", gameData);
    }

    @Override
    public int getDRMAttackBatteringRam() {
        return -1; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
