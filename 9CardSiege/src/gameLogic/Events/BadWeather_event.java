package gameLogic.Events;

import gameLogic.GameData;

public class BadWeather_event extends _Event {

    public BadWeather_event(GameData gameData) {
        super("Bad Weather", "Only raid and sabotage actions allowed this turn", gameData);
    }
    
    @Override
    public boolean actionRestriction() {
        return true;
    }
}
