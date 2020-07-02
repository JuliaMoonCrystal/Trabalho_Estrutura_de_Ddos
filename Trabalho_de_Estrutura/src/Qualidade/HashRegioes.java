package Qualidade;

import javax.swing.*;
import java.util.LinkedList;

public class HashRegioes {

	public void insereRegioes(LinkedList<dados> dados_lista) {
		int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantos novos dados voc� quer adicionar na lista ?"));

		HashLinear tab = new HashLinear(quant);

		for(int i=0; i < quant; i++) {
			String nova_regiao=JOptionPane.showInputDialog("Digite uma Regi�o de S�o Paulo :");
			tab.insere(nova_regiao);
		}

		System.out.print("\n\nImprimindo conteudo");
		tab.imprime();
		System.out.println("\n");
	}
}