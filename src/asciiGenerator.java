import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import org.json.*;

/**
 * ASCII Art Generator
 *
 * @author Huw Jones
 * @since 11/02/2016
 */
public class asciiGenerator {

    private HashMap<Integer, Character> charMap;

    public asciiGenerator (String imageFile) {
        if (!loadCharMap()) {
            System.err.println("Failed to load character map.\n Quitting...");
            return;
        }

        BufferedImage image;
        image = this.loadImage(imageFile);
        image = this.resizeImage(image, 512);
        image = this.convertToGreyScale(image);
        String output = this.getASCII(image);
        System.out.println(output);
    }

    private boolean loadCharMap () {
        File map = new File("map.json");
        if (!map.exists() || !map.canRead()) {
            return false;
        }
    }

    //
    private BufferedImage loadImage (String imageFile) {

    }

    // Hannah
    public BufferedImage getResizedImage(BufferedImage img, int width){
        int currentHeight = img.getHeight();
        int currentWidth = img.getWidth();

        int newWidth = width;
        int newHeight = width * currentWidth/currentHeight;

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, img.getType());
        Graphics2D grp = resizedImage.createGraphics();
        grp.drawImage(img, 0, 0, newWidth, newHeight, null);
        grp.dispose();

        return(resizedImage);
    }


    // Jamie's Task
    private BufferedImage convertToGreyScale (BufferedImage image) {
        for (int x = 0; x < image.getWidth(); ++x)
            for (int y = 0; y < image.getHeight(); ++y) {
                int rgb = image.getRGB(x, y);
                int r = ( rgb >> 16 ) & 0xFF;
                int g = ( rgb >> 8 ) & 0xFF;
                int b = ( rgb & 0xFF );

                int grayLevel = ( r + g + b ) / 3;
                int gray = ( grayLevel << 16 ) + ( grayLevel << 8 ) + grayLevel;
                image.setRGB(x, y, gray);
            }
        return image;
    }

    // Huw's Job
    private String getASCII (BufferedImage image) {
        String picture = "";

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                float luminosity = ( image.getRGB(x, y) & 0xff ) / this.charMap.size();
                int charValue = Double.valueOf(Math.floor(luminosity)).intValue();

                picture += this.charMap.get(charValue);
            }
            picture += "\n";
        }

        return picture;
    }
}
