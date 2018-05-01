
package gameLogic.StateMachine;

import gameLogic.GameData;
import java.io.Serializable;

public class StateAdapter implements IStates, Serializable{
    private final GameData gameData;
    private IStates oldState;
    
    public StateAdapter(GameData gameData) {
        this.gameData = gameData;
    }
    
    @Override
    public IStates start(GameData gameData){
        return this;
    };
    @Override
    public IStates restart(GameData gameData){
        return this;
    };
    @Override
    public IStates exit(GameData gameData){
        return this;
    };
    @Override
    public IStates endOfTurn(GameData gameData){
        return this;
    };
    @Override
    public IStates drawCard(GameData gameData){
        return this;
    };
    @Override
    public IStates endOfGame(GameData gameData){
        return this;
    };
    @Override
    public IStates endOfAction(GameData gameData){
        return this;
    };
    @Override
    public IStates archerAttack(GameData gameData){
        return this;
    };
    @Override
    public IStates extraAction(GameData gameData){
        return this;
    };
    @Override
    public IStates Rally(GameData gameData){
        return this;
    };
    @Override
    public IStates ExtraMoral(GameData gameData){
        return this;
    };
    @Override
    public IStates BoilingWater(GameData gameData){
        return this;
    };
    @Override
    public IStates CloseCombat1(GameData gameData){
        return this;
    };
    @Override
    public IStates CloseCombat2(GameData gameData){
        return this;
    };
    @Override
    public IStates Coupure(GameData gameData){
        return this;
    };
    @Override
    public IStates Sabotage(GameData gameData){
        return this;
    };
    @Override
    public IStates Raid(GameData gameData){
        return this;
    };
    @Override
    public IStates EnterTunnel(GameData gameData){
        return this;
    };
    
    @Override
    public IStates MoveForward(GameData gameData){
        return this;
    };
    
    @Override
    public IStates MoveBackward(GameData gameData){
        return this;
    };
    
    @Override
    public IStates FastTravelEnLine(GameData gameData){
        return this;
    };

    public IStates getOldState() {
        return oldState;
    }
    
//Ver s é necessario
    public void setOldState(IStates oldState) {
        this.oldState = oldState;
    }
}
