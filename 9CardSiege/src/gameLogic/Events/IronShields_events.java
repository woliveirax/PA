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
public class IronShields_events extends _Event{

    public IronShields_events(GameData gameData) {
        super("Iron Shields","-1 to attacks on the Siege Tower", gameData);
    }

    @Override
    public int getDRMAttackSiegeTower() {
        return -1; 
    }
    
    
    
}
