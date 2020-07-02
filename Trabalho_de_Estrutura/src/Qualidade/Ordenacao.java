package Qualidade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

public class Ordenacao {

	public void Ordena_Selection(LinkedList<Integer> vetor) throws IOException  {
	
		 vetor.add(10);
		 vetor.add(30);
	     vetor.add(30);
	     vetor.add(80);
	     vetor.add(60);
	     
	        String fileName = "Selectonsort.txt";
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			// o m�todo size() retorna o tamanho de uma lista
			// (� o equivale ao length do array)
			for (int i = 0; i < vetor.size(); i++) {
				int posicaoMenor = i;
				for (int j = (i + 1); j < vetor.size(); j++) {
					//o m�todo get() acessa o valor em uma determinada posi��o da lista
					//� o equivalente ao vetor[j] do array
					if (vetor.get(j) < vetor.get(posicaoMenor)) {
						posicaoMenor = j;
					}
				}
				if (vetor.get(i) != vetor.get(posicaoMenor)) {
					int temp = vetor.get(i);
					//o m�todo set() substitui um valor por outro em
					//uma determinada posi��o da lista
					//o primeiro par�metro � onde eu quero mudar,
					//o segundo � o que eu quero colocar no lugar
					vetor.set(i, vetor.get(posicaoMenor));
					vetor.set(posicaoMenor, temp);
				}

			}
			for (int i = 0; i < vetor.size(); i++) {
				System.out.println(vetor.get(i));
				writer.write(String.valueOf(vetor));
				writer.newLine();
			}

			writer.close();
	
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
        
		writer.write("***ORDENADO DA REGI�O COM O MENOR PARA O MAIOR INDICE DE POLUI��O***\n\n");
		for(dados dado : dados_lista) {
			Collections.sort(dados_lista, new Bubblesort());
			System.out.println(" \n Aqui a lista ordenada: "+dado.getRegiao()+" com indice de: "+dado.getDados_Regiao()+" de polui��o  Qualidade do ar: "+dado.getQualidade()+"\n");
			writer.write("Regi�o : "+ dado.getRegiao()+" possui um nivel de : "+dado.getDados_Regiao()+" de polui��o  Qualidade do Ar : "+dado.getQualidade()+"\n");
			writer.newLine();
		}
		writer.close();		
	   }

	}


