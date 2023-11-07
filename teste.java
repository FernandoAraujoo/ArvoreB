public class teste {
    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB(5);
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(60);
        arvore.inserir(70);
        arvore.inserir(80);
        arvore.inserir(90);
        arvore.inserir(100);
        arvore.remover(60);
        System.out.println("Maior chave: " + arvore.maiorChave());
        System.out.println("Menor chave: " + arvore.menorChave());
        System.out.println("Altura: " + arvore.altura());
        System.out.println("Encontrar 50: " + arvore.encontrar(50));
        System.out.println("Encontrar 60: " + arvore.encontrar(60));
        arvore.exibirPorNivel();
        arvore.exibirPreOrdem();
    }
}
