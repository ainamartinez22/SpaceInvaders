package invaders;
import java.awt. *;
import javax.swing.JFrame;

public class Finestra{

	private JFrame frame; //encara no linicialitzem
	private String title;
	private int AMPLE, ALT;
	private Canvas canvas;

	public Finestra(String title, int AMPLE, int ALT) {
		this.title=title;
		this.ALT=ALT;
		this.AMPLE=AMPLE; //this. pq les variables i els param es diuen igual
		creaFinestra();
	}
	
	private void creaFinestra() {
		frame=new JFrame(title);
		frame.setSize(AMPLE,ALT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//pq el joc es pari al tancar la finestra
		frame.setResizable(false);//no volem reajust de la finestra
		frame.setLocationRelativeTo(null); //la finestra emergerà al centre
		frame.setVisible(true); //de forma natural el JFrame no apareix visible
		
		canvas= new Canvas();
		canvas.setPreferredSize(new Dimension(AMPLE,ALT));
		canvas.setMaximumSize(new Dimension(AMPLE,ALT));
		canvas.setMinimumSize(new Dimension(AMPLE,ALT)); //per estar segurs que mai no variaria
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack(); //pq es vegi be
	}
	
	public Canvas getCanvas(){ //per poder dibuixar a la pantalla
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
