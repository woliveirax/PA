package gameLogic.StateMachine;

public interface IStates{
    IStates start();//chama o estado drawCard
    //IStates exit();
    //IStates saveAndExit();
    
    IStates getOldState();
    IStates restart();
    IStates drawCard();
    IStates endOfTurn(IStates oldstate);
    IStates closeCombat2(int trackSelection);
    IStates endOfGame(boolean ganhou,boolean restart);
    IStates archerAttack(int trackSelection);
    IStates extraAction(char supplyToReduce);
    IStates rally(boolean ReduceSupplies);
    IStates boilingWater(int trackSelection);
    IStates extraMoral();
    IStates endOfAction();    
    IStates closeCombat1();
    IStates coupure();
    IStates sabotage();
    IStates raid();
    IStates enterTunnel();
    IStates moveForward();
    IStates moveBackward();
    IStates fastTravel();
}
