package IU.GUI;

import IU.GUI.Constants.ImageConstants;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Resources implements ImageConstants{
    
    private static List<Image> card_images = new ArrayList();
    private static List<Image> dice_faces = new ArrayList();
        
    static {
        try {
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice1)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice2)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice3)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice4)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice5)));
            dice_faces.add(ImageIO.read(Resources.getResourceFile(path_dice6)));
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
    
    public static final URL getResourceFile(String name){
            // opens a file with path relative to location of the Resources class
            URL url=Resources.class.getResource(name);
            return url; 
    }

}
