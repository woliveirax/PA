package gameLogic.StateMachine;

import gameLogic.GameData;


public class RallySelection_state extends StateAdapter{
    
    private int num = 0;
    
    public RallySelection_state(GameData gameData,IStates state) {
        super(gameData,state);
    }

    @Override
    public IStates extraMoral(boolean reduceSupplies) {
        if(reduceSupplies)
        {
           getGameData().ReduceSupplies();
           num++;
        }
        
        if(getGameData().diceRoll(num) > 4)
            getGameData().increaseMorale();
        
        getGameData().reduceActionPoints();
        
        if(getGameData().inTurn_LoseCondition())
            return new AwaitRestart_state(getGameData(), false);
        
        return endOfAction();
    }
    
    @Override
    public String toString() {
        return "(1)Normal roll dice\t(2)Adittional DRM by reducing 1 pt of supplies\n";
    }

    @Override
    public IStates endOfAction() {
        return getOldState();
    }
}
