package gameLogic.StateMachine;

public interface IStates{
    IStates start();//chama o estado drawCard
    //IStates exit();
    //IStates saveAndExit();
    
    IStates getOldState();
    IStates restart();
    IStates drawCard();
    IStates endOfTurn(IStates oldstate);
    IStates closeCombat2();
    IStates endOfGame(boolean ganhou);
    IStates archerAttack();
    IStates extraAction();
    IStates rally();
    IStates boilingWater();
    IStates closeCombat1();
    IStates coupure();
    IStates sabotage();
    IStates raid();
    IStates enterTunnel();
    IStates moveForward();
    IStates moveBackward();
    IStates fastTravel();
    
    IStates endOfAction();    
    IStates trackSelection(int track);
    IStates PositionSelection(int pos);
    IStates statusSelection(char stats);
    IStates extraMoral(boolean reduceSupplies);    
}
