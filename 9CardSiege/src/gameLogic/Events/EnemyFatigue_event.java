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
public class EnemyFatigue_event extends _Event{
    
    public EnemyFatigue_event(GameData gameData)
    {
        super("Enemy Fatigue", "+1 to Coupure, Raid and Sabotage actions", gameData);
    }

    @Override
    public int getDRMCoupure() {
        return 1;
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
