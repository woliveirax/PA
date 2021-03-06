package IU.GUI;

import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine._StateMachine;
import FileManager.Typewriter;
import IU.GUI.Constants.FrameConstants;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class GameFrame extends JFrame implements Observer{

    private ObservableGame observable;
    private GamePanel gamePanel;
    
    public GameFrame( ObservableGame j) {
        this(j, 200,100, FrameConstants.DIM_FRAME_X,FrameConstants.DIM_FRAME_Y);
    }

    public GameFrame( ObservableGame j, int x, int y ) {
        this(j, x,y, 1050, 600);
    }

    public GameFrame(ObservableGame obs, int x, int y, int width, int height) {

        super("9 Cards Siege");

        observable = obs;
        this.observable.addObserver(this);
        
        Container cp = getContentPane();

        createBarMenus();
        gamePanel = new GamePanel(observable);
        cp.add(gamePanel,BorderLayout.CENTER);
        
        
        setLocation(x, y);
        setSize(width,height);
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        update(observable, null);

    }
    private void createBarMenus() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //GAME DropDown
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        
        //Restart game Item
        JMenuItem restartItem = new JMenuItem("Restart Game");
        restartItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        
        //LOAD game Item
        JMenuItem loadItem = new JMenuItem("Load Game");
        loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        
        //SAVE game Item
        JMenuItem saveItem = new JMenuItem("Save Game");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
        //EXIT game Item
        JMenuItem exitItem = new JMenuItem("Quit Game");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        
        //Building up Game DropDown List
        gameMenu.add(restartItem);
        gameMenu.addSeparator();
        gameMenu.add(loadItem);
        gameMenu.add(saveItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);
        menuBar.add(gameMenu);
        
        //Assigning listeners to Each Drop down item
        restartItem.addActionListener(new RestartGameListener());
        loadItem.addActionListener(new LoadGameListener());
        saveItem.addActionListener(new SaveGameListener());
        exitItem.addActionListener(new ExitListener());


        //HELP drop down
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        //TODO: find out how to put a PDF with instructions in here!
        //Game Instructins Item
        JMenuItem instructionsItem = new JMenuItem("Instructions");
        instructionsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        
        //About creators Item
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        
        //Building up Help DropDown list
        helpMenu.add(instructionsItem);
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);
        
        //Assigning listeners to help menu
        instructionsItem.addActionListener(new InstructionsListener());
        aboutItem.addActionListener(new AboutListener());

    }
    
    class RestartGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog(GameFrame.this,"Are you sure you want to RESTART the game?","Restart?", JOptionPane.YES_NO_OPTION) == 0)
                observable.restart();
        }
    }
    
    class LoadGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./gameData");
            int returnVal = fc.showOpenDialog(GameFrame.this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                
                try{
                    _StateMachine stateMachine = (_StateMachine) Typewriter.loadGame(file);
                    
                    if(stateMachine != null){
                        observable.setStateMachine(stateMachine);
                    }
                    
                }catch(IOException | ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(GameFrame.this, "Operation failed: \r\n\r\n" + e);
                } catch(Exception x) {
                    System.out.println("Erro ao ler o ficheiro " + file);
                }
                
            } else {
                System.out.println("Operation canceled ");
            }
        }
    }

    class SaveGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./gameData");
            int returnVal = fc.showSaveDialog(GameFrame.this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try{
                    Typewriter.saveGame(observable.getStateMachine(),file);
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(GameFrame.this, "Operation failed: \r\n\r\n" + e);
                }
            } else {
                System.out.println("Operation canceled ");
            }
        }
    }
    
    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( JOptionPane.showConfirmDialog(GameFrame.this, "Do you realy want to EXIT the game?", "Exit?", JOptionPane.YES_NO_OPTION) == 0)
            {
                System.exit(0);
            }
        }
    }

    class InstructionsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Point x = getLocationOnScreen();
            new HelpFileFrame("Game Instructions", Resources.getResourceFile("Images/game_instructions.html"),x.x,x.y);
        }
    }

    class AboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(GameFrame.this,
                    "Trabalho Realizado por:\n" +
                    "Joana Barata Nº 21260792;\n" +
                    "Wallace Oliveira Nº 21230618;",
                    "About", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @Override
    public void update(Observable o, Object o1) {
    }
}
