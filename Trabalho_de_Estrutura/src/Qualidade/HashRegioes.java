package Qualidade;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class HashRegioes {

	public void insereRegioes(LinkedList<dados> dados_lista) throws IOException {

		File fileName = new File("cidades.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter( fileName ));
		if(fileName.exists()) {
			fileName.delete();
		}

		int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantos novos dados voc� quer adicionar na lista ?"));
		for(int i=0; i < quant; i++) {
			String nova_regiao=JOptionPane.showInputDialog("Digite uma Regi�o de S�o Paulo :");
			dados_lista.add(new dados(nova_regiao, i+1,null));
		}

		long tempo_Inicial = System.currentTimeMillis();
		long tempo_Final=0;

		HashLinear tab = new HashLinear(quant);
		for (dados dado: dados_lista) {
			tab.insere(dado.getRegiao());
			writer.write(dado.getRegiao());
			writer.newLine();
		}
		writer.close();

		String file_desempenho="Desempenho.log4j";
		BufferedWriter write = new BufferedWriter(new FileWriter(file_desempenho));

		tempo_Final=System.currentTimeMillis()-tempo_Inicial;
		write.write(" O metodo CREATE levou : "+tempo_Final+ " ms para ser executado");
		write.close();

		System.out.print("\n\nImprimindo conteudo");
		tab.imprime();
		System.out.println("\n");
	}
}