package gameLogic.Events;

import gameLogic.GameData;

public class DeathOfALeader_event extends _Event {
    
    public DeathOfALeader_event(GameData gameData)
    {
        super("Death of a Leader","Reduce morale by 1",gameData);
    }

    @Override
    public void triggerEvent() {
        getGameData().ReduceMorale();
    }
}
