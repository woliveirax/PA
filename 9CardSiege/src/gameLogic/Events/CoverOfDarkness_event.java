package gameLogic.Events;

import gameLogic.GameData;

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
