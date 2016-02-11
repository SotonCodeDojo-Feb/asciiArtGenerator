import java.io.*;
/**
 * {DESCRIPTION}
 *
 * @author Huw Jones
 * @since 11/02/2016
 */
public class Main {

    public static void main(String args[]){
        if(args.length != 1){
            System.err.println("No picture specified.");
            return;
        }
        File image = new File(args[0]);
        if(!image.exists()){
            System.err.println("Image \"" + args[0] + "\" not found!");
        }
        if(!image.canRead()){
            System.err.println("Image \"" + args[0] + "\" could not be opened!");
        }

        asciiGenerator generator = new asciiGenerator(args[0]);
    }
}
