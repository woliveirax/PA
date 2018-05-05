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
    public IStates enterTunnel() {
        //means go to tunnel pt 1
        //s action point > 0
        //mudar pos p tunnel 1
        //ir p estado respetivo
        // action point -1
        getGameData().moveSoldiersTorwardsEnemyLines();
        return new AwaitPt1TunnelAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
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
        return new AwaitRestart_state(getGameData(),ganhou); //To change body of generated methods, choose Tools | Templates.
    }

}
