package padrao;

/**
 * Exercício 2
 * @author João Enrique Barbosa Santos Alves
 */
public class Principal {
    public static void main(String[] args){
        FilaCircular fila = new FilaCircular(4);
        
        //enfileira
        fila.enfileira(1);
        fila.enfileira(2);
        fila.enfileira(3);
        fila.enfileira(4);
        
        //desenfileira
        fila.desenfileira();
        
        //enfileira
        fila.enfileira(5);
        
        System.out.println("cabeca " + fila.cabeca());
        System.out.println("cauda " + fila.cauda());
        System.out.println("tamanho " + fila.tamanho());
        System.out.println("vazia " + fila.vazia());
        System.out.println("cheia " + fila.cheia());
        
        
        fila.mostrarFila();//mostra fila
        
        // pesquisa
        System.out.println(fila.pesquisa(10)); //false
        System.out.println(fila.pesquisa(4)); //true
      
        
        
    }
        
}

class FilaCircular {
    private Object[] fila;
    private int frente;
    private int finalFila;
    private int totalItens;

    public FilaCircular(int tamanho) {
        this.fila = new Object[tamanho];
        this.frente = 0;
        this.finalFila = 0;
        this.totalItens = 0;
    }
    
    void enfileira(Object obj) {
        if (this.cheia()) {
            System.out.println("Fila cheia, não é possível enfileirar.");
            return;
        }
        if (this.finalFila == this.tamanho() - 1) {
            this.finalFila = -1; // Retorna para o início (fila circular)
        }
        this.fila[++this.finalFila] = obj; // Enfileira o objeto
        if (this.frente == -1) { // Se a fila estava vazia, atualiza a frente
            this.frente = 0;
        }
        this.totalItens++;
    }
    
    Object desenfileira() {
        if (this.vazia()) {
            System.out.println("Fila vazia, não é possível desenfileirar.");
            return null;
        }
        
        Object obj = this.fila[this.frente+1];
        this.fila[frente+1] = null; // Limpa a posição da fila
        this.frente++;
        if (this.frente+1 == this.tamanho()) {
            this.frente = -1; // Retorna para o início (fila circular)
        }
        this.totalItens--;
        return obj;
    }
    
    Object cabeca() {
        if (vazia()) {
            return null;
        }
        return this.fila[this.frente+1];
    }
    
    Object cauda() {
        if (vazia()) {
            return null;
        }
        return this.fila[this.finalFila];
    }

    boolean vazia() {
        return this.totalItens == 0;
    }

    boolean cheia() {
        return this.tamanho() == this.totalItens;
    }

    void mostrarFila(){
        System.out.print("[ ");
        
        for(int i = 0; i < this.fila.length; i++){
            String separator = i >= this.fila.length -1 ? " " : ", ";
            System.out.print(this.fila[i] + separator);
        }
        
        System.out.println("]");
    }

    public boolean pesquisa(Object obj) {
        if (this.vazia()) {
            return false;
        }
        int i = this.frente;
        for (int j = 0; j < this.tamanho(); j++) {
            if (this.fila[i] != null && this.fila[i].equals(obj)) {
                return true;
            }
            i = (i + 1) % this.tamanho(); // A fila é circular
        }
        return false;
    }

    public int tamanho() {
        return this.fila.length;
    }
}

// Comente a dificuldade para se diferenciar fila cheia de fila vazia.
// R: Não tive dificuldade, pois criei a variavel totalItens. 
//Se totalItens for = 0 a fila está vazia. 
//Se totalItens for = ao tamanho, a fila está cheia