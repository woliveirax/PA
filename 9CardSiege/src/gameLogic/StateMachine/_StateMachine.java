/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

/**
 *
 * @author Olympus
 */
public class _StateMachine {
    
    private IStates state;
    private GameData gamedata;

    public _StateMachine() {
        gamedata = new GameData();
        state = new AwaitTopCard_state(gamedata);
    }
    
    public void setState(IStates state) { this.state = state; }    
    public void endOfTurn(){setState(state.endOfTurn());};
    public void drawCard(){setState(state.drawCard());};  
    public void endOfGame(){setState(state.endOfGame(true));};
    public void endOfAction(){setState(state.endOfAction());};
    public void archerAttack(){setState(state.archerAttack());};
    public void extraAction(){setState(state.extraAction()); };
    public void rally(){setState(state.rally());};
    public void restart(){setState(state.restart());};
    public void extraMoral(){setState(state.extraMoral());};
    public void boilingWater(){setState(state.boilingWater());};
    public void closeCombat1(){setState(state.closeCombat1()); };
    public void closeCombat2(){setState(state.closeCombat2()); };
    public void coupure(){setState(state.coupure()); };
    public void sabotage(){setState(state.sabotage()); };
    public void raid(){setState(state.raid()); };
    public void enterTunnel(){setState(state.enterTunnel()); };
    public void moveForward(){setState(state.moveForward()); };
    public void moveBackward(){setState(state.moveBackward()); };
    public void fastTravel(){setState(state.fastTravel()); };
    
}
