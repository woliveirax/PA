/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

//EM todos os estados verificar AP, se estiver == 0
public class AwaitEnemyLineAction_state extends StateAdapter{

    public AwaitEnemyLineAction_state(GameData gameData) {
        super(gameData);
    }

    @Override
    public IStates raid() {
        //dependendo do dice roll aumenta-se nº diferente de supplies,
        //se for = 1 deixxa de haver tropas no EL -> meter null no tunnel
        return this; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates sabotage() {
        //dependendo do dice roll aumenta-se nº diferente de trebuchets,
        //se for = 1 deixxa de haver tropas no EL -> meter null no tunnel
        return this; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates moveBackward() {
        getGameData().moveSoldiersTorwardsCastle();
        //get action point e verificar q >= 1
        //reduzir action point, pq esta a entrar no tunel
        //meter na pos e estado do tunnel 2
        return new AwaitPt2TunnelAction_state(getGameData()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates closeCombat1() {
        //verificar q no closecombat só existe 1 inimigo
        //Inibir eventos DRM
        //baixar 1 d moral, caso saia 1 no dice
        return this; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates coupure() {
        //verificar q a força da wall <4
        return this; //To change body of generated methods, choose Tools | Templates.
    }  
    
    ///////Precisam do estado anterior
    @Override
    public IStates closeCombat2() {
        //quando houverem 2 inimigos em close quarters remeter obrigatoriamente jogador para estado de closecombat2
        //enquanto houverem 2 inimigos ficar sempre neste estado
        //no terceiro inimigo chamar gameOver com string q perdeu
        //Inibir eventos DRM
        //baixar 1 d moral, caso saia 1 no dice
        return new CloseCombatTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates boilingWater() {
        //verificar q existem inimigos na pos 1
        //verificar q o boiling Water ainda n foi utilizado no turno
        //caso saia 1 no dice, s n houver DRM q o aumentem, moral -1
        //meter flag indicadora de utilização do ataque e na mudança de turno remover
        return new BoilingAttackTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates rally() {
        //caso supplies >= 1,  pode-se baixar 1 p obter +1 DRM
        return new RallySelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates extraAction() {
        //só é feito enquanto ap > 0
        //s boolean d actionIncreasedUsed == false
            //mudar p estado d escolha d istataus
            //meter boolean a true
            
        return new StatusReductionSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates archerAttack() {
        return new ArcherAttackTrackSelection_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates endOfTurn() {
        //É sempre chamado pelas outras funções, quando AP == 0
        return new AwaitTopCard_state(getGameData(),this); //To change body of generated methods, choose Tools | Templates.
    }
    
    //////////
    @Override
    public IStates endOfGame(Boolean ganhou) {
        return new AwaitRestart_state(getGameData(),ganhou); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Actions allowed:\n(1)Archer Attack\t(2)Boiling Attack\t(3)Status Reduction\t"+""
                + "(4)Rally\t(5)Sabotage\t(6)Sabotage\t(7)Raid(8)EnterTunnel\n";
    }

}
