
class Invert {

	public static void main(String[] args) {
		int[] elements = {1,3,5,12,33,1,2,4,7,18,22,31,11,7};
		// El programa ha d'escriure per pantalla
		// {7,11,31,22,18,7,4,2,1,33,12,5,3,1}
		
		invert(elements);  //SIN RECURSIVA 
		//invertRec(elements);
		
	}

	private static void invert(int[] elements) {
		int[] salida  = new int[elements.length]; // CREADO OTRO ARRAYS PARA GUARDAR LOS VALORES
	      
		System.out.println("Array de entrada:");
		for(int i = 0; i < elements.length; i++){ // HACE PASADA POR EL ARRAYS
	           
			System.out.println(elements[i]); 
	           
	           salida[elements.length-i-1] = elements[i]; //  GUARDA AL REVES LA POSICION DEL ARRAYS EN EL NUEVO ARRAYS 
	       }
	       System.out.println("Array de salida:");
	       
	       for(int i = 0; i < salida.length; i++){   // PINTA LA SALIDA DEL NUEVO ARRAYS CON LAS POSISCIONES CAMBIADAS
	           System.out.println(salida[i]);
	       }
		
		
	   }  
	
	private static void invertRec(int[] elements) {//AQUI QUERIA HACER LA RECURSIVA PERO NO HE LOGRADO
		
		//AQUI QUERIA HACER LA RECURSIVA PERO NO HE LOGRADO
		
 		int[] salida  = new int[elements.length]; // CREADO OTRO ARRAYS PARA GUARDAR LOS VALORES
	      
		System.out.println("Array de entrada:");
		for(int i = 0; i < elements.length; i++){ // HACE PASADA POR EL ARRAYS
	           
			System.out.println(elements[i]); 
	           salida[elements.length-i-1] = elements[i]; //  GUARDA AL REVES LA POSICION DEL ARRAYS EN EL NUEVO ARRAYS 
 		}
		
		System.out.println("Array de salida:");
		
        for(int j = 0; j < salida.length; j++){   // PINTA LA SALIDA DEL NUEVO ARRAYS CON LAS POSISCIONES CAMBIADAS
	           System.out.println(salida[j]);
	       }
	       
	if (elements.length!=elements.length-1){
		invertRec(elements);
	}
		
    }
		
	      
	   }     
