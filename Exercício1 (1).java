/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercício1;

/*
 * Exercício 1 (1º Lista) Júlia da Silva Dias Gonçalves
 * 
 */
// Classe para representar um nó da lista duplamente encadeada
class Node {
    String nome;
    Node anterior;
    Node proximo;

    public Node(String nome) {
        this.nome = nome;
    }
}

// Classe para representar a lista duplamente encadeada de nomes
class ListaDuplamenteEncadeada {
    Node inicio;

    // Adicionar um nome na lista em ordem alfabética
    public void adicionar(String nome) {
        Node novoNode = new Node(nome);
        if (inicio == null || inicio.nome.compareTo(nome) > 0) {
            novoNode.proximo = inicio;
            if (inicio != null) {
                inicio.anterior = novoNode;
            }
            inicio = novoNode;
        } else {
            Node atual = inicio;
            while (atual.proximo != null && atual.proximo.nome.compareTo(nome) < 0) {
                atual = atual.proximo;
            }
            novoNode.proximo = atual.proximo;
            if (atual.proximo != null) {
                atual.proximo.anterior = novoNode;
            }
            atual.proximo = novoNode;
            novoNode.anterior = atual;
        }
    }

    // Remover um nome da lista
    public void remover(String nome) {
        Node atual = inicio;
        while (atual != null && !atual.nome.equals(nome)) {
            atual = atual.proximo;
        }
        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            } else {
                inicio = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            }
        }
    }

    // Pesquisar um nome na lista
    public boolean pesquisar(String nome) {
        Node atual = inicio;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Renomear um nome na lista
    public void renomear(String nomeAtual, String novoNome) {
        remover(nomeAtual);
        adicionar(novoNome);
    }

    // Imprimir a lista de nomes
    public void imprimir() {
        Node atual = inicio;
        while (atual != null) {
            System.out.print(atual.nome + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}

// Classe para representar a estrutura de dados com o vetor de listas
class EstruturaDeDados {
    ListaDuplamenteEncadeada[] vetor;

    public EstruturaDeDados() {
        vetor = new ListaDuplamenteEncadeada[26];
        for (int i = 0; i < 26; i++) {
            vetor[i] = new ListaDuplamenteEncadeada();
        }
    }

    // Função para obter o índice com base na primeira letra do nome
    public int indice(String nome) {
        char primeiraLetra = nome.toUpperCase().charAt(0);
        return primeiraLetra - 'A';
    }

    // Adicionar um nome na estrutura de dados
    public void adicionar(String nome) {
        int index = indice(nome);
        vetor[index].adicionar(nome);
    }

    // Remover um nome da estrutura de dados
    public void remover(String nome) {
        int index = indice(nome);
        vetor[index].remover(nome);
    }

    // Pesquisar um nome na estrutura de dados
    public boolean pesquisar(String nome) {
        int index = indice(nome);
        return vetor[index].pesquisar(nome);
    }

    // Renomear um nome na estrutura de dados
    public void renomear(String nomeAtual, String novoNome) {
        int index = indice(nomeAtual);
        vetor[index].renomear(nomeAtual, novoNome);
    }

    // Imprimir a estrutura de dados
    public void imprimir() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print((char) (i + 'A') + ": ");
            vetor[i].imprimir();
        }
    }
}

// Classe principal para testar a estrutura dentro do projeto Exercício1
public class Exercício1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EstruturaDeDados estrutura = new EstruturaDeDados();

        // Teste de adição
        estrutura.adicionar("Aline");
        estrutura.adicionar("Amanda");
        estrutura.adicionar("Ana");
        estrutura.adicionar("Beatriz");
        estrutura.adicionar("Carlos");

        // Teste de impressão
        System.out.println("Estrutura após adições:");
        estrutura.imprimir();

        // Teste de pesquisa
        System.out.println("\nPesquisando 'Ana': " + estrutura.pesquisar("Ana"));
        System.out.println("Pesquisando 'João': " + estrutura.pesquisar("João"));

        // Teste de remoção
        estrutura.remover("Ana");
        System.out.println("\nEstrutura após remover 'Ana':");
        estrutura.imprimir();

        // Teste de renomear
        estrutura.renomear("Carlos", "Cesar");
        System.out.println("\nEstrutura após renomear 'Carlos' para 'Cesar':");
        estrutura.imprimir();
    }
}
