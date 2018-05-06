package gameLogic.StateMachine;

import gameLogic.GameData;

public class ArcherAttackTrackSelection_state extends StateAdapter{

    public ArcherAttackTrackSelection_state(GameData gameData,IStates state) {
        super(gameData,state);
    }

    @Override
    public IStates endOfAction() {
        return getOldState();
    }

    @Override
    public String toString() {
        return "Archer Attack:\n\tEnemy selection: (1)Ladders\t(2)Battering Ram\t(3)Siege Tower\n";
    }

  
}
