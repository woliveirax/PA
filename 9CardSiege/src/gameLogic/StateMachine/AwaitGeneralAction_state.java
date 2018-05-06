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
    public IStates closeCombat1() {
        int diceResult= getGameData().diceRoll(getGameData().getDRMAttackCloseCombat());
        
        if (diceResult==1)
            getGameData().ReduceMorale();
        else if(diceResult > 4)
            getGameData().getCloseCombatArea().get(0).retreat();
        
        getGameData().reduceActionPoints();
        return this; 
    }
    
    @Override
    public IStates coupure() {
        //verificar q a força da wall <4
        int diceResult= getGameData().diceRoll(getGameData().getDRMCoupure());
        if(diceResult >4)
            getGameData().increaseWallStrength();
   
        getGameData().reduceActionPoints();
        return this; 
    }  
    
    ///////Precisam do estado anterior
    @Override
    public IStates closeCombat2() {
        //quando houverem 2 inimigos em close quarters remeter obrigatoriamente jogador para estado de closecombat2
        //enquanto houverem 2 inimigos ficar sempre neste estado
        //no terceiro inimigo chamar gameOver com string q perdeu
        //Inibir eventos DRM
        //baixar 1 d moral, caso saia 1 no dice
        //TODO: remover closecombat 2 e meter a mudar d estado automaticamente
        return new CloseCombatTrackSelection_state(getGameData(),this); 
    }

    @Override
    public IStates boilingWater() {
        //verificar q existem inimigos na pos 1
        //verificar q o boiling Water ainda n foi utilizado no turno
        //caso saia 1 no dice, s n houver DRM q o aumentem, moral -1
        //meter flag indicadora de utilização do ataque e na mudança de turno remover
        if(getGameData().isAnyEnemyIn(1).size() > 0)
            return new BoilingAttackTrackSelection_state(getGameData(),this);
        
        return this;
    }

    @Override
    public IStates rally() {
        //caso supplies >= 1,  pode-se baixar 1 p obter +1 DRM
        return new RallySelection_state(getGameData(),this); 
    }

    @Override
    public IStates extraAction() {
        //só é feito enquanto ap > 0
        //s boolean d actionIncreasedUsed == false
            //mudar p estado d escolha d istataus
            //meter boolean a true
        if (!getGameData().isExtraActionUsed())  
            return new StatusReductionSelection_state(getGameData(),this); 
        return this;
    }

    @Override
    public IStates archerAttack() {
        return new ArcherAttackTrackSelection_state(getGameData(),this); 
    }

    @Override
    public IStates endOfTurn() {
        //É sempre chamado pelas outras funções, quando AP == 0
        getGameData().setExtraActionUsed(false);
        getGameData().setBoillingWaterUsed(false);
        getGameData().setFreeTunnelMoveUsed(false);
        return new AwaitTopCard_state(getGameData(),this); 
    }
    
    
    @Override
    public IStates endOfGame(Boolean ganhou) {
        return new AwaitRestart_state(getGameData(),ganhou); 
    }

    @Override
    public IStates enterTunnel() {
        //means go to tunnel pt 1
        //s action point > 0
        //mudar pos p tunnel 1
        //ir p estado respetivo
        // action point -1
        getGameData().moveSoldiersTorwardsEnemyLines();
        getGameData().reduceActionPoints();

        return new AwaitPt1TunnelAction_state(getGameData());
    }

}
