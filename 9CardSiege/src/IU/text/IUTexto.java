package IU.text;

import gameLogic.StateMachine.ArcherAttackTrackSelection_state;
import gameLogic.StateMachine.AwaitEnemyLineAction_state;
import gameLogic.StateMachine.AwaitGeneralAction_state;
import gameLogic.StateMachine.AwaitPt1TunnelAction_state;
import gameLogic.StateMachine.AwaitPt2TunnelAction_state;
import gameLogic.StateMachine.AwaitRestart_state;
import gameLogic.StateMachine.AwaitRestrictedAction_state;
import gameLogic.StateMachine.AwaitTopCard_state;
import gameLogic.StateMachine.BoilingAttackTrackSelection_state;
import gameLogic.StateMachine.CloseCombatTrackSelection_state;
import gameLogic.StateMachine.IStates;
import gameLogic.StateMachine.RallySelection_state;
import gameLogic.StateMachine.StatusReductionSelection_state;
import gameLogic.StateMachine._StateMachine;
import java.util.Scanner;

public class IUTexto {
    private _StateMachine game;
    Boolean sair = false;

    public IUTexto(_StateMachine game) {
        this.game = game;
    }
    
   public void run(){
       
       while(!sair){
           IStates state = game.getState();
           
           if (state instanceof AwaitTopCard_state)
               iuMachineAwaitTopCard();
           else if(state instanceof AwaitRestart_state)
               iuMachineRestart();
           else if(state instanceof AwaitEnemyLineAction_state)
               iuMachineEnemyLine();
           else if(state instanceof AwaitGeneralAction_state)
               iuMachineGeneralAction();
           else if (state instanceof AwaitRestrictedAction_state)
               iuMachineEventRestricted();
           else if (state instanceof AwaitPt1TunnelAction_state)
               iuMachineTunnelPt1();
           else if (state instanceof AwaitPt2TunnelAction_state)
               iuMachineTunnelPt2();
           else if (state instanceof ArcherAttackTrackSelection_state)
               iuMachineArcherAttack();
           else if (state instanceof BoilingAttackTrackSelection_state)
               iuMachineBoilingWater();
           else if (state instanceof CloseCombatTrackSelection_state)
               iuMachineCloseCombat();
           else if(state instanceof StatusReductionSelection_state)
               iuMachineExtraAction();
           else if(state instanceof RallySelection_state)
               iuMachineRally(); 
       }
   }
   private int getInt(){
       Scanner s;
       s = new Scanner(System.in);
       while(!s.hasNextInt())
           s.next();
       
       int opcao = s.nextInt();
       return opcao;
   }
   
   private boolean getBooleanFromAnswer(int answer){
       if (answer == 1)
           return false;
       else
           return true;
   }
   
   private char getCharFromAnswer(int answer){
       if (answer ==1)
           return 's';
       else return 'm';
   }
   
  private void iuMachineAwaitTopCard(){
        System.out.println(game.getState().toString());
   }
  
  private void iuMachineRestart(){
       System.out.println(game.getState().toString());

      int answer = getInt();
       
       switch(answer){
           case 1:
            game.restart();
            break;
           case 2:
             sair = true;
             break;
       }
   }
  
   private void iuMachineEnemyLine(){
       System.out.println(game.getState().toString());

       int answer=getInt();
           
        switch(answer){
           case 1:
                game.archerAttack();
                break;
           case 2:
                game.boilingWater();
                break;
           case 3:
                game.extraAction();
                break;
           case 4:
               game.rally();
               break;
           case 5:
               game.sabotage();
               break;
           case 6:
               game.raid();
               break;
           case 7:
               game.enterTunnel();
               break;
           case 8:
               game.saveGame();
               break;
           case 9:
               game.loadGamee();
               break;   
        }
   }
   
   private void iuMachineGeneralAction(){
       System.out.println(game.getState().toString());

       int answer=getInt();
       switch(answer){
           case 1:
                game.archerAttack();
                break;
           case 2:
                game.boilingWater();
                break;
           case 3:
                game.extraAction();
                break;
           case 4:
               game.rally();
               break;
           case 5:
               game.enterTunnel();
               break;
               
        }
   }
   
   private void iuMachineEventRestricted(){
       int answer=getInt();
           
        switch(answer){
           case 1:
               game.sabotage();
               break;
           case 2:
               game.raid();
               break;
        }
   }
   
   private void iuMachineTunnelPt1(){
       System.out.println(game.getState().toString());
       int answer=getInt();
       switch(answer){
           case 1:
                game.archerAttack();
                break;
           case 2:
                game.boilingWater();
                break;
           case 3:
                game.extraAction();
                break;
           case 4:
               game.rally();
               break;
           case 5:
               game.moveForward();
               break;
           case 6:
               game.fastTravel();
               break;
           case 7:
               game.moveBackward();
               break;
               
        }
   }
   private void iuMachineTunnelPt2(){
       System.out.println(game.getState().toString());
       int answer=getInt();
       
       switch(answer){
           case 1:
                game.archerAttack();
                break;
           case 2:
                game.boilingWater();
                break;
           case 3:
                game.extraAction();
                break;
           case 4:
               game.rally();
               break;
           case 5:
               game.moveBackward();
               break;
           case 6:
               game.fastTravel();
               break;
           case 7:
               game.moveForward();
               break;
               
        }
   }
   private void iuMachineArcherAttack(){
       System.out.println(game.getState().toString());
       int answer=getInt();

       game.trackSelection(answer);
          
   }
    
   private void iuMachineCloseCombat(){
       System.out.println(game.getState().toString());
       int answer=getInt();

       game.positionSelection(answer);
   }
   
   private void iuMachineBoilingWater(){
       System.out.println(game.getState().toString());
       int answer=getInt();

       game.trackSelection(answer);
   }
   private void iuMachineExtraAction(){
       System.out.println(game.getState().toString());
       int answer=getInt();

       game.statusSelection(getCharFromAnswer(answer));
   }
   
   private void iuMachineRally(){
       System.out.println(game.getState().toString());
       int answer=getInt();

       game.extraMoral(getBooleanFromAnswer(answer));
   }
}
