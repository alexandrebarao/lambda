/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author alexandrebarao
 */
public class JavaApplicationLambda {

    
    public static ArrayList<Conta> filtraLista(ArrayList<Conta> lista, Filtro filtro) {
       
        ArrayList<Conta> resultado = new ArrayList<>();
       
        for(Conta s: lista) {
            
            if (filtro.autorizaCredito(s)) resultado.add(s);
        }
        
        
// expressão funcional alternativa
//
//        lista.stream().filter((s) -> (filtro.autorizaCredito(s))).forEachOrdered((s) -> {
//            resultado.add(s);
//        });
       
        return resultado;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Conta> lista = new ArrayList<>();
        
        
        lista.add(new Conta("Luis", 100));
        lista.add(new Conta("Sérgio", 200));
        lista.add(new Conta("Raquel", 300));
        lista.add(new Conta("André", 400));
        lista.add(new Conta("Guilherme", 500));
        lista.add(new Conta("Ana", 600));
        lista.add(new Conta("Ricardo", 700));
        lista.add(new Conta("Inês", 800));
        lista.add(new Conta("Cláudio", 900));
        lista.add(new Conta("Filipe", 1000));
        lista.add(new Conta("Warley", 1100));
        
        
       
        System.out.println("Lista completa");
        System.out.println(lista);
        
        ArrayList<Conta> contasAutorizadas;
        
        contasAutorizadas = filtraLista(lista, new AnaliseCredito () );
        System.out.println("Lista filtrada com Análise Credito > 1000");
        System.out.println(contasAutorizadas);
         
         
        
        contasAutorizadas = filtraLista(lista, new Filtro () {
            @Override
            public boolean autorizaCredito(Conta c) {
                return c.getSaldo()> 900;
            }
        });
        
        System.out.println("Lista filtrada com redefinição de Análise Credito > 900");
        System.out.println(contasAutorizadas);
        
     
        // Lambda
        contasAutorizadas = filtraLista(lista, (Conta c) -> c.getSaldo() > 500);
        System.out.println("Lista filtrada com expressão lambda > 500");
        System.out.println(contasAutorizadas);
        
        // Lambda
        contasAutorizadas = filtraLista(lista, (Conta c) -> c.getSaldo() > 600);
        System.out.println("Lista filtrada com expressão lambda > 600");
        System.out.println(contasAutorizadas);
         
        
        // Outros exemplos com expressões Lambda
        
        
        // # 1
        
        // Expressão lambda, com lista de strings 
        List<String> listaTitulares = new ArrayList<>();
        
        for (int i = 0; i < lista.size(); i++ ) {
            Conta c = lista.get(i);
            listaTitulares.add(c.getTitular());
        }
        
        
        // Expressão lambda, Listar nomes com 4 caracteres 
        System.out.println("Nomes com 4 caracteres");
        listaTitulares.stream().filter(l -> l.length() == 4 ).forEach(System.out::println);

        // Expressão lambda, Listar nomes que começam com R 
         System.out.println("Nomes com primeira letra R");
        listaTitulares.stream().filter(l -> l.toUpperCase().startsWith("R")).forEach(System.out::println);

       
        // # 2
        
        // Expressão lambda, com lista de valores 
        List<Double> listaSaldos = new ArrayList<>();
        
        for (int i = 0; i < lista.size(); i++ ) {
            Conta c = lista.get(i);
            listaSaldos.add(c.getSaldo());
        }
        
        // Expressão lambda, Listar todos os saldos com mais 10% de juros 
        System.out.println("Valores com 10% de juros");
        listaSaldos.forEach(saldoComJuro -> System.out.println( saldoComJuro + saldoComJuro * .1 ));
        
        
        // #3 
        // Finalmente... Expressão lambda numa linha, com objetos!!!   
        System.out.println("Contas e titulares com 10% de juros a partir de objetos!");
        lista.forEach( p -> System.out.println(String.format("%s %.2f€", p.getTitular(), p.getSaldo() * 1.1) ));
        
        // Finalmente... Expressão lambda com bloco de código, com objetos!!!   
        System.out.println("Contas com saldo >= 1000, titulares com 10% de juros a partir de objetos!");
        lista.forEach( p -> { 
                    if ( p.getSaldo() >= 1000 ) {
                        System.out.println(String.format("%s %.2f€", p.getTitular(), p.getSaldo() * 1.1) );
                    }
                }
        
        );
        
        
    }
    
}
