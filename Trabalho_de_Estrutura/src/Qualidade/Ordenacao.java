package Qualidade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

public class Ordenacao {

	public void Ordena_Quick(LinkedList<dados> dados_lista)  {

	
	
	
	}

	public void Ordena_Bubble(LinkedList<dados> dados_lista) throws IOException {
		String fileName = "Bubblesort.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter( fileName ));

		class Bubblesort implements Comparator<dados> {

			public int compare(dados o1, dados o2) {
				dados s1=(dados)o1;
				dados s2=(dados)o2;
				if(s1.dados_Regiao==s2.dados_Regiao)
					return 0;
				else if(s1.dados_Regiao>s2.dados_Regiao)
					return 1;
				else return -1;
			}
		}
        
		writer.write("***ORDENADO DA REGIÃO COM O MENOR PARA O MAIOR INDICE DE POLUIÇÃO***\n\n");
		for(dados dado : dados_lista) {
			Collections.sort(dados_lista, new Bubblesort());
			System.out.println(" \n Aqui a lista ordenada: "+dado.getRegiao()+" com indice de: "+dado.getDados_Regiao()+" de poluição  Qualidade do ar: "+dado.getQualidade()+"\n");
			writer.write("Região : "+ dado.getRegiao()+" possui um nivel de : "+dado.getDados_Regiao()+" de poluição  Qualidade do Ar : "+dado.getQualidade()+"\n");
			writer.newLine();
		}
		writer.close();		
	   }	
	}


