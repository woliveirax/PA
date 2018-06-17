package IU.GUI;

import IU.GUI.Constants.ImageConstants;
import static IU.GUI.Constants.ImageConstants.path_backCard;
import static IU.GUI.Constants.ImageConstants.path_background;
import static IU.GUI.Constants.ImageConstants.path_card1;
import static IU.GUI.Constants.ImageConstants.path_card2;
import static IU.GUI.Constants.ImageConstants.path_card3;
import static IU.GUI.Constants.ImageConstants.path_card4;
import static IU.GUI.Constants.ImageConstants.path_card5;
import static IU.GUI.Constants.ImageConstants.path_card6;
import static IU.GUI.Constants.ImageConstants.path_card7;
import static IU.GUI.Constants.ImageConstants.path_cardCastle;
import static IU.GUI.Constants.ImageConstants.path_cardEnemies;
import static IU.GUI.Constants.ImageConstants.path_dice1;
import static IU.GUI.Constants.ImageConstants.path_dice2;
import static IU.GUI.Constants.ImageConstants.path_dice3;
import static IU.GUI.Constants.ImageConstants.path_dice4;
import static IU.GUI.Constants.ImageConstants.path_dice5;
import static IU.GUI.Constants.ImageConstants.path_dice6;
import static IU.GUI.Constants.ImageConstants.path_loosePopUp;
import static IU.GUI.Constants.ImageConstants.path_trebuchetsToken;
import static IU.GUI.Constants.ImageConstants.path_tunnelPosToken;
import static IU.GUI.Constants.ImageConstants.path_tunnelSuppliesToken;
import static IU.GUI.Constants.ImageConstants.path_winPopUp;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Resources implements ImageConstants{
    
    private static List<Image> card_images = new ArrayList();
    private static List<Image> dice_faces = new ArrayList();
    private static Image background = null;
    private static Image winPopUp, loosePopUp;
    private static Image castleToken,tunnelSuppliesToken;
    private static Image tunnelPosToken,trebuchetToken;
    
    
    
    //Load Background
    static {
        try {
            background = ImageIO.read(Resources.getResourceFile(path_background));
        } catch (IOException e) {
            System.out.println("Error loading background");
        }
    }
    
    //Load end image
    static {
        try {
            winPopUp = ImageIO.read(Resources.getResourceFile(path_winPopUp));
            loosePopUp = ImageIO.read(Resources.getResourceFile(path_loosePopUp));
        } catch (IOException e) {
            System.out.println("Error loading background");
        }
    }
    
    //Load Tokens
    static {
        try {
            castleToken         = ImageIO.read(Resources.getResourceFile(path_castleToken));
            tunnelSuppliesToken = ImageIO.read(Resources.getResourceFile(path_tunnelSuppliesToken));
            tunnelPosToken      = ImageIO.read(Resources.getResourceFile(path_tunnelPosToken));
            trebuchetToken      = ImageIO.read(Resources.getResourceFile(path_trebuchetsToken));
            
        } catch (IOException e) {
            System.out.println("Error loading tokens");
        }
    }
    
    //Load Dice Faces
    static {
        try {
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice1)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice2)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice3)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice4)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice5)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice6)));
            
            } catch (IOException e) {
                System.out.println("Error loading dice images");
            }
    }
    
    //Load Cards
    static {
        try {
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card1)));
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card2)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card3)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card4)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card5)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card6)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_card7)));
            card_images.add(ImageIO.read(Resources.getResourceFile(path_cardCastle)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_cardEnemies)));                                                                                                                    
            card_images.add(ImageIO.read(Resources.getResourceFile(path_backCard)));                                                                                                                    
                       
            } catch (IOException e) {
                System.out.println("Error loading card images");
            }
    }

    public static List<Image> getCard_images() {
        return card_images;
    }

    public static List<Image> getDice_faces() {
        return dice_faces;
    }
    
    public static Image getCard_image(int pos) {
        return card_images.get(pos);
    }

    public static Image getDice_face(int pos) {
        return dice_faces.get(pos);
    }
    
    public static Image getBackground() {
        return background;
    }

    public static Image getWinPopUp() {
        return winPopUp;
    }

    public static Image getLoosePopUp() {
        return loosePopUp;
    }

    public static Image getCastleToken() {
        return castleToken;
    }

    public static Image getTunnelSuppliesToken() {
        return tunnelSuppliesToken;
    }

    public static Image getTunnelPosToken() {
        return tunnelPosToken;
    }

    public static Image getTrebuchetToken() {
        return trebuchetToken;
    }
    
    public static final URL getResourceFile(String name){
            // opens a file with path relative to location of the Resources class
            URL url=Resources.class.getResource(name);
            return url; 
    }
}