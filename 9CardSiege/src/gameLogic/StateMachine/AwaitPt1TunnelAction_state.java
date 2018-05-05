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
public class AwaitPt1TunnelAction_state extends StateAdapter{

    public AwaitPt1TunnelAction_state(GameData gameData) {
        super(gameData);
    }
      ///////Precisam do estado anterior
    @Override
    public IStates closeCombat2() {
        return new CloseCombatTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates boilingWater() {
        return new BoilingAttackTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates rally() {
        return new ArcherAttackTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates extraAction() {
        return new StatusReductionSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates archerAttack() {
        return new ArcherAttackTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates endOfTurn() {
        return new AwaitTopCard_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }
    
    //////////
    @Override
    public IStates moveForward() {
        //means go to pt 2
        //s boolean do freemovetunnel_uSed estiver a falso 
            //mudar estado p pos a seguir
            //mudar pos no tunnel
            //mudar bool p verdadeiro
        return new AwaitPt2TunnelAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates moveBackward() {
        //means go to castle
        //s boolean do freemovetunnel_uSed estiver a falso 
            //mudar estado p pos a seguir
            //mudar pos no tunnel
            //mudar bool p verdadeiro
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates fastTravel() {
        //to enemy line
        return new AwaitEnemyLineAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public IStates closeCombat1() {
        return this; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public IStates coupure() {
        return this; //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public IStates endOfGame(Boolean ganhou) {
        return new AwaitRestart_state(getGameData(), ganhou); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)Move to tunnel pt 2(6)Fast travel to enemy line\t(7)Exit tunnel\n";
    }
}
