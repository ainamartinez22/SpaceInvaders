package invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class User implements KeyListener{

	public Rectangle playButton = new Rectangle(Joc.AMPLE/2-100,200,200,70);
	public Rectangle backButton = new Rectangle(Joc.AMPLE/2-100,270+30,200,70);
	public static String nom = " ";
	int count = 0;
	
	public void render(Graphics g) throws InterruptedException{
		
		Graphics2D g2d= (Graphics2D) g;
		Font fnt0= new Font("verdana",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SPACE INVADERS", Joc.AMPLE/5, 100);
		Font fnt1= new Font("verdana",Font.BOLD,25);
		g.setFont(fnt1);
		
		
		//RECTANGLES3
		Joc.finestra.getFrame().setVisible(true);
		Joc.finestra.getFrame().addKeyListener(this);
		g2d.setColor(Color.black);
		g2d.fill(playButton);
		g2d.fill(backButton);
		
		g2d.setColor(Color.blue);
		g2d.draw(playButton);
		g2d.draw(backButton);
		

		//TEXT
		g.setColor(Color.white);
		g.drawString("PLAY", playButton.x+playButton.width/3, playButton.y+40);
		g.drawString("BACK", backButton.x+backButton.width/3, backButton.y+40);
		g.setFont(fnt0);
		g.drawString(nom, 325, Joc.ALT-200);
	}

	public void keyPressed(KeyEvent e) {
	}


	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		if(count <10 && key !=   nom.charAt(nom.length() - 1)) {
			nom += key;
		}
	}
	
	
}
