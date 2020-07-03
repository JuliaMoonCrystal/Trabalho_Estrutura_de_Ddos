package Qualidade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class MetodosCrud {
	
	public LinkedList<dados> Create(LinkedList<dados> dados_lista) throws IOException {
	      //AQUI USAMOS VAMOS CALCULAR O DESEMPENHO DO METODO//	
			long tempo_Inicial = System.currentTimeMillis();
			long tempo_Final=0;
            
		  //ESSE INDICE VAI AJUDAR NA HORA DE DEMOSNTRAR O UPDATE NA LISTA// 
			int indice=0;
			
		  //AQUI CRIAMOS O ARQUIVO DESENPENHO.LOG PARA GUARDAR O TEMPO DE DESENPENHO// 	
			 String file_desempenho="Desempenho_Create.log4j";
			 BufferedWriter write = new BufferedWriter(new FileWriter( file_desempenho ));

			//Aqui tem a cria��o do arquivo //
			  File fileName = new File("Entrada.txt");
			  BufferedWriter writer = new BufferedWriter(new FileWriter( fileName, true ));
//			  if(fileName.exists()) {
//				  fileName.delete();
//			  }
			//aqui pergunta ao usauario quantos novos dados ele ira adicionar na lista//
			  int novo_elemento=Integer.parseInt(JOptionPane.showInputDialog("Quantos novos dados você quer adicionar na lista ?"));

			//aqui existe um la�o para o usuario digitar as variaveis//  
			 for(int i=0;i<novo_elemento;i++){
				 String nova_regiao=JOptionPane.showInputDialog("Digite uma Região de São Paulo :");
				 double novo_indice=Double.parseDouble(JOptionPane.showInputDialog("Digite o indice de poluição :"));
				 String nova_qualidade=JOptionPane.showInputDialog("Digite a qualidade do ar :");

				 dados_lista.add(new dados(nova_regiao,novo_indice,nova_qualidade));
			 }

			// ADICIONA ALGUNS ELEMENTOS NA LINKEDLIST PARA DEMOSTRA��O// 
//			 dados_lista.add(new dados("São Paulo",10,"N1-Boa"));
//			 dados_lista.add(new dados("Rio de Janeiro",30,"N1-Boa"));
//			 dados_lista.add(new dados("Baia",30,"N1-Boa"));
//			 dados_lista.add(new dados("Piaui",80,"N2-Moderada"));
//			 dados_lista.add(new dados("Rio Grande do Sul",60,"N2-Moderada"));
			 
	        //Grava OS DADO NO ARQUIVO//  
	        for(dados dado : dados_lista){
	        	  System.out.println("Aqui a lista : "+dado.getRegiao()+" com indice de: "+dado.getDados_Regiao()+" de poluição  Qualidade do ar: "+dado.getQualidade()+"\n");
	        	  writer.write("Região :"+indice+" "+ dado.getRegiao()+" possui um nivel de : "+dado.getDados_Regiao()+" de poluição  Qualidade do Ar : "+dado.getQualidade()+"\n");
	        	  indice++;
	        	  writer.newLine();	
	        }         
	        writer.close();

	      //AQUI ELE GRAVA O TEMPO QUE LEVOU PARA A GRAVA��O DO ARQUIVO TERMINAR// 
	        tempo_Final=System.currentTimeMillis()-tempo_Inicial;
	        write.write(" O metodo CREATE levou : "+tempo_Final+ " ms para ser executado");
	        write.close();

	        JOptionPane.showMessageDialog(null,"Lista Criada e populada com sucesso");
			return dados_lista;
		}

		public void Read(LinkedList<dados> dados_lista) throws IOException {

			 long tempo_Inicial = System.currentTimeMillis();
			 long tempo_Final=0;	

			 String file_desempenho="Desempenho_Read.log4j";
			 BufferedWriter write = new BufferedWriter(new FileWriter( file_desempenho ));
			
			 
		//AQUI PEGA O NOME DO ARQUIVO PARA PODER FAZER A LEITURA //	
			 File fileName =new File("Entrada.txt");
			 
			 BufferedReader ler = new BufferedReader(new FileReader( fileName ));
	         String line = ""; 

	   //AQUI VAI LER LINHA POR LINHA DO ARQUIVO E MOSTRAR NO CONSOLE//
	         System.out.println(" \n\n Aqui os dados que temos no arquivo :");
	         while (true) {
	             if (line != null) {
	                System.out.println(line);
	             } else
	                 break;
	             line = ler.readLine();
	           }
	         ler.close();
	          tempo_Final=System.currentTimeMillis()-tempo_Inicial;
	          write.newLine();
	          write.write(" O metodo Read leva :"+tempo_Final+" ms para ser executado");
	         
	      write.close();

		}

		public LinkedList<dados> Update(LinkedList<dados> dados_lista) throws IOException {
            
			 long tempo_Inicial = System.currentTimeMillis();
			 long tempo_Final=0;	

			 String file_desempenho="Desempenho_Update.log4j";
			 BufferedWriter write = new BufferedWriter(new FileWriter( file_desempenho ));
			
			//Aqui le o arquivo mostrando as op��es na tela para o usuario escolher//
			     File fileName =new File("Entrada.txt");
			     BufferedReader ler = new BufferedReader(new FileReader( fileName ));
			     
				 String line="";
				 String linha="";
				 
				 System.out.println("Escolha pela regi�o qual dado voc� quer alterar ?\n ");
				 while (true) {
		             if (line != null) {
		                System.out.println(line);
		             } else
		                 break;
		             line = ler.readLine();
		         }
		         ler.close();
		         
		        
		       //Aqui � onde realmente acontece o update da lista//  
		         int in=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número da região"));
		         String nova_regiao=JOptionPane.showInputDialog("Digite uma Região de São Paulo :");
				 double novo_indice=Double.parseDouble(JOptionPane.showInputDialog("Digite o indice de poluição :"));
				 String nova_qualidade=JOptionPane.showInputDialog("Digite a qualidade do ar :");
			     
			     dados_lista.set(in, new dados(nova_regiao,novo_indice,nova_qualidade) );
			     
			     BufferedWriter writer = new BufferedWriter(new FileWriter( fileName, false ));
//				  if(fileName.exists()) {
//					  fileName.delete();
//				  }

                for(dados dado : dados_lista){  
                System.out.println("Lista Atualizada : "+dado.getRegiao()+" , "+dado.getDados_Regiao()+" , "+dado.getQualidade());
                writer.write("Lista Atualizada :"+dado.getRegiao()+ " , "+dado.getDados_Regiao()+" , "+dado.getQualidade());
                writer.newLine();
                }
                writer.close();
                
                tempo_Final=System.currentTimeMillis()-tempo_Inicial;
  	            write.newLine();
  	            write.write(" O metodo Update leva :"+tempo_Final+" ms para ser executado");
  	         
  	            write.close();
                
			return dados_lista;
		}

		public void Delete(LinkedList<dados> dados_lista) throws IOException {
                 
			 long tempo_Inicial = System.currentTimeMillis();
			 long tempo_Final=0;	

			 String file_desempenho="Desempenho_Delete.log4j";
			 BufferedWriter write = new BufferedWriter(new FileWriter( file_desempenho ));
			
			//AQUI PEGAMOS O ARQUIVO E CRIAMOS UMA VARIAVEL STRING EM BRANCO //
			  String fileName = "Entrada.txt";
			  BufferedWriter writer = new BufferedWriter(new FileWriter( fileName ));
			  String line="";

		   //AQUI VAMOS PERCORRER CADA LINHA  DO ARQUIVO E ESCREVEMOS A LINHA EM BRANCO NO LUGAR DOS DADOS//
		   //ASSIM "APAGAMOS" OS REGISTROS//	  
			  for(dados dado : dados_lista){
	        	  writer.write(line);
	        	  writer.newLine();	
	        }         
	        writer.close();
	        dados_lista.clear();
	        
	            tempo_Final=System.currentTimeMillis()-tempo_Inicial;
	            write.newLine();
	            write.write(" O metodo Delete leva :"+tempo_Final+" ms para ser executado");
	         
	            write.close();
	            
	        JOptionPane.showMessageDialog(null,"Dados apagados com sucesso do arquivo ");
		}

		public void Pesquisa(LinkedList<dados> dados_lista) throws IOException {
			
   			 long tempo_Inicial = System.currentTimeMillis();
			 long tempo_Final=0;	

			 String file_desempenho="Desempenho_Pesquisa.log4j";
			 BufferedWriter write = new BufferedWriter(new FileWriter( file_desempenho ));
			
			
			String arq=JOptionPane.showInputDialog("Em qual arquivo você quer pesquisar ? \n- Entrada.txt \n-Bubblesort.txt \n -Selectonsort.txt");
            String nome_Regiao=JOptionPane.showInputDialog("Digite o nome da região que você quer pesquisar");
			
			BufferedReader reader = new BufferedReader (new FileReader(new File(arq)));
			String linha;
				while ((linha = reader .readLine()) != null) {
			              if(linha.contains(nome_Regiao)){
			            	  if(linha.contains(nome_Regiao)){   
			            	  JOptionPane.showMessageDialog(null, "Este dado está neste arquivo "+arq);
			              }
			           }
				  }
				 JOptionPane.showMessageDialog(null, "Este dado não está neste arquivo "+arq);
		    
				 tempo_Final=System.currentTimeMillis()-tempo_Inicial;
		            write.newLine();
		            write.write(" O metodo Pesquisa leva :"+tempo_Final+" ms para ser executado");
		            write.close();
		}
}
