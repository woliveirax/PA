package gameLogic.StateMachine;

public interface IStates{
    IStates start();//chama o estado drawCard
    //IStates exit();
    //IStates saveAndExit();
    
    IStates getOldState();
    IStates restart();
    IStates drawCard();
    IStates endOfTurn(IStates oldstate);
    IStates endOfGame(Boolean ganhou);
    IStates endOfAction();
    IStates archerAttack();
    IStates extraAction();
    IStates rally();
    IStates extraMoral();
    IStates boilingWater();
    IStates closeCombat1();
    IStates closeCombat2();
    IStates coupure();
    IStates sabotage();
    IStates raid();
    IStates enterTunnel();
    IStates moveForward();
    IStates moveBackward();
    IStates fastTravel();
}
