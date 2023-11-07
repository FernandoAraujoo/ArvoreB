import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreB<T extends Comparable<T>> {
    private int grau;
    private No raiz;

    public ArvoreB(int grau) {
        this.grau = grau;
        raiz = new No();
    }

    public void inserir(T valor) {
        if (raiz.estaCheio()) {
            No novaRaiz = new No();
            novaRaiz.filhos.add(raiz);
            novaRaiz.dividirFilho(0, raiz);
            novaRaiz.inserirNaoCheio(valor);
            raiz = novaRaiz;
        } else {
            raiz.inserirNaoCheio(valor);
        }
    }

    public void remover(T valor) {
        if (raiz.n == 0) {
            System.out.println("A árvore está vazia.");
            return;
        }
        remover(valor);
        if (raiz.n == 0) {
            if (raiz.eFolha()) {
                raiz = null;
            } else {
                raiz = raiz.filhos.get(0);
            }
        }
    }

    public T encontrarMaior() {
        if (raiz == null) {
            return null;
        }
        No noAtual = raiz;
        while (!noAtual.eFolha()) {
            noAtual = noAtual.filhos.get(noAtual.n);
        }
        return noAtual.chaves.get(noAtual.n - 1);
    }

    public T encontrarMenor() {
        if (raiz == null) {
            return null;
        }
        No noAtual = raiz;
        while (!noAtual.eFolha()) {
            noAtual = noAtual.filhos.get(0);
        }
        return noAtual.chaves.get(0);
    }

    public int calcularAltura() {
        if (raiz == null) {
            return 0;
        }
        return calcularAltura();
    }

    public No encontrarNo(T valor) {
        if (raiz == null) {
            return null;
        }
        return encontrarNo(valor);
    }

    public void exibirPorNivel() {
        if (raiz == null) {
            return;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            int tamanhoFila = fila.size();
            for (int i = 0; i < tamanhoFila; i++) {
                No noAtual = fila.poll();
                System.out.print(noAtual + " ");
                for (No filho : noAtual.filhos) {
                    fila.add(filho);
                }
            }
            System.out.println();
        }
    }

    public void exibirPreOrdem() {
        if (raiz == null) {
            return;
        }
       exibirPreOrdem();
    }

    private class No {
        public int n;
        private ArrayList<T> chaves;
        private ArrayList<No> filhos;

        private No() {
            chaves = new ArrayList<>();
            filhos = new ArrayList<>();
        }

       
        private boolean estaCheio() {
            return chaves.size() == 2 * grau - 1;
        }

        private void dividirFilho(int indice, No no) {
            No novoNo = new No();
            novoNo.chaves.addAll(no.chaves.subList(grau, 2 * grau - 1));
            no.chaves.subList(grau - 1, 2 * grau - 1).clear();
            if (!no.eFolha()) {
                novoNo.filhos.addAll(no.filhos.subList(grau, 2 * grau));
                no.filhos.subList(grau, 2 * grau).clear();
            }
            chaves.add(indice, no.chaves.remove(grau - 1));
            filhos.add(indice + 1, novoNo);
        }

        private boolean eFolha() {
            return false;
        }


        private void inserirNaoCheio(T valor) {
            int indice = chaves.size() - 1;
            if (eFolha()) {
                chaves.add(null);
                while (indice >= 0 && valor.compareTo(chaves.get(indice)) < 0) {
                    chaves.set(indice + 1, chaves.get(indice));
                    indice--;
                }
                chaves.set(indice + 1, valor);
            } else {
                while (indice >= 0 && valor.compareTo(chaves.get(indice)) < 0) {
                    indice--;
                }
                indice++;
                if (filhos.get(indice).estaCheio());
            }
        }
    }

    public String menorChave() {
        return null;
    }

    public String altura() {
        return null;
    }
}
