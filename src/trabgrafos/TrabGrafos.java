/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabgrafos;

import java.util.Arrays;

/**
 *
 * @author aluno
 */
public class TrabGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	/*
    	Grafo gf = new Grafo("grafo");
    	
    	// Printando lista de adj
    	gf.printListaAdj();
    	
    	System.out.println();
    	
    	// printa a ordem e o tamanho do grafo
    	System.out.println("Ordem do grafo: " + gf.ordemDoGrafo() + "\n");
    	System.out.println("Ordem do grafo: " + gf.tamanhoDoGrafo() + "\n");
    	
    	// verifica laços
    	System.out.println("Tem laco? " + gf.verificaSeTemLaco());
    	
    	// é um grafo simples?
    	System.out.println("Grafo simples? " + gf.testeSimples());
    	
    	// é multi-grafo?
    	System.out.println("Multigrafo? " + gf.testeMultigrafo());
    	
    	// é pseudo-grafo?
    	System.out.println("Pseudografo? " + gf.testePseudografo());
    	
    	// é um grafo completo?
    	System.out.println("Grafo completo? " + gf.testeGrafoCompleto());
    	
    	// testa grau de um vertice.
    	System.out.println("Grau do vertice 3: " + gf.grauDoVertice(3));
    	
    	
    	// Vetor para testes
    	int vetAux[];
        boolean ciclo1 = false;
        boolean cicloFinal = false;
        
        vetAux = new int[gf.getQntV()];
        for (int i = 0; i < gf.getQntV(); i++) {
            vetAux[i] = 0;
        }
        int vetAux2[];
        vetAux2 = new int[gf.getQntV()];
        for (int i = 0; i < gf.getQntV(); i++) {
            vetAux2[i] = 2;
        }
        
        if (Arrays.equals(vetAux, vetAux2)) {
            ciclo1 = true;
        } else {
            ciclo1 = false;
        }

        if (ciclo1 == true) {
            if (gf.getQntV() == gf.getQntA()) {
                cicloFinal = true;
            } else {
                cicloFinal = false;
            }
        }
        System.out.println("É ciclo? " + cicloFinal);
        
        gf.floyd_warshall();
    	*/
    	
    	// Não apagar comentarios acima, primeiros testes.
    	Grafo gf = new Grafo("grafo2", "");
    	
    }
    
}
