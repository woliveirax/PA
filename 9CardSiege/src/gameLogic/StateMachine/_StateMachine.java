package gameLogic.StateMachine;

import gameLogic.GameData;
import java.io.Serializable;


public class _StateMachine implements Serializable {
    
    private IStates state;
    private GameData gamedata;

    public _StateMachine() {
        gamedata = new GameData();
        state = new AwaitTopCard_state(gamedata);
        
    }

    public GameData getGamedata() {
        return gamedata;
    }
    
    public IStates getState()
    {
        return state;
    }
    
    public void setState(IStates state) { 
        this.state = state;
    }    
//Acoes q n implicam o jogador:
    public void start(){
        if(state instanceof AwaitTopCard_state)
            setState(state.start());
    }
    
    public void endOfTurn(){setState(state.endOfTurn(state));};
    public void drawCard(){setState(state.drawCard());};  
    public void endOfGame(){setState(state.endOfGame(true));};
    public void endOfAction(){setState(state.endOfAction());};
    public void restart(){setState(state.restart());};
//
//Açoes escolhidas pelo jogador:    
    public void closeCombat1(){        
        setState(state.closeCombat1());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    
    public void coupure(){
        setState(state.coupure()); 
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    
    public void sabotage(){
        setState(state.sabotage());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    public void raid(){
        setState(state.raid());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    
    public void archerAttack(){
        setState(state.archerAttack());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    public void extraAction(){
        setState(state.extraAction());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    public void rally(){
        setState(state.rally());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    public void extraMoral(){setState(state.extraMoral());};
    public void boilingWater(){
        setState(state.boilingWater());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    public void closeCombat2(){
        setState(state.closeCombat2());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    
    public void enterTunnel(){
        setState(state.enterTunnel());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    public void moveForward(){setState(state.moveForward()); };
    public void moveBackward(){setState(state.moveBackward()); };
    
    public void fastTravel(){
        setState(state.fastTravel());
        if(gamedata.getActionPoints()==0)
            endOfTurn();
    };
    
    @Override
    public String toString() {
        String s = gamedata.toString();
        s += "\n\n______________________"+"\n"+state.toString();
        return s;
    }
}
