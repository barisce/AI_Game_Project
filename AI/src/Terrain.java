import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Terrain {
	public Image texture;
	public String modifier;
	
	public Terrain () throws IOException
	{
		texture = ImageIO.read(new File("C:/Users/Ubeyd/Desktop/DERS/CS 461/assets/grass_32.png"));
	}
	
	public Terrain (int type) throws IOException
	{
		if (type == 0) // grass
		{
			texture = ImageIO.read(new File("C:/Users/Ubeyd/Desktop/DERS/CS 461/assets/grass_32.png"));
		}
		else if (type == 1) // snow
		{
			texture = ImageIO.read(new File("C:/Users/Ubeyd/Desktop/DERS/CS 461/assets/snow_32.png"));
		}
		else //default
		{
			texture = ImageIO.read(new File("C:/Users/Ubeyd/Desktop/DERS/CS 461/assets/grass_32.png"));
		}
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
}
