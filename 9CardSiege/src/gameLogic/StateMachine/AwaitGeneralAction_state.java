package gameLogic.StateMachine;

import gameLogic.GameData;


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
        
        if(getGameData().inTurn_LoseCondition())
            return new AwaitRestart_state(getGameData(), false);
        
        getGameData().reduceActionPoints();
        return this; 
    }
    
    @Override
    public IStates coupure() {
        int diceResult= getGameData().diceRoll(getGameData().getDRMCoupure());
        if(diceResult >4)
            getGameData().increaseWallStrength();
   
        getGameData().reduceActionPoints();
        return this; 
    }
    
    @Override
    public IStates closeCombat2() {
        return new CloseCombatTrackSelection_state(getGameData(),this);
    }

    @Override
    public IStates boilingWater() {
        if(getGameData().isAnyEnemyIn(1).size() > 0 && !getGameData().isBoillingWaterUsed())
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
    public IStates endOfTurn(IStates oldstate) {
        //É sempre chamado pelas outras funções, quando AP == 0
        
        if(getGameData().endOfTurn_LoseCodition())
            return new AwaitRestart_state(getGameData(),false);
        
        if(getGameData().getSizeOfDeck() == 0){
            if(getGameData().getCurrentDay()==2)
                return new AwaitRestart_state(getGameData(),true);

            getGameData().endOfDay();
        }
        //restaurar dados antes de retirar nova carta
        getGameData().setExtraActionUsed(false);
        getGameData().setBoillingWaterUsed(false);
        getGameData().setFreeTunnelMoveUsed(false);
        //
        return new AwaitTopCard_state(getGameData(),oldstate); 
    }
    
    
    @Override
    public IStates endOfGame(boolean ganhou) {
        
        return new AwaitRestart_state(getGameData(),ganhou); 
    }

    @Override
    public IStates enterTunnel() {
        getGameData().moveSoldiersTorwardsEnemyLines();
        getGameData().reduceActionPoints();

        return new AwaitPt1TunnelAction_state(getGameData());
    }

}
