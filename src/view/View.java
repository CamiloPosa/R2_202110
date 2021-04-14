package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos");
			System.out.println("2. Video con mas views por pais y categoria");
			System.out.println("3. Video con mas dias en trending por pais ");
			System.out.println("4. Video con mas likes por pais y tags");
			System.out.println("5. Exit");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo.toString());
		}
}
