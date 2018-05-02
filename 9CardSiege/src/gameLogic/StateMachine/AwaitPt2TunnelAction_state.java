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
public class AwaitPt2TunnelAction_state extends StateAdapter{

    public AwaitPt2TunnelAction_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public IStates moveForward() {
        setOldState(this);
        return new AwaitEnemyLineAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates moveBackward() {
        return getOldState(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates fastTravel() {
        //to Castle
        setOldState(this);
        return new AwaitGeneralAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates closeCombat2() {
        setOldState(this);
        return new CloseCombatTrackSelection_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
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
    public IStates boilingWater() {
        setOldState(this);
        return new BoilingAttackTrackSelection_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates rally() {
        setOldState(this);
        return new ArcherAttackTrackSelection_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates extraAction() {
        setOldState(this);
        return new StatusReductionSelection_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates archerAttack() {
        setOldState(this);
        return new ArcherAttackTrackSelection_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates endOfGame() {
        setOldState(this);
        return new AwaitRestart_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates endOfTurn() {
        setOldState(this);
        return new AwaitTopCard_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)move to tunnel pt 1(6)Fast travel to Castle(7)exit tunnel to enemy line\n";
    }
}
