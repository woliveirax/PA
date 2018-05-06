package IU.text;

import gameLogic.StateMachine.IStates;
import gameLogic.StateMachine._StateMachine;

public class IUTexto {
    private _StateMachine game;
    Boolean sair = false;

    public IUTexto(_StateMachine game) {
        this.game = game;
    }
    
   public void corre(){
       
       while(!sair){
           IStates state = game.getState();
           
           //if(state instanceof )
       }
   }         
}
