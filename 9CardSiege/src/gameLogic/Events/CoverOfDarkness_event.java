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
public class CoverOfDarkness_event extends _Event {
    
    public CoverOfDarkness_event(GameData gameData)
    {
        super("Cover of Darkness","+1 to Raid and Sabotage actions",gameData);
    }

    @Override
    public int getDRMRaid() {
        return 1;
    }

    @Override
    public int getDRMSabotage() {
        return 1;
    }
}
