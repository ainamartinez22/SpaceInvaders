package invaders;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path)); //path seria elnom de la imatge
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1); //si no carreguem la imatge el joc no funcionara
		} 
		return null;
	}
}
