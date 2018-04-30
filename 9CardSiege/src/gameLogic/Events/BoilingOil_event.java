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
public class BoilingOil_event extends _Event{

    public BoilingOil_event(GameData gameData) {
        super("Boiling Oil","+2 to attacks on enemy units in circle spaces",gameData);
    }

    @Override
    public int getDRMCircleSpaces() {
        return 2; //To change body of generated methods, choose Tools | Templates.
    }
}
