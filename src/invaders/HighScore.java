package invaders;

import java.util.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
//import java.util.Map;

//NOTA: aquesta funcio actualitza el User.txt: comen�a guardant el ranking inicial
// i lactualitza si al acabar la partida millores a algu del TOP 5
// reescriu el fitxer User.txt amb el nou ranking actualitzat


public class HighScore extends HashMap<String,Integer>{

	private static final long serialVersionUID = 1L;
	private BufferedReader buf;
	
	private DataOutputStream dos;
	
	LinkedHashMap<String,Integer> ordenat = new LinkedHashMap<>();

	void entraNouUsuari(String Paraula, String punts){
		int punt = Integer.parseInt(punts);
		this.put(Paraula, punt);
	}
	
	void milloraPunts(String nom, Integer punts) {
		if(this.get(nom)<punts) {
			this.put(nom,punts);
		}
	}

	public boolean jugadorConegut(String paraula) {
		return this.containsKey(paraula);	
	}
	
	public ArrayList<String> usuarisGuardats(){
		return new ArrayList<String>(this.keySet());
	}
	
	public ArrayList<Integer> puntsGuardats(){
		ArrayList<Integer> punts = new ArrayList<Integer>();
		ArrayList<String> noms = usuarisGuardats();
		for(int i=0;i<this.keySet().size();i++) {
			punts.add(this.get(noms.get(i)));
		}
		return punts;
	}
	
	public void actualitzaFitxer(String jugador, Integer score) throws IOException {
		if(jugadorConegut(jugador)) {
			milloraPunts(jugador,score);
		}
		else {
			entraNouUsuari(jugador,score.toString());
		}
			
			//ORDENEM LA LLISTA
			
			List<String> mapKeys = usuarisGuardats();
		    List<Integer> mapValues = puntsGuardats();
		    Collections.sort(mapValues);
		    Collections.sort(mapKeys);
		    Iterator<Integer> valueIt = mapValues.iterator();
		    while (valueIt.hasNext()) {
		        Integer val = valueIt.next();
		        Iterator<String> keyIt = mapKeys.iterator();

		        while (keyIt.hasNext()) {
		            String key = keyIt.next();
		            Integer comp1 = this.get(key);
		            Integer comp2 = val;

		            if (comp1.equals(comp2)) {
		                keyIt.remove();
		                ordenat.put(key, comp1);
		                break;
		            }
		        }
		    }
		    //ELIMINEM ELS QUE SOBREN PQ TINGUI LONGITUD 5
		    
		    ArrayList<String> usuaris = new ArrayList<String>(ordenat.keySet());
		    int i=0;
		    while(ordenat.size()>5) {
		    	ordenat.remove(usuaris.get(i));
		    	i += 1;
		    }
		    
		    //printMap(ordenat);
		    
		    FileOutputStream copia = new FileOutputStream("User.txt");
			dos = new DataOutputStream(copia);
			
			ordenat.forEach((key,value) -> {
				try {
					dos.writeBytes(key + "   " + value + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});    
		    
	}
	
	/*private static void printMap(Map<String, Integer> sortedMap)
    {
        sortedMap.forEach((key, value) -> System.out.println(" " + key + " " + value));
    }*/
	
	
	HighScore() throws IOException{ //quan iniciem el joc tenim el ranking anterior
		FileReader read = new FileReader("User.txt");
		buf = new BufferedReader(read);
		String s;
		int i=1;
		while(i<6) {
			s = buf.readLine();
			String[] tokens = s.split("   ");
			entraNouUsuari(tokens[0],tokens[1]);
			i += 1;
	  	}
	}
	
	
}
