package invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Menu {

	public Rectangle playButton = new Rectangle(Joc.AMPLE/2-100,200,200,70);
	public Rectangle helpButton = new Rectangle(Joc.AMPLE/2-100,270+30,200,70);
	public Rectangle classificationButton = new Rectangle(Joc.AMPLE/2-100,340+60,200,70);
	private BufferedImage sky;

	
	public void render(Graphics g) {
		sky=ImageLoader.loadImage("/image/sky.jpg");
		Graphics2D g2d= (Graphics2D) g;
		g.drawImage(sky, 0, 0, Joc.AMPLE, Joc.ALT,null);
		Font fnt0= new Font("verdana",Font.BOLD,50);
		
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SPACE INVADERS", Joc.AMPLE/5, 100);
		
		Font fnt1= new Font("verdana",Font.BOLD,25);
		g.setFont(fnt1);
		
		//RECTANGLES
		g2d.setColor(Color.black);
		g2d.fill(playButton);
		g2d.fill(helpButton);
		g2d.fill(classificationButton);
		
		g2d.setColor(Color.blue);
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(classificationButton);
		

		//TEXT
		g.setColor(Color.white);
		g.drawString("PLAY", playButton.x+playButton.width/3, playButton.y+40);
		g.drawString("HELP", helpButton.x+helpButton.width/3, helpButton.y+40);
		g.drawString("RANKING",classificationButton.x+classificationButton.width/6, classificationButton.y+40);
		
	}
	
}
