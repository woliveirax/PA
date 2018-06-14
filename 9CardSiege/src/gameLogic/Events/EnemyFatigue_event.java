package gameLogic.Events;

import gameLogic.GameData;

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
