package gameLogic.StateMachine;

import gameLogic.GameData;

public class AwaitTopCard_state extends StateAdapter{

    public AwaitTopCard_state(GameData gameData,IStates state) {
        super(gameData,state);
    }

    public AwaitTopCard_state(GameData gameData) {
        super(gameData,null);
    }
    
    
    @Override
    public IStates drawCard(){
        getGameData().drawCardFromDeck();
        
        if (getOldState() == null)
            return new AwaitGeneralAction_state(getGameData());

        if(getGameData().isActionRestricted()){
            if(getOldState() instanceof AwaitEnemyLineAction_state)
                return new AwaitRestrictedAction_state(getGameData());
            else
                return this;
        }
        
        return getOldState();
    }    
    
    @Override
    public String toString() {
        return "Obtain a card from deck.\n";
    }
}
