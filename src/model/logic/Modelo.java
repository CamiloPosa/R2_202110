package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.data_structures.ArregloDinamico;
import model.data_structures.Cola;
import model.data_structures.IArregloDinamicoo;
import model.data_structures.LinkedList;
import model.data_structures.Nodo;
import model.data_structures.ShellSort;
import model.data_structures.TablaHashLinearProbing;




/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo 
{
	/**
	 * Atributos del modelo del mundo
	 */

	public final static String VIDEOS = "./data/videos-all.csv";
	public final static String CATEGORYS = "./data/category-id.csv";
	public final static int CATEGORIAS = 50; 
	public final static int PAISES = 150; 
	
	
	private TablaHashLinearProbing<String, ArregloDinamico<Video>> videoPorPais; 
	private TablaHashLinearProbing<Integer, String> categorias;
		

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{		
		videoPorPais = new TablaHashLinearProbing<>(PAISES);
		categorias = new TablaHashLinearProbing<>(CATEGORIAS); 
	}
		
	public void cargarVideosYCategorias() throws IOException
	{
			try 
			{
				
				BufferedReader reader1 = new BufferedReader(new FileReader(VIDEOS));
				String line=reader1.readLine();;
				line=reader1.readLine();
				int cont=0;
				boolean primero = false; 
				
				while(line!=null)
				{
					
					if(cont == 0)
						continue; 
							
					String[] datos = line.split(",");
					
					String  pId = datos[0].trim();
					String pTrendingDate = datos[1].trim();
					String pTitle = datos[2].trim(); 
					String pChanneltitle = datos[3].trim();
					
					int pCategory = 0;
					if(!datos[4].isEmpty())
					{
						 pCategory = Integer.parseInt(datos[4].trim());
					}
					
					String pPublishTime = datos[5].trim();
					String pTags = datos[6].trim();
					
					int pViews = 0;
					if(!datos[7].isEmpty())
					{
						 pViews = Integer.parseInt(datos[7].trim());
					}
					int pLikes = 0;
					if(!datos[8].isEmpty())
					{
						 pLikes = Integer.parseInt(datos[8].trim());
					}
					int pDislikes = 0;
					if(!datos[9].isEmpty())
					{
						 pDislikes = Integer.parseInt(datos[9].trim());
					}
					
					String pCommentCount = datos[10].trim();
					String pThumnail = datos[11].trim();
					String pCommentDisable = datos[12].trim();
					String pRatingsDisable = datos[13].trim();
					String pError = datos[14].trim();
					String pDescription = datos[15].trim();
					String pCountry = datos[16].trim();
			
					
					Video item = new Video(pId, pTrendingDate, pChanneltitle, pCategory, pPublishTime, pTags, pViews, pLikes, pDislikes, pCountry); 
					
					
					
					if(videoPorPais.contains(pCountry)) {
						ArregloDinamico<Video> lista = videoPorPais.get(pCountry);
						lista.addFirst(item);
						videoPorPais.put(pCountry, lista);
					}
					else {
						ArregloDinamico<Video> nuevaLista = new ArregloDinamico<Video>(200); 
						nuevaLista.addFirst(item);
						videoPorPais.put(pCountry, nuevaLista);
					}
					
					if (primero = false) {
						primero = true; 
						System.out.println("Primer video: " + "\n");
						System.out.println("Titulo: " + pTitle + "\n" +"Titulo del canal: " +pChanneltitle + "\n" +"Fecha trending: "+ pTrendingDate + "\n" + "Pais: "+pCountry + "\n" +"Visitas: " +pViews + "\n" + "Likes: "+pLikes + "\n" +"Dislikes: " +pDislikes);
					}
					
					line = reader1.readLine();
					cont ++;
					
				}
				
				reader1.close();
				System.out.println("Número total de videos cargados: " + cont );
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}	
			
			try 
			{
				
				BufferedReader reader2 = new BufferedReader(new FileReader(CATEGORYS));
				String line2 = reader2.readLine();;
				line2 = reader2.readLine();
				int cont=0;
				boolean primero = false; 
				
				while(line2!=null)
				{		
					if(cont == 0)
						continue; 
					
					String[] datos = line2.split(",");
					line2 = reader2.readLine();
					
					int pNumero = 0;
					if(!datos[0].isEmpty())
					{
						 pNumero = Integer.parseInt(datos[0].trim());
					}
					
					String pCategoria = datos[1].trim();
					
					categorias.put(pNumero, pCategoria);
					
					
					
				}
				
				Cola<Integer> ids = categorias.keySet();
				System.out.println("Categorias: " );
				while(ids.darTamano() != 0) {
					int id = ids.dequeue();
					String categoria = categorias.get(id); 
					System.out.println("\n" + id + " --> " + categoria);
					
				}
				
				reader2.close();
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}	
		}
			
			
      public void videoMasViewsPorPaisYCategoria(int Category, String Country, int Num) {
		String cat = categorias.get(Category); 
    	  System.out.println("Los " + Num + " video con mas views en "+ Country + " con la categoria "+ cat + "son: " );
    	  
	  ArregloDinamico<Video> lista = videoPorPais.get(Country);
	  sortViews(lista);
	  int cantidad = lista.size()-1; 
	  int count = 0;
	  int n = Num; 
	  while(n != 0 && lista.isEmpty() != true) {
		 String auxCat = categorias.get(lista.getElement(cantidad).darCategory()); 
		  if(auxCat.equals(cat)) {
			  count++; 
			  
			  System.out.println("\n" + count + ". Trending Date: " + lista.getElement(cantidad).darDate() + " Channel: " + lista.getElement(cantidad).darTitle()+ " Publish: " + lista.getElement(cantidad).darPublishTime() + " Views: " + lista.getElement(cantidad).darViews() + " Likes: " + lista.getElement(cantidad).darLikes()+ " Dislikes: " + lista.getElement(cantidad).darDislikes() + "\n");
			  n--; 
			  cantidad--;
		  }
			  
	  }
		 
	  }
      
      
      public void masDiasTrendingPais(String pais) {
    	  ArregloDinamico<Video> lista = videoPorPais.get(pais);
    	  sortNames(lista);
    	  int cantidad = lista.size();
    	  int contador = 0; 
    	  int i = 0;
    	  int j = 1;
    	  int mas = 0; 
    	  Video vmas = null; 
    	  while(contador < cantidad) {
    		  if (lista.getElement(i).darId().equals(lista.getElement(i+1))) {
    			  j++; 
    			  i++; 
    		  }
    		  else {
    			  if (j>mas) {
    				  mas = j; 
    				  vmas = lista.getElement(i); 
    			  }
    			  i++; 
    			  j = 1; 
    		  }
    			  
    	  }
    	  
    	  System.out.println("El video con mas dias de trending en el pais "+ pais + " es: " + vmas.darTitle() + " - " + vmas.darCountry() + " - " + mas  );

      }
      
      
      
      public void videosMasLikes(String pais, String tag, int Num) {
    	  ArregloDinamico<Video> lista = videoPorPais.get(pais);
    	
    	  ArregloDinamico<Video> conTags = new ArregloDinamico<Video>(lista.size()); 
    	  
    	  for (int i = 0; i < lista.size(); i++) {
			String[] tags = lista.getElement(i).darTags().split("\\|"); 
			ArregloDinamico<String> tagsArreglo = new ArregloDinamico<String>(30);
			for (int j = 0; j < tags.length; j++) {
				 tagsArreglo.addFirst(tags[j]);
			}
			
			 for (int j = 0; j < tagsArreglo.size(); j++) {
				if (tag.equalsIgnoreCase(tagsArreglo.getElement(j))) {
					conTags.addFirst(lista.getElement(i)) ; 
				}
			}
				
				
			}
			
		
    	  
    	  System.out.println("Los " + Num + " video con mas likes en "+ pais + " con el tag "+ tag + "son: " );
    	  sortLikes(conTags);
    	  int cantidad = conTags.size()-1; 
    	  int count = 0;
    	  int n = Num; 
    	  while(n != 0 && lista.isEmpty() != true && cantidad >= 0) {
    			  count++; 
    			  
    			  System.out.println("\n" + count + ". Titulo: " + conTags.getElement(cantidad).darTitle() + " Channel: " + conTags.getElement(cantidad).darTitle()+ " Publish: " + conTags.getElement(cantidad).darPublishTime() + " Views: " + conTags.getElement(cantidad).darViews() + " Likes: " + conTags.getElement(cantidad).darLikes()+ " Dislikes: " + conTags.getElement(cantidad).darDislikes() + " Tags: " + conTags.getElement(cantidad).darTags() +"\n");
    			  n--; 
    			  cantidad--;
    		  
    			  
    	  }
    	  
      }
	 
      public void sortViews(ArregloDinamico<Video> comida) {
		    int n = comida.size();

		    for (int gap = n / 2; gap > 0; gap /= 2) {
		        for (int i = gap; i < n; i++) {
		            int key = comida.getElement(i).darViews();
		            Video vkey = comida.getElement(i);
		            int j = i;
		            while (j >= gap && comida.getElement(j - gap).darViews() > key) {
		                comida.exchange(j, j-gap); 
		                j -= gap;
		            }
		            comida.changeInfo(j, vkey); 
		        }
		    }
      }

		    public void sortNames(ArregloDinamico<Video> comida) {
			    int n = comida.size();

			    for (int gap = n / 2; gap > 0; gap /= 2) {
			        for (int i = gap; i < n; i++) {
			            String key = comida.getElement(i).darId();
			            Video vkey = comida.getElement(i);
			            int j = i;
			            while (j >= gap && comida.getElement(j - gap).darId().compareTo(key) == 1) {
			                comida.exchange(j, j-gap); 
			                j -= gap;
			            }
			            comida.changeInfo(j, vkey); 
			        }
			    }
		    }

			    public void sortLikes(ArregloDinamico<Video> comida) {
				    int n = comida.size();

				    for (int gap = n / 2; gap > 0; gap /= 2) {
				        for (int i = gap; i < n; i++) {
				            int key = comida.getElement(i).darLikes();
				            Video vkey = comida.getElement(i);
				            int j = i;
				            while (j >= gap && comida.getElement(j - gap).darLikes() > key) {
				                comida.exchange(j, j-gap); 
				                j -= gap;
				            }
				            comida.changeInfo(j, vkey); 
				        }
				    }
		      }
	
			
			
		
		
		
}
	




	



