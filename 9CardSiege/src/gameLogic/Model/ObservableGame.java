package gameLogic.Model;

import gameLogic.GameData;
import gameLogic.StateMachine.IStates;
import gameLogic.StateMachine._StateMachine;
import java.util.Observable;

public class ObservableGame extends Observable{
    _StateMachine game = null;

    public ObservableGame(_StateMachine game) {
        this.game = game;
    }
    
    public GameData getGamedata() {
        return game.getGamedata();
    }
    
    public IStates getState()
    {
        return game.getState();
    }
    
    //Acoes q n implicam o jogador:
    public void start(){
        game.start();
        
        setChanged();
        notifyObservers();
    }
    
    public void drawCard(){
        game.drawCard();
        
        setChanged();
        notifyObservers();
    };
    
    public void endOfGame(){
        game.endOfGame();
        
        setChanged();
        notifyObservers();
    };
    
    public void endOfAction(){
        game.endOfAction();
        
        setChanged();
        notifyObservers();
    };
    
    public void restart(){
        game.restart();
        
        setChanged();
        notifyObservers();
    };
    
    //Açoes escolhidas pelo jogador:    
    public void closeCombat1(){
        game.closeCombat1();
        
        setChanged();
        notifyObservers();
    };
    
    public void coupure(){
        game.coupure();
        
        setChanged();
        notifyObservers();
    };
    
    public void sabotage(){
        game.sabotage();
        
        setChanged();
        notifyObservers();
    };
    
    public void raid(){
        game.raid();
        
        setChanged();
        notifyObservers();
    };
    
    public void archerAttack(){
        game.archerAttack();
        
        setChanged();
        notifyObservers();
    };
    
    public void extraAction(){
        game.extraAction();
        
        setChanged();
        notifyObservers();
    };
    
    public void rally(){
        game.rally();
        
        setChanged();
        notifyObservers();
    };
    
    public void extraMoral(boolean reduceSupplies){
        game.extraMoral(reduceSupplies);
        
        setChanged();
        notifyObservers();
    };
    
    public void boilingWater(){
        game.boilingWater();
        
        setChanged();
        notifyObservers();
    };
    
    public void closeCombat2(){
        game.closeCombat2();
        
        setChanged();
        notifyObservers();
    };
    
    public void enterTunnel(){
        game.enterTunnel();
        
        setChanged();
        notifyObservers();
    };
    
    public void moveForward(){
        game.moveForward();
        
        setChanged();
        notifyObservers();
    };
    
    public void moveBackward(){
        game.moveBackward();
        
        setChanged();
        notifyObservers();
    };
    
    public void fastTravel(){
        game.fastTravel();
        
        setChanged();
        notifyObservers();
    };
    
    public void trackSelection(int track){
        game.trackSelection(track);
        
        setChanged();
        notifyObservers();
    };
    
    public void positionSelection(int pos){
        game.positionSelection(pos);
        
        setChanged();
        notifyObservers();
    }
    
    public void statusSelection(char choice){
        game.statusSelection(choice);
        
        setChanged();
        notifyObservers();
    }
    
    public void setStateMachine(_StateMachine stateMachine){
        game = stateMachine;
        
        setChanged();
        notifyObservers();
    }
}
