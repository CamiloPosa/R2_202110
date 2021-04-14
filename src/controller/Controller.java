package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
        String dato2 = "";

		while( !fin )
		{
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1: 
				view.printMessage("\nCarga de datos\n --------");
				try {
					modelo.cargarVideosYCategorias();
				} catch (Exception e) {
					view.printMessage("\n Error en la carga de datos: ");
					e.printStackTrace();
				}

				break;
				
			case 2: 
				view.printMessage("Ingrese el pais");
				String pais = lector.next();
				view.printMessage("Ingrese la categoria");
				String categoria = lector.next();
				int categoriaint = Integer.parseInt(categoria); 
				view.printMessage("Ingrese la cantidad de videos");
				String cant = lector.next();
				int cantidad = Integer.parseInt(cant); 
				
				try {
					
					modelo.videoMasViewsPorPaisYCategoria(categoriaint, pais, cantidad);
				} catch (Exception e) {
					// TODO: handle exception
				}
			case 3: 
				view.printMessage("Ingrese el pais");
				String pais1 = lector.next();
				
				
				try {
					
					modelo.masDiasTrendingPais(pais1);
				} catch (Exception e) {
					// TODO: handle exception
				}
			case 4: 
				view.printMessage("Ingrese el pais");
				String pais2 = lector.next();
				view.printMessage("Ingrese el tag");
				String tag = lector.next();
				view.printMessage("Ingrese la cantidad de videos");
				String cant1 = lector.next();
				int cantidad1 = Integer.parseInt(cant1); 
				
				
				try {
					
					modelo.videosMasLikes(pais2, tag, cantidad1 );
				} catch (Exception e) {
					// TODO: handle exception
				}
			
				
			case 5:
				view.printMessage("-----Hasta pronto-----");
				lector.close();
				fin= true;
				System.exit(0);
				break;

			}	
		}
	}
}
