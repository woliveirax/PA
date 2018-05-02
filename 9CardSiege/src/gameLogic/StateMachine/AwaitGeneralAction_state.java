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
public class AwaitGeneralAction_state extends StateAdapter{

    public AwaitGeneralAction_state(GameData gameData) {
        super(gameData);
    }
    
    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)EnterTunnel";
    }

    @Override
    public IStates enterTunnel() {
        setOldState(this);
        
        getGameData().moveSoldiersTorwardsEnemyLines();
        return new AwaitPt1TunnelAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
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
        int ladder=getGameData().getLadderPosition(), bat=getGameData().getBatteringRamPosition(), tower=getGameData().getTowerPosition();        
        if(ladder==1 || bat==1 || tower==1){
            setOldState(this);
            return new BoilingAttackTrackSelection_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
        }   
        return this;
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

}
