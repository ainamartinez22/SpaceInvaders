package invaders;

import java.io.File;
import java.util.Scanner;


public class Reader {

	public String[][] llista = new String[5][3];
    private Scanner x;
    int linies;
    
    public void openFile() {
    	try {
    		x = new Scanner(new File("User.txt"));
    	}
    	catch(Exception e) {
    		System.out.println("No troba el fitxer");
    	}
    }
    
    public void readFile() {
    	linies=0;
    	while(x.hasNext()) {  //loop fins el final del fitxer
    		linies=linies+1;
    		String a = x.next();
    		String b = x.next();
    		String c = x.next();
			llista[linies][0]=a;
			llista[linies][1]=b;
			llista[linies][2]=c;
    		//System.out.printf("%s %s %s\n", a,b,c);
    	}
    }

    public void closeFile() {
    	x.close();
    }
}
