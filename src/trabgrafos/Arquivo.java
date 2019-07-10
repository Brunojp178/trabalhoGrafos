/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabgrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Thiago Retorna um vetor com todas as ligacoes
 */
public class Arquivo {

    public String nome;
    public String delimitador1;
    public String delimitador2;
    public int retorno[];
    public int maiorA, maiorV, maiorG;
    
    public Arquivo(String nome, String delimitador1, String delimitador2) {
        this.nome = nome;
        this.delimitador1 = delimitador1;
        this.delimitador2 = delimitador2;
    }

    public ArrayList<Integer> lerArquivo() throws FileNotFoundException {
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        ArrayList<Integer> retorno2 = new ArrayList<Integer>();
        ArrayList<Integer> retorno3 = new ArrayList<Integer>();
        
        FileReader f = new FileReader(this.getNome() + ".txt");
        Scanner arquivoLido = new Scanner(f);
        arquivoLido.useDelimiter(this.getDelimitador1());
        
        while (arquivoLido.hasNext()) {
            String lido = arquivoLido.next();
            lido = lido.replaceAll("\r\n", "");
            String parts[] = lido.split(this.getDelimitador2());
            retorno.add(Integer.parseInt(parts[0]));
            retorno2.add(Integer.parseInt(parts[0]));  
            retorno.add(Integer.parseInt(parts[1]));
            retorno3.add(Integer.parseInt(parts[1]));
        }
        this.maiorV = Collections.max(retorno2);
        this.maiorA = Collections.max(retorno3);
        if(maiorV > maiorA)
            maiorG = maiorV;
        else
            maiorG = maiorA;
        
        arquivoLido.close();
        return retorno;
    }
    
    public ArrayList<Integer> lerArquivo2() throws FileNotFoundException{
    	FileReader f;
    	ArrayList<Integer> retorno = new ArrayList<Integer>();
		
		f = new FileReader(this.getNome() + ".txt");
		Scanner arquivoLido = new Scanner(f);
		arquivoLido.useDelimiter(this.getDelimitador1());
		while(arquivoLido.hasNext()) {
			String lido = arquivoLido.next();
			lido = lido.replaceAll("\r\n", "");
			
            String parts[] = lido.split(this.getDelimitador2());
            
            int v1 = Integer.parseInt(parts[0]);
            int peso = Integer.parseInt(parts[1]);
            int v2 = Integer.parseInt(parts[2]);
            
            retorno.add(v1);
            retorno.add(peso);
            retorno.add(v2);
		}
		return retorno;
    }

    public int getMaiorA() {
        return maiorA;
    }

    public int getMaiorV() {
        return maiorV;
    }

    public int getMaiorG() {
        return maiorG;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDelimitador1() {
        return delimitador1;
    }

    public void setDelimitador1(String delimitador1) {
        this.delimitador1 = delimitador1;
    }

    public String getDelimitador2() {
        return delimitador2;
    }

    public void setDelimitador2(String delimitador2) {
        this.delimitador2 = delimitador2;
    }

}
