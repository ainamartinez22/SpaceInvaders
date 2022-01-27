package invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Help {
	public Rectangle catalanButton = new Rectangle(10,Joc.ALT-60,120,40);
	public Rectangle spanishButton = new Rectangle(130,Joc.ALT-60,120,40);
	public Rectangle englishButton = new Rectangle(250,Joc.ALT-60,120,40);
	public Rectangle backButton = new Rectangle(10,10,100,40);
	private BufferedImage left,right,space,alien0,alien1,alien2,superalien;
	Font fnt2= new Font("arial",Font.BOLD,30);
	Font fnt0= new Font("verdana",Font.BOLD,50);
	Font fnt1= new Font("arial",Font.BOLD,25);
	
	public void render(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g.setFont(fnt0);
		g.setColor(Color.white);
		
		if(Joc.State==Joc.STATE.HELPCATALAN) {
			g.drawString("INSTRUCCIONS", Joc.AMPLE/4, 100);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("CONTROLS", Joc.AMPLE/11, 180);
			g.setColor(Color.white);
			g.setFont(fnt1);
			g.drawString(":   moure la nau cap a l'esquerra",  Joc.AMPLE/11+80, 200+30);
			g.drawString(":   disparar",  Joc.AMPLE/11+80, 250+30);
			g.drawString(":   moure la nau cap a la dreta",  Joc.AMPLE/11+80, 300+30);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("PUNTS", Joc.AMPLE/11, 420);
			g.setColor(Color.white);
		}
		
		else if(Joc.State==Joc.STATE.HELPSPANISH) {
			g.drawString("INSTRUCCIONES", Joc.AMPLE/4, 100);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("CONTROLES", Joc.AMPLE/11, 180);
			g.setColor(Color.white);
			g.setFont(fnt1);
			g.drawString(":   mover la nave hacia la izquierda",  Joc.AMPLE/11+80, 200+30);
			g.drawString(":   disparar",  Joc.AMPLE/11+80,250+30);
			g.drawString(":   mover la nave hacia la derecha",  Joc.AMPLE/11+80, 300+30);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("PUNTOS", Joc.AMPLE/11, 420);
		}
		else {
			g.drawString("INSTRUCTIONS", Joc.AMPLE/4, 100);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("CONTROLS", Joc.AMPLE/11, 180);
			g.setColor(Color.white);
			g.setFont(fnt1);
			g.drawString(":   move the ship to the left",  Joc.AMPLE/11+80, 200+30);
			g.drawString(":   shoot",  Joc.AMPLE/11+80,250+30);
			g.drawString(":   move the ship to the right",  Joc.AMPLE/11+80, 300+30);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("POINTS", Joc.AMPLE/11, 420);
		}
		
		g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString("=  10",  Joc.AMPLE/11+80, 500);
		g.drawString("=  20",  Joc.AMPLE/11+80, 561);
		g.drawString("=  30",  Joc.AMPLE/11+80, 622);
		g.drawString("=  50", Joc.AMPLE-285, 555);
		
		//RECTANGLES
		g2d.setColor(Color.black);
		g2d.fill(catalanButton);
		g2d.fill(spanishButton);
		g2d.fill(englishButton);
		g2d.fill(backButton);
		
		g2d.setColor(Color.blue);
		g2d.draw(catalanButton);
		g2d.draw(spanishButton);
		g2d.draw(englishButton);
		g2d.draw(backButton);
		

		//IMATGES
		left=ImageLoader.loadImage("/image/left.png");
		right=ImageLoader.loadImage("/image/right.png");
		space=ImageLoader.loadImage("/image/space.png");
		alien0=ImageLoader.loadImage("/image/alien.png");
		alien1=ImageLoader.loadImage("/image/Aliens31.png");
		alien2=ImageLoader.loadImage("/image/Aliens1.png");
		superalien = ImageLoader.loadImage("/image/SuperAlien.png");
		
		g.drawImage(left, Joc.AMPLE/11, 210, 60,25,null);
		g.drawImage(space, Joc.AMPLE/11, 260,60, 25,null);
		g.drawImage(right, Joc.AMPLE/11, 310, 60, 25,null);
		g.drawImage(alien0, Joc.AMPLE/11, 470, 50, 40,null);
		g.drawImage(alien1, Joc.AMPLE/11, 530, 50, 40,null);
		g.drawImage(alien2, Joc.AMPLE/11, 590, 50, 40,null);
		g.drawImage(superalien, Joc.AMPLE-400, 525, 90, 40,null);
		
		//TEXT
		Font fnt1= new Font("verdana",Font.BOLD,20);
		g.setFont(fnt1);
		g.setColor(Color.white);
		g.drawString("CATALAN", catalanButton.x+10, catalanButton.y+25);
		g.drawString("SPANISH", spanishButton.x+10, spanishButton.y+25);
		g.drawString("ENGLISH", englishButton.x+10, englishButton.y+25);
		g.drawString("BACK",backButton.x+20, backButton.y+25);
		
	}
}
