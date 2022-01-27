package invaders;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener{

	private boolean leftPressed;
	MusicPlayer oki,winer;
	
	public MouseManager() {
		oki = new MusicPlayer("/sound/oki.wav");
		winer = new MusicPlayer("/sound/win.wav");
	}
	
	public boolean isLeftPressed() {
		return leftPressed;
	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		
		int mouseX=e.getX();
		int mouseY=e.getY();
		
		if(e.getButton()==MouseEvent.BUTTON1) {
			leftPressed=true;
		if(mouseX>=Joc.AMPLE/2-100&&mouseX<=Joc.AMPLE/2-100+200) {
			if(mouseY>=200&&mouseY<=200+70) {
				oki.play();
				Joc.State=Joc.STATE.USER;
				
				
			}
			if(mouseY>=270+20&&mouseY<=270+20+70) {
				oki.play();
				Joc.State=Joc.STATE.HELP;
			}
			if(mouseY>=360+40&&mouseY<=360+40+70) {
				winer.play();
				Joc.State=Joc.STATE.CLASSIFICATION;
			}
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			leftPressed=false;
		}
	}
}
