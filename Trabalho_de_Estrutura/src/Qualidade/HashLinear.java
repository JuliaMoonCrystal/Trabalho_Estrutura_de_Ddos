package Qualidade;

public class HashLinear {

    private Hash[] tab;
    private int TAM_MAX;

    public HashLinear(int tam) {
        tab = new Hash[tam];
        TAM_MAX = tam;
        for (int i = 0; i < tam; i++)
        {
            tab[i] = new Hash(false);
        }
    }

    private int funcaohash(String chave) {
        int h = 0;
        for (int i = 0; i < chave.length(); i++) {
            h = (31 * h + chave.charAt(i)) % TAM_MAX;
        }
        return h;
    }

    public void insere(String cidade) {
        if (cheia()) {
            System.out.println("\n->ATENCAO Tabela cheia");
            return;
        }
        int pos = funcaohash(cidade);

        if (tab[pos].ocupado == true) {

            if (cidade == tab[pos].cidade) {
                System.out.println("\n->ATENCAO Esse item ja foi cadastrado");
                return;
            }

            System.out.println("-> Ocorreu uma colisao na posicao " + pos);
            while (pos < TAM_MAX) {
                if (pos == TAM_MAX - 1) {
                    pos = -1;
                }
                pos++;
                if (!tab[pos].ocupado)
                {
                    break;
                }
            }
        }

        tab[pos].cidade = cidade;
        tab[pos].ocupado = true;
        System.out.print("-> Inserido HASH[" + pos + "]");
    }

    public void imprime() {
        for (int i = 0; i < TAM_MAX; i++) {
            if (tab[i].ocupado == true) {
                System.out.print("\nHash[" + i + "] = " + tab[i].cidade);
            }
        }
    }

    public boolean cheia() {
        int i, qtde = 0;
        for (i = 0; i < TAM_MAX; i++) {
            if (tab[i].ocupado == true) {
                qtde++;
            }
        }
        if (qtde == TAM_MAX) {
            return true;
        }
        return false;
    }
}