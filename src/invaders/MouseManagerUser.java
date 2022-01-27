package invaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManagerUser implements MouseListener, KeyListener{

	TextField t1 = new TextField(20);
	protected Joc joc;
	MusicPlayer oki;

	public MouseManagerUser() {
		oki = new MusicPlayer("/sound/oki.wav");
	}
	
	public void render(Graphics g, Joc joc){
		this.joc=joc;
		g.setColor(Color.black);
		Joc.finestra.getFrame().add(t1);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}


	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int mouseX=e.getX();
		int mouseY=e.getY();
		
		if(e.getButton()==MouseEvent.BUTTON1) {
		if(mouseX>=Joc.AMPLE/2-100&&mouseX<=Joc.AMPLE/2-100+200) {
			if(mouseY>=200&&mouseY<=200+70) {
				oki.play();
				Joc.State=Joc.STATE.GAME;
			}
			if(mouseY>=270+20&&mouseY<=270+20+70) {
				oki.play();
				Joc.State=Joc.STATE.MENU;
			}
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	
	}	
	
}
