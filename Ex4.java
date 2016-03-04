
public class Ex4 {

	public static void main(String[] args) {

		int[] vector1 = {1,3,4,5,7,5,3,0};

		int[] vector2 = {1,7,4,3,5,3,0};

		merge(vector1, vector2);

		// Escriu la sortida per pantalla, amb el format de l'exercici 3
		// {0,0,1,1,3,3,3,3,4,4,5,5,5,7,7} <-- Exemple de sortida 		

	}

	public static int[] merge(int[] vector1, int[] vector2) {

		int[] merged = new int[vector1.length + vector2.length];
		
		for (int i = 0; i < vector1.length; i++){ //pasa por vector 1
			merged [i] = vector1[i];  // guarda el valor de vector 1 en vector merged
			System.out.println(merged[i]);   //PINTA POR PANTALLA VECTOR 1
		}
		for (int i = 0; i < vector2.length; i++){ // pasa por vector 2 
			merged [i] = vector2[i]; // guarda valor de vector 2 en merged y añade el valor de vector 1
			System.out.println(merged[i]); // PINTA POR PANTALLA VECTOR 2
		
		}
		return merged;

	}

}
