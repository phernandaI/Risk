import java.util.Scanner;

public class Recursiva {

	public static void main(String[] args) {
		int [] elements ={2,4,6,8,10,12,14,16,18};
		int num = 0;
		int num2 =0;
		Scanner lector=new Scanner (System.in); //DEFINIR EL ESCANER
		
		System.out.println("numero");
		num = lector.nextInt();
		
		Square(num,0);
		Fibonnaci(num);
		
		Modul(elements);
		
	}
	public static int Fibonnaci (int num, int num2){

	  if (num == 0)
	  {
		  return 0;
	  }
	  if(num == 1)
	  {
		  return 1;
	  }
	  return Fibonnaci(num-1)+Fibonnaci(num-2);
		
}
	public static void Square(int num){

				for(int i=1; i<num; i++)
				{
				System.out.println(i);
				if (num == 0)
				{
					System.out.println(num);
					
				}
		}	
	}
	public static void Modul(int []elements){
		int suma=0;
		for(int i=0; i < elements.length; i++)
		{
			if (i%4==0 && elements[i]>2)
			{
			suma =suma+elements[i];
			System.out.println(suma);
			}
		}
	}
	public static void Modul2(int []elements){
		int suma=0;
		for(int i=0; i < elements.length; i+=4)
		{
			if (elements[i]>2)
			{
			suma =suma+elements[i];
			System.out.println(suma);
			}
		}
	}
}
