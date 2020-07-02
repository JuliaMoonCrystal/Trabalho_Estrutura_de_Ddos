package Qualidade;

import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Principal {
	 public static void main(String [] args) throws IOException{
		  //Nesta Classe vai apresentar todas as opções que o usuario pode escolher//
		  int opc=0;
		  LinkedList<dados> dados_lista= new LinkedList<>();
          
		  LinkedList<Integer> vetor= new LinkedList<>();
		  do{
			  opc = Integer.parseInt(JOptionPane.showInputDialog("-----------Dados_da_qualidade_do_ar----------- \n1 -Create Dados- "
			  		+ "\n2 -Read- \n3 -Update- \n4 -Delete- \n5 -Ordena por SelectonSort-  \n6 -Ordena por BubbleSort- \n7 Pesquisa na lista"
			  		+ " \n8 -Hash "
			  		+"\n9 -Finalizar consulta"));
	           MetodosCrud metodos =new MetodosCrud();
	           Ordenacao ordena=new Ordenacao();
	           Hash_regioes hr= new Hash_regioes();
	            switch (opc)
	            {
	                  case 1: dados_lista =metodos.Create(dados_lista);
	                             break;
	                  case 2: metodos.Read(dados_lista);
	                             break;
	                  case 3: dados_lista=metodos.Update(dados_lista);
	                             break;
	                  case 4: metodos.Delete(dados_lista);
	                             break;
	                  case 5: ordena.Ordena_Selection(vetor);
	                             break;
	                  case 6: ordena.Ordena_Bubble(dados_lista);
	                             break;
	                  case 7: metodos.Pesquisa(dados_lista);
	                             break;
	                  case 8: hr.InsereRegioes(dados_lista);
	                             break;            

	                  case 9: JOptionPane.showMessageDialog(null,"-----FIM-----");
	                             break;             
	                  default: JOptionPane.showMessageDialog(null,"opc inválida");
	            }
	        }
	      while(opc != 9);
	     }
}
