package gameLogic;

import gameLogic.StateMachine._StateMachine;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Typewriter {
    
    public ObjectOutputStream openWriteRegister(String file) throws IOException{
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            return out;
        } catch(IOException e) {
            System.out.println("Erro ao abrir o ficheiro " + file);
            throw e;
        }
    }
    
    
   public ObjectInputStream OpenReadRegister(String file) throws IOException{
       try {
            ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(file));
            return in;
        } catch(IOException e) {
            System.out.println("Erro ao abrir o ficheiro " + file);
            throw e;
        }
   }
   
    public void saveGame(_StateMachine data, String file) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = openWriteRegister(file);
            out.writeObject(data);
        } catch(IOException e) {
            System.out.println("Erro ao escrever o ficheiro " + file);
            throw e;
        } finally {
            if(out != null) out.close();
        }
    }
    
    public _StateMachine loadGame(String file) throws Exception {
        ObjectInputStream in = null;
        _StateMachine data = null;
        try {
            in = OpenReadRegister(file);
            data = (_StateMachine)in.readObject();
            return data;                
        } catch (EOFException e){
            System.out.println("Fim de ficheiro:" + file);
            throw e;
        } catch( ClassNotFoundException e) {
            System.out.println("Erro ao reconstruir o objecto");
            throw e;
        } catch( IOException e) {
            System.out.println("Erro ao ler o ficheiro " + file);
            throw e;
        } finally {
            if( in != null) in.close();
        }
    }
}
