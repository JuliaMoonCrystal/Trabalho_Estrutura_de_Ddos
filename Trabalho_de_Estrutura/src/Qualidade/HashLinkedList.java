package Qualidade;

import javax.swing.*;
import java.util.LinkedList;

public class HashLinkedList {
    public static int TAM_MAX;
    private LinkedList<Hash>[] arr;

    public HashLinkedList(int tam) {
        this.TAM_MAX = tam;
        this.arr = new LinkedList[tam];
        for(int i=0; i < tam; i++) {
            arr[i] = null;
        }
    }

    public void iniciar() {
        int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantos novos dados você quer adicionar na lista ?"));

        for(int i=0; i < quant; i++) {
            String nova_regiao= JOptionPane.showInputDialog("Digite uma Região de São Paulo :");
            this.registraCidade(nova_regiao);
        }

        this.printHashTable();
    }

    private Hash obtemRegiaodoObjeto(String key) {
        if(key == null) {
            return null;
        }
        int index = key.hashCode() % TAM_MAX;
        LinkedList<Hash> items = arr[index];

        if(items == null) {
            return null;
        }
        for(Hash item : items) {
            if(item.key == key.hashCode()) {
                return item;
            }
        }
        return null;
    }

    public void registraCidade(String cidade) {
        int index = (Character.toString(cidade.toLowerCase().charAt(0)).hashCode() & 0x7fffffff) % TAM_MAX;
        LinkedList<Hash> items = arr[index];

        if(items == null) {
            items = new LinkedList<Hash>();
            Hash item = new Hash(true);
            item.key = cidade.hashCode();
            item.cidade = cidade;
            items.add(item);
            arr[index] = items;
        } else {
            for(Hash item : items) {
                if(item.key == cidade.hashCode()) {
                    item.cidade = cidade;
                    return;
                }
            }

            Hash item = new Hash(true);
            item.key = cidade.hashCode();
            item.cidade = cidade;
            items.add(item);
        }
    }

    public void printHashTable() {
        for(int i = 0; i < this.TAM_MAX; i++) {
            if(arr[i] != null) {
                System.out.print("Hash["+i+"] => ");
                LinkedList<Hash> linkedList = arr[i];
                for(Hash item: linkedList) {
                    System.out.print(item.cidade + " -> ");
                }
                System.out.println("");
            }
        }
    }
}