// Exercício 3 (1º Lista) Mariane Batista de Souza

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 10  // Tamanho máximo do vetor compartilhado

int vetor[MAX];
int topoA, topoB;

// Inicializa os valores de topoA e topoB
void criaPilha() {
    topoA = -1;
    topoB = MAX;
}

// Empilha um objeto no topo da Pilha A
void empilhaA(int obj) {
    if (topoA < topoB - 1) {
        vetor[++topoA] = obj;
    } else {
        printf("Pilha A está cheia\n");
    }
}

// Empilha um objeto no topo da Pilha B
void empilhaB(int obj) {
    if (topoA < topoB - 1) {
        vetor[--topoB] = obj;
    } else {
        printf("Pilha B está cheia\n");
    }
}

// Verifica se a Pilha A está vazia
bool vaziaA() {
    return topoA == -1;
}

// Verifica se a Pilha B está vazia
bool vaziaB() {
    return topoB == MAX;
}

// Desempilha o topo da Pilha A
int desempilhaA() {
    if (!vaziaA()) {
        return vetor[topoA--];
    } else {
        printf("Pilha A está vazia\n");
        return -1;
    }
}

// Desempilha o topo da Pilha B
int desempilhaB() {
    if (!vaziaB()) {
        return vetor[topoB++];
    } else {
        printf("Pilha B está vazia\n");
        return -1;
    }
}

// Verifica se a Pilha A está cheia
bool cheiaA() {
    return topoA == topoB - 1;
}

// Verifica se a Pilha B está cheia
bool cheiaB() {
    return topoA == topoB - 1;
}

// Retorna o topo da Pilha A
int topoAElement() {
    if (!vaziaA()) {
        return vetor[topoA];
    } else {
        printf("Pilha A está vazia\n");
        return -1;
    }
}

// Retorna o topo da Pilha B
int topoBElement() {
    if (!vaziaB()) {
        return vetor[topoB];
    } else {
        printf("Pilha B está vazia\n");
        return -1;
    }
}

// Mostra todos os elementos da Pilha A
void mostrarPilhaA() {
    for (int i = topoA; i >= 0; i--) {
        printf("%d ", vetor[i]);
    }
    printf("\n");
}

// Mostra todos os elementos da Pilha B
void mostrarPilhaB() {
    for (int i = topoB; i < MAX; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");
}

// Retorna o tamanho da Pilha A
int tamanhoA() {
    return topoA + 1;
}

// Retorna o tamanho da Pilha B
int tamanhoB() {
    return MAX - topoB;
}

int main() {
    criaPilha();
    empilhaA(1);
    empilhaA(7);
    empilhaA(2);
    empilhaA(9);
    empilhaB(3);
    empilhaB(4);
    empilhaB(8);
    empilhaB(9);

    printf("Pilha A: ");
    mostrarPilhaA();
    printf("Pilha B: ");
    mostrarPilhaB();

    printf("Topo da Pilha A: %d\n", topoAElement());
    printf("Topo da Pilha B: %d\n", topoBElement());

    printf("Tamanho da Pilha A: %d\n", tamanhoA());
    printf("Tamanho da Pilha B: %d\n", tamanhoB());

    return 0;
}
