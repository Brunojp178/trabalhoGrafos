/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabgrafos;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Grafo {
    
    private int qntArestas;
    private int qntVertices;
    private int[][] matrizAd;
    private int[][] matrizIn;
    private ArrayList<String> listaAdj;
    
    public Grafo(String arquivo){
        Gerador gen = new Gerador();
        Arquivo arq = new Arquivo(arquivo, ",", "-");
        
        //recebendo a matriz do arquivo 
        ArrayList<Integer> mat = null;
		try {
			mat = arq.lerArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //pegando a quantidade de arestas/vertices a serem criados
        this.qntVertices = arq.getMaiorG();
        this.qntArestas = arq.getMaiorA();

        // Gerando as matrizes e lista de adj
        matrizAd = gen.matrizAdjacencia(mat, qntVertices);
        matrizIn = gen.matrizIncidencia(mat, qntVertices, qntArestas);
        listaAdj = gen.listaDeAdjacencia(matrizAd, qntVertices);
    }
    
    
    // Methods =====================================================================================================
    
    public int getQntA() {
    	return qntArestas;
    }
    
    public int getQntV() {
    	return qntVertices;
    }
    
    //verifica se o nÃºmero de arestas é n(n-1)/2 (grafo completo)
    public boolean testeGrafoCompleto() {
        return ((qntVertices * (qntVertices - 1) / 2)) == qntArestas;
    }

    //retorna a ordem do grafo (quantidade de vértices)
    public int ordemDoGrafo() {
        return qntVertices;
    }

    //retorna o tamanho do grafo (soma da quantidade de vértices + arestas)
    public int tamanhoDoGrafo() {
        return qntVertices + qntArestas;
    }
    
    // Printar lista de adj
    public void printListaAdj() {
    	for(int i = 0; i < listaAdj.size(); i++) {
    		System.out.println(listaAdj.get(i));
    	}
    }
    
    // Verifica se o grafo é conexo.
    public boolean testeConexo(int graph[][], int maiorV) {
        for (int i = 0; i < maiorV; i++) {
            for (int j = 0; j < maiorV; j++) {
                if (graph[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //tem laÃ§o se sai e entra do vertice
    public boolean verificaSeTemLaco() {
        for (int i = 0; i < qntVertices; i++) {
            if (matrizAd[i][i] == 1) {
                return true;
            }
        }
        return false;
    }
    
    //é multigrafo se existem arestas parelelas
    public boolean testeMultigrafo() {
        int contArestaParalela = 0;
        for (int i = 0; i < qntVertices; i++) {
            for (int j = 0; j < qntVertices; j++) {
                if (matrizAd[i][j] == 1) {
                    contArestaParalela = 0;
                    for (int aresta = 0; aresta < qntArestas; aresta++) {
                        if (matrizIn[i][aresta] == 1 && matrizIn[j][aresta] == 1)//testa se a aresta liga os dois vertices
                        {
                            contArestaParalela++;
                        }
                    }
                }
            }
        }
        if (contArestaParalela >= 2) {
            return true;
        }
        return false;
    }
    
    //É simples se não tem laço e não tem arestas paralelas
    public boolean testeSimples() {
        if (!(verificaSeTemLaco()) && !(testeMultigrafo())) {
            return true;
        } else {
            return false;
        }
    }
    
    //tem que possuir no minimo um laço 
    public boolean testePseudografo() {
        if (verificaSeTemLaco()) {
            return true;
        } else {
            return false;
        }
    }
    
    //verifica o grau de um vertice especifico
    public int grauDoVertice(int vertice) {
        int grau = 0;
        for (int i = 0; i < qntArestas; i++) //linhas = arestas
        {
            if (matrizIn[vertice][i] == 1) {
                grau++;
            }
        }
        return grau;
    }
    
    //algoritmo para en 
    public void floyd_warshall() {
        Gerador gen = new Gerador();
        int graph [][] = matrizAd;
        for (int k = 0; k < qntVertices; k++) {
            for (int i = 0; i < qntVertices; i++) {
                if (graph[i][k] == 1) {
                    for (int j = 0; j < qntVertices; j++) {
                        graph[i][j] |= (graph[i][k] & graph[k][j]);
                    }
                }
            }
        }
        boolean y = testeConexo(graph, qntVertices);
        gen.printarMatriz(graph, qntVertices);
        System.out.println("\n");
        System.out.println("É conexo? " + y);
    }
}
