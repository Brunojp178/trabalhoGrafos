/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabgrafos;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Gerador {
    
    // Gera lista de adjacencia
    public ArrayList<String> listaDeAdjacencia(int matrizAdjacencia[][], int qtdVertice) {
        ArrayList<String> listaComp = new ArrayList<String>();
        String atual = "";

        //System.out.println("batata " + listaComp.get(0).get(0));
        for (int i = 0; i < qtdVertice; i++) {
            String fake = "";
            atual = "";
            for (int j = 0; j < qtdVertice; j++) {

                if (matrizAdjacencia[i][j] == 1) {
                    fake = j + 1 + ""; //aqui tem o valor que precisa ser inserido
                    atual += " " + fake;
                }
            }
            //System.out.println(i + 1 + ">" + atual);
            atual = i + 1 + " > " + atual;
            listaComp.add(atual);
        }
        return listaComp;
    }
    
    // Gerar matriz de adjacencia.
    public int[][] matrizAdjacencia(ArrayList<Integer> mat, int qtdVertice) {
        int j = 0;
        int[][] matrizAd = new int[qtdVertice][qtdVertice];
        System.out.print("---");
        for (int p = 1; p <= qtdVertice; p++) {
            System.out.print(p + " ");
        }
        for (int i = 0; i < mat.size() / 2; i++) {
            matrizAd[mat.get(j) - 1][mat.get(j + 1) - 1] = 1;
            matrizAd[mat.get(j + 1) - 1][mat.get(j) - 1] = 1;
            j = j + 2;
        }
        printarMatriz(matrizAd, qtdVertice);
        System.out.println("\n\n\n");
        return matrizAd;
    }
    
    // Gerar matriz de adjacencia 2.
    public int[][] matrizAdjacencia2(ArrayList<Integer> mat, int qtdVertice) {
        
    	int col = qtdVertice + 1, lin = col;
    	int[][] matrizAd = new int[lin][col];
    	matrizAd[0][0] = 0;
    	for(int i = 0; i < lin; i++) {
			for(int j = 0; j < col; j++) {
				matrizAd[i][j] = 0;
				if(i == 0) {
					if(j > 0) matrizAd[i][j] = mat.get(j - 1);
				}if(j == 0) {
					if(i > 0) matrizAd[i][j] = mat.get(i - 1);
				}
			}
		}
        return matrizAd;
    }
    
    // Gerar matriz de incidencia
    public int[][] matrizIncidencia(ArrayList<Integer> mat, int maiorV, int maiorA) {
        int j = 0;

        int[][] matrizIn = new int[maiorV][maiorA]; //criar no tamanho do maior vértice/maior aresta desbuga
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.print("---");
        for (int p = 0; p < maiorA; p++) {
            System.out.print(alphabet[p] + " ");
        }
        for (int i = 0; i < mat.size() / 2; i++) { //não trata laço no momento
            matrizIn[mat.get(j) - 1][mat.get(j + 1) - 1] = 1;
            j = j + 2;
        }
        printarMatriz2(matrizIn, maiorV, maiorA);
        System.out.println("\n\n\n");
        return matrizIn;
    }
    
 // Gerar matriz de incidencia 2
    public int[][] matrizIncidencia2(ArrayList<Integer> mat, int maiorV, int maiorA) {
        int j = 0;

        int[][] matrizIn = new int[maiorV][maiorA]; //criar no tamanho do maior vértice/maior aresta desbuga
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.print("---");
        for (int p = 0; p < maiorA; p++) {
            System.out.print(alphabet[p] + " ");
        }
        for (int i = 0; i < mat.size() / 2; i++) { //não trata laço no momento
            matrizIn[mat.get(j) - 1][mat.get(j + 1) - 1] = 1;
            j = j + 2;
        }
        printarMatriz2(matrizIn, maiorV, maiorA);
        System.out.println("\n\n\n");
        return matrizIn;
    }
    
    // Printa uma matriz vxv
    public void printarMatriz(int[][] mat, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.println("\n");
            System.out.print(i + 1 + "--");
            for (int j = 0; j < qtd; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
    
    // Printa uma matriz vxa
    public void printarMatriz2(int[][] mat, int qtdVertice, int qtdAresta) {
        for (int i = 0; i < qtdVertice; i++) {
            System.out.println("\n");
            System.out.print(i + 1 + "--");
            for (int j = 0; j < qtdAresta; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
    
    //TODO Arvore geradora minima
    
    public int[][] gerarArvore(Grafo gf) {
    	if(!gf.floyd_warshall()) {
    		System.out.println();
    		return null;
    	}
    	
    	return null;
    }
    
}
