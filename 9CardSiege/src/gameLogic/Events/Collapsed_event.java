package gameLogic.Events;

import gameLogic.GameData;

public class Collapsed_event extends _Event {
    
    public Collapsed_event(GameData gameData)
    {
        super("Collapsed!", "Siege Tower removed from game if on starting space", gameData);
    }

    @Override
    public void triggerEvent() {
        if(getGameData().getTowerPosition() == 4)
            getGameData().removeTowerFromGame();
    }
}
