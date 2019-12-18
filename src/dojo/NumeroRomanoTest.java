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
    
    @Test
    public void para_LXXIX_deveRetornar_79() {
        String entrada = "LXXIX";

        int retorno = NumeroRomano.converter(entrada);

        assertEquals(79, retorno);
    }


    @Test
    public void para_CCXXV_deveRetornar_255() {
        String entrada = "CCXXV";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(225, retorno);
    }
    

    @Test
    public void para_CCXXV_deveRetornar_845() {
        String entrada = "DCCCXLV";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(845, retorno);
    }
    
    @Test
    public void para_CDXLIV_deveRetornar_444() {
        String entrada = "CDXLIV";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(444, retorno);
    }
    
    @Test
    public void para_MMXXII_deveRetornar_2022() {
        String entrada = "MMXXII";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(2022, retorno);
    }
    
    @Test
    public void para_MMDCLXVI_deveRetornar_2666() {
        String entrada = "MMDCLXVI";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(2666, retorno);
    }
    
    @Test
    public void para_MCMXCIX_deveRetornar_1999() {
        String entrada = "MCMXCIX";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(1999, retorno);
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
        	      	
            int valorAtual = 0;
            int auxValue = 0;
            int tamanhoEntrada = entrada.length();
            int valorProximo = 0;
            int valorAcumulado = 0;
            boolean checkProximo = false;
            
            System.out.println("TAMANHO ENTRADA" + tamanhoEntrada);
            
            if (entrada.length() > 0) {
                for (int i = 0; i < tamanhoEntrada; i++){               	
                	System.out.println(i);
                	
                	String caractereAtual = String.valueOf(entrada.charAt(i));
                	valorAtual = NumRomanos.get(caractereAtual);
                	System.out.println(NumRomanos.get(caractereAtual));
                	Integer aux = i+1;
                	System.out.println("aux " +aux);
             	   
             	  if(tamanhoEntrada - aux > 0) {// tem proximo ?
             		   
                	   String caractereProx = String.valueOf(entrada.charAt(aux));
                	   valorProximo =  NumRomanos.get(caractereProx);
                	   System.out.println("valor pro" + valorProximo);   
                	   
             	  
		        	   if(valorProximo > valorAtual) {
		        		   auxValue  = (valorProximo - valorAtual);
		        		   i++;
		        		   aux++;
		        		   valorAcumulado += auxValue;              		   
		            	}
		        	   else if(valorProximo == valorAtual){
		        		   valorAcumulado += valorAtual;
		        		   valorAcumulado += valorProximo;
		        		   aux++;
		        		   i++;
		        	   } else {
		            		 valorAcumulado += valorAtual;
		        	   }
             	  }
             	  else {
             		 valorAcumulado += valorAtual;
             	  }
                }
            }else {
            	System.out.println("GET STRING"+NumRomanos.get(entrada));
            	valorAcumulado += valorAtual; 
            }
            return valorAcumulado;
        }
    }

}
