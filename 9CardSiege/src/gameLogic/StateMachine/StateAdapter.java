
package gameLogic.StateMachine;

import gameLogic.GameData;
import java.io.Serializable;

public class StateAdapter implements IStates, Serializable{
    private final GameData gameData;
    private IStates oldState;
    
    public StateAdapter(GameData gameData) {
        this.gameData = gameData;
        this.oldState = null;
    }

    public StateAdapter(GameData gameData, IStates oldState) {
        this.gameData = gameData;
        this.oldState = oldState;
    }
    
    
    @Override
    public IStates start(){
        return this;
    }
    
    @Override
    public IStates restart(){
        return this;
    };
   
    @Override
    public IStates endOfTurn(IStates oldstate){
        return this;
    };
    @Override
    public IStates drawCard(){
        return this;
    };
    @Override
    public IStates endOfGame(boolean ganhou){
        return this;
    };
    @Override
    public IStates endOfAction(){
        return this;
    };
    @Override
    public IStates archerAttack(){
        return this;
    };
    @Override
    public IStates extraAction(){
        return this;
    };
    @Override
    public IStates rally(){
        return this;
    };
    @Override
    public IStates extraMoral(boolean reduceSupplies){
        return this;
    };
    @Override
    public IStates boilingWater(){
        return this;
    };
    @Override
    public IStates closeCombat1(){
        return this;
    };
    @Override
    public IStates closeCombat2(){
        return this;
    };
    @Override
    public IStates coupure(){
        return this;
    };
    @Override
    public IStates sabotage(){
        return this;
    };
    @Override
    public IStates raid(){
        return this;
    };
    @Override
    public IStates enterTunnel(){
        return this;
    };
    
    @Override
    public IStates moveForward(){
        return this;
    };
    
    @Override
    public IStates moveBackward(){
        return this;
    };
    
    @Override
    public IStates fastTravel(){
        return this;
    };
    
    @Override
    public IStates getOldState() {
        return oldState;
    }
    
    public GameData getGameData() {
        return gameData;
    }
    
    
}
