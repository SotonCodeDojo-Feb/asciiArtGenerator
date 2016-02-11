import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * ASCII Art Generator
 *
 * @author Huw Jones
 * @since 11/02/2016
 */
public class asciiGenerator {

    private HashMap<Integer, Character> charMap;

    public asciiGenerator (String picture) {
        if(!loadCharMap()){
            System.err.println("Failed to load character map.\n Quitting...");
            return;
        }
    }

    private boolean loadCharMap(){

    }

    //
    private BufferedImage loadImage (BufferedImage image) {

    }

    // Hannah
    private BufferedImage resizeImage (BufferedImage image) {

    }

    // Jamie's Task
    private BufferedImage convertToGreyScale (BufferedImage image) {

    }

    // Huw's Job
    private String getASCII (BufferedImage image) {

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                float luminosity = (image.getRGB(x, y) & 0xff) / 16f;
                int charValue = Double.valueOf(Math.floor(luminosity)).intValue();


            }
        }


    }
}
