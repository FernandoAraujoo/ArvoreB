import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreB {
    private int N;
    private No raiz;

    public ArvoreB(int N) {
        this.N = N;
        this.raiz = null;
    }

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new No(N, true);
            raiz.chaves[0] = valor;
            raiz.n = 1;
        } else {
            if (raiz.n == 2 * N - 1) {
                No novo = new No(N, false);
                novo.filhos[0] = raiz;
                novo.dividirFilho(0, raiz);
                int i = 0;
                if (novo.chaves[0] < valor) {
                    i++;
                }
                novo.filhos[i].inserirNaoCheio(valor);
                raiz = novo;
            } else {
                raiz.inserirNaoCheio(valor);
            }
        }
    }

    public void remover(int valor) {
        if (raiz == null) {
            return;
        }
        raiz.remover(valor);
        if (raiz.n == 0) {
            if (raiz.ehFolha()) {
                raiz = null;
            } else {
                raiz = raiz.filhos[0];
            }
        }
    }

    public No encontrarNo(int valor) {
        return (raiz == null) ? null : raiz.encontrarNo(valor);
    }

    public int encontrarPosicao(int valor) {
        return (raiz == null) ? -1 : raiz.encontrarPosicao(valor);
    }

    public int maiorChave() {
        if (raiz == null) {
            return -1;
        }
        No atual = raiz;
        while (!atual.ehFolha()) {
            atual = atual.filhos[atual.n];
        }
        return atual.chaves[atual.n - 1];
    }

    public int menorChave() {
        if (raiz == null) {
            return -1;
        }
        No atual = raiz;
        while (!atual.ehFolha()) {
            atual = atual.filhos[0];
        }
        return atual.chaves[0];
    }

    public int altura() {
        return (raiz == null) ? 0 : raiz.altura();
    }

    public void exibirPorNivel() {
        if (raiz == null) {
            return;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            int tamanho = fila.size();
            for (int i = 0; i < tamanho; i++) {
                No atual = fila.poll();
                for (int j = 0; j < atual.n; j++) {
                    System.out.print(atual.chaves[j] + " ");
                }
                if (!atual.ehFolha()) {
                    for (int j = 0; j <= atual.n; j++) {
                        fila.add(atual.filhos[j]);
                    }
                }
            }
            System.out.println();
        }
    }

    public void exibirPreOrdem() {
        if (raiz != null) {
            raiz.exibirPreOrdem();
        }
    }

    private class No {
        private int[] chaves;
        private No[] filhos;
        private int n;
        private boolean folha;

        public No(int N, boolean folha) {
            this.chaves = new int[2 * N - 1];
            this.filhos = new No[2 * N];
            this.n = 0;
            this.folha = folha;
        }

        public void inserirNaoCheio(int valor) {
            int i = n - 1;
            if (folha) {
                while (i >= 0 && chaves[i] > valor) {
                    chaves[i + 1] = chaves[i];
                    i--;
                }
                chaves[i + 1] = valor;
                n++;
            } else {
                while (i >= 0 && chaves[i] > valor) {
                    i--;
                }
                if (filhos[i + 1].n == 2 * N - 1) {
                    dividirFilho(i + 1, filhos[i + 1]);
                    if (chaves[i + 1] < valor) {
                        i++;
                    }
                }
                filhos[i + 1].inserirNaoCheio(valor);
            }
        }

    }

}

       // public void dividirFilho(int i
