package dojo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class NumeroRomanoTest {

    @Test
    public void para_I_deveRetornar_1() {
        String entrada = "I";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(1, retorno);
    }

    @Test
    public void para_II_deveRetornar_2() {
        String entrada = "II";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(2, retorno);
    }


    @Test
    public void para_IV_deveRetornar_4() {
        String entrada = "IV";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(4, retorno);
    }

    @Test
    public void para_XIV_deveRetornar_14() {
        String entrada = "XIV";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(14, retorno);
    }

    @Test
    public void para_V_deveRetornar_5() {
        String entrada = "V";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(5, retorno);
    }

    @Test
    public void para_X_deveRetornar_10() {
        String entrada = "X";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(10, retorno);
    }

    @Test
    public void para_MMM_deveRetornar_3000() {
        String entrada = "MMM";

        int retorno = NumeroRomano.converter(entrada);

        assertEquals(3000, retorno);
    }


    static class NumeroRomano {
    	
    	
        public static int converter(String entrada) {
        	Map<String, Integer> NumRomanos = new HashMap<String, Integer>();
        	NumRomanos.put("I", 1);
        	NumRomanos.put("V", 5);
        	NumRomanos.put("X", 10);
        	NumRomanos.put("L", 50);
        	NumRomanos.put("C", 100);
        	NumRomanos.put("D", 500);
        	NumRomanos.put("M", 1000);
        	      	
            int valor = 0;
            int valorAtual = 0;
            int aux = 0;
            Integer valorAnterior = 0;
            Integer tamanhoEntrada = entrada.length();
            
            
            System.out.println("TAMANHO ENTRADA" + tamanhoEntrada);
            
            if (entrada.length() > 1) {
                for (int i = 0; i < tamanhoEntrada; i++){
                	
                	String caractereAtual = String.valueOf(entrada.charAt(i));
                	System.out.println(NumRomanos.get(caractereAtual));
                	
                	
                	
//                	if(valorAtual > valorAnterior) {
//                		
//                	}
                	
                	valor += NumRomanos.get(caractereAtual);
                	valorAnterior = NumRomanos.get(caractereAtual);
                	System.out.println("ATUAL");
                }
                
            }else {

            	System.out.println("GET STRING"+NumRomanos.get(entrada));
            	valor = NumRomanos.get(entrada); 
            }

            return valor;
        }
    }

}
