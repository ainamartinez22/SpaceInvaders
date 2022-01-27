package invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SuperAlien {
	
	protected Joc joc;
	int x=Joc.AMPLE, y = 15;
	private BufferedImage superalien;
	public int alt= 25, ample = 50;
	public boolean vida = false;
	
	SuperAlien(Joc joc){
		this.joc=joc;
	}
	
	public void tick() {
		x -= 6;
	}
	
	public void render(Graphics g) {
		superalien=ImageLoader.loadImage("/image/Superalien.png");
		g.drawImage(superalien,x,y,ample,alt,null);
	}	
		
	public void mort(Graphics g) {
		g.setColor(Color.red);
		Font fnt1= new Font("verdana",Font.BOLD,30);
		g.setFont(fnt1);
		g.drawString(Integer.toString(50), x, y+alt);
	}
	
	public void reinici() {
		x = Joc.AMPLE;
	}
	
}
