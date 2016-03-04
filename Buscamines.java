/**
 * Aquest codi implementa una versió reduïda i per consola del joc del BuscaMines.
 * @author Professor de DAMM3 
 *
 */

public class Buscamines {
	/**
	 *  Constant nivell ens marca el nombre de files i columnes que té el tauler.
	 */
	public static final int nivell=4;
	/**
	 *  Constant maxMines el nombre de mines que té el tauler 
	 */	
	public static final int maxMines=4;
	
	public static void main(String[] args) {
		/**
		 * tauler matriu que cada casella conté:
		 * 			- un 0 si no hi ha mina 
		 * 			- un 1 si hi ha mina
		 */
		int[][] tauler = new int[nivell][nivell];
		
		/**
		 * taulerJugador matriu que guarda l'estat del joc, on cada casella:
		 * 			- val -1 si el jugador no ha descobert la casella 
		 * 			- un número quan el jugador descobreix la casella i indica el nombre de mines veïnes
		 */
		int[][] taulerJugador = new int[nivell][nivell];

		
	    inicialitzarJoc(tauler,taulerJugador);
		
		//Juguem
		int fila=0;
		int col=0;
		do{
			//Demanar casella al jugador
			System.out.println("A quina casella vols jugar?");
			fila=demanarCoordenada(0);
			col=demanarCoordenada(1);
			
			//Control si el jugador ha tocat mina o no.
			if (tauler[fila][col]==1){
				System.out.println("Ooooh!!! Has perdut en aquesta casella hi ha un mina!! BUM! BUM!");
			}
			else{
				//Si no toca mina, es calculen les mines veïnes que té la casella
				//TODO Aquí heu d'assignar el resultat de la funció que calcula les mines veïnes de la casella entrada pel jugador (fila,col) 
				
				
				taulerJugador[fila][col]= MinesVeines(tauler, taulerJugador);//TODO Crida a la funció que feu de calcular les veines;
				//Es mostra el tauler amb la informació de caselles descobertes.
				pintarTauler(taulerJugador);
			}
		}while(tauler[fila][col]==0 && !acabada(taulerJugador));
		
		//Si el jugador surt del bucle per acabar partida, se'l felicita.
		if (acabada(taulerJugador)){
			System.out.println("Felicitaaaaats!!!! Has trobat totes les mines!");
		}
	}
	
	/**
	 * En aquesta funció es generen aleatoriàment les mines per al tauler i s'inicialitza el taulerJugador 
	 * posant totes les caselles a -1 per indicar que encara no s'ha descobert cap casella.
	 * 
	 * @param tauler tauler amb les mines
	 * @param taulerJugador tauler amb les caselles descobertes pel jugador.
	 */
	public static void inicialitzarJoc(int[][] tauler, int[][] taulerJugador){
		//Generem les minesde manera aleatoria
		for(int mina=0;mina<maxMines;mina++){
			int filaMina, columnaMina;
			do{
				filaMina=(int) (Math.random()*nivell);
				columnaMina=(int) (Math.random()*nivell);
			}while(tauler[filaMina][columnaMina]==1);	
			tauler[filaMina][columnaMina]=1;
		}
		
		//Inicialitzem el taulerJugador a -1 per indicar que el jugador encara no ha tirat
		for(int fila=0;fila<nivell;fila++){
			for(int col=0;col<nivell;col++){
				taulerJugador[fila][col]=-1; 
			}
		}
	}
	
	
	/**
	 * Serveix per demanar la fila o la columna i es retorna el valor entrat per l'usuari. 
	 * Es controla que el valor entrdat per l'usuari sigui correcta.
	 * 
	 * @param tipus si val 0 es demana fila i 1 la columna. Només per mostrar un o altre imatge.
	 * @return enter retorna el valor entrat per l'usuari. 
	 */
	public static int demanarCoordenada(int tipus){
		boolean ok=true;
		String missatge=(tipus==0?"Digues la fila":"Digues la columna");
		int valor=0;
		do{
		  ok=true;
		  java.util.Scanner lector = new java.util.Scanner(System.in);
	      System.out.println(missatge);
	      if (lector.hasNextInt()){
	    	  valor=lector.nextInt();
	    	  if(valor<0 || valor>= nivell){
	    		  ok=false;
	    	  } 
	      }
	      else{
	    	  ok=false;
	      }
	      if(!ok){
	    	  System.out.println("Has d'introduir una xifra entre 0 i "+(nivell-1));
	      }
		} while(!ok);
		
		return valor;
	}
	
	
	/**
	 * Pinta el tauler per pantalla. En el cas de què una casella no s'hagi descobert es mostra un ?
	 * 
	 * @param tauler
	 */
	public static int pintarTauler(int[][] tauler){
		for(int fila=0;fila<nivell;fila++){
			for(int col=0;col<nivell;col++){
				//Si no s'ha descobert la casella es mostra un ? si no mostra el valor de mines que hi ha al tauler 
				String valor=(tauler[fila][col]==-1?"?":""+tauler[fila][col])+" ";
				System.out.print(valor);
			}
			System.out.println();
			
		}
		return 0;
	}
	
	/**
	 * Aquesta funció comprova si hi ha alguna casella amb valor -1. En cas de trobar-ne una indica que el joc no ha acabat.
	 * 
	 * @param tauler
	 * @return boolea, true si la partida s'ha acabat o false en cas contrari.
	 */
	public static boolean acabada(int[][] tauler){
		for(int fila=0;fila<nivell;fila++){
			for(int col=0;col<nivell;col++){
				if (tauler[fila][col]==-1) 
					return false;
			}
		}
		return true;
	}
	
	//TODO Realitzeu aquí la funció de minesVeines
	public static int  MinesVeines(int [][] tauler, int [][] taulerJugador){
	
		for (int fila =0; fila < tauler.length; fila++){ // PASA POR LAS FILAS DEL TABLERO
		
		for (int col =0; col < tauler[fila].length; col++){ // PASA POR LAS COLUMNAS FILA A FILA DE TABLERO
			
			// CONDICION -> SI EN LA POSICION HAY UNO HAY MINA SINO NO HAY MINA
			// Y SI LA POSICION EN LA QUE EL JUGADOR ESTA 
			if (tauler[fila][col]==1 && taulerJugador [fila][col] == tauler [fila][col]){ 
				
				System.out.println("Hi ha mina");
			}
		}
		System.out.println("No hi ha mina");
	  }
		return 0;
	}
	
	
}