package gameLogic.Events;

import gameLogic.GameData;

public class SuppliesSpoiled_event extends _Event{

    public SuppliesSpoiled_event(GameData gameData) {
        super("SuppliesSpoiled","Reduce supplies by 1",gameData);
    }

    @Override
    public void triggerEvent() {
        getGameData().ReduceSupplies();
    }    
}
