package invaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys; //true=apretat, false=no apretat
	public boolean left, right, space; //seran true si estem apretant els botons
	
	public KeyManager(){
		keys = new boolean[256]; //pq 256?
	}
	
	public void tick() {
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
	}

	public void keyPressed(KeyEvent e) { //funcio cridada al apretar un botó del teclat
		keys[e.getKeyCode()]=true;  //a lindex id del botó apretat del teclat posem true
	}

	public void keyReleased(KeyEvent e) {//funcio cridada al deixar dapretar un botó del teclat
		keys[e.getKeyCode()]=false; 
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

}