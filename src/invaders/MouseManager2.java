package invaders;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager2 implements MouseListener{

	private boolean leftPressed;
	
	public MouseManager2() {
		
	}
	
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	@Override
	public void mouseClicked(MouseEvent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent a) {
		int mouseX=a.getX();
		int mouseY=a.getY();
		
		if(a.getButton()==MouseEvent.BUTTON1) {
			leftPressed=true;
			if(mouseY>=Joc.ALT-60 && mouseY<=Joc.ALT-20) {
				if(mouseX>=10 && mouseX<=130) {
				Joc.State=Joc.STATE.HELPCATALAN;
			}
				if(mouseX>=130 && mouseX<=250) {
				Joc.State=Joc.STATE.HELPSPANISH;
			}
				if(mouseX>=250 && mouseX<=370) {
				Joc.State=Joc.STATE.HELP;
			}
		}
			if(mouseY>=10 && mouseY<=50) {
				if(mouseX>=10 && mouseX<=110) {
				Joc.State=Joc.STATE.MENU;
			}
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent a) {
		if(a.getButton()==MouseEvent.BUTTON1) {
			leftPressed=false;
		}
	}

	
	
}
