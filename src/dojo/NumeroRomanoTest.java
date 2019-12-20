package dojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.junit.Test;

import exception.IllegalArgumentExceptionValorInvalido;

public class NumeroRomanoTest {

    @Test
    public void para_I_deveRetornar_1() {
        String entrada = "I";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(1, retorno);
    }

    @Test
    public void para_II_deveRetornar_2() {
        String entrada = "II";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(2, retorno);
    }


    @Test
    public void para_IV_deveRetornar_4() {
        String entrada = "IV";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(4, retorno);
    }

    @Test
    public void para_XIV_deveRetornar_14() throws Throwable {
        String entrada = "XIV";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(14, retorno);
    }

    @Test
    public void para_V_deveRetornar_5() throws Throwable {
        String entrada = "V";
        int retorno = NumeroRomano.converter(entrada);
        assertEquals(5, retorno);
    }

    @Test
    public void para_X_deveRetornar_10() {
        String entrada = "X";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(10, retorno);
    }

    @Test
    public void para_MMM_deveRetornar_3000() {
        String entrada = "MMM";

        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        assertEquals(3000, retorno);
    }
    
    @Test
    public void para_LXXIX_deveRetornar_79() {
        String entrada = "LXXIX";

        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        assertEquals(79, retorno);
    }


    @Test
    public void para_CCXXV_deveRetornar_255() {
        String entrada = "CCXXV";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(225, retorno);
    }
    

    @Test
    public void para_CCXXV_deveRetornar_845() {
        String entrada = "DCCCXLV";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(845, retorno);
    }
    
    @Test
    public void para_CDXLIV_deveRetornar_444() {
        String entrada = "CDXLIV";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(444, retorno);
    }
    
    @Test
    public void para_MMXXII_deveRetornar_2022() {
        String entrada = "MMXXII";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(2022, retorno);
    }
    
    @Test
    public void para_MMDCLXVI_deveRetornar_2666() {
        String entrada = "MMDCLXVI";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(2666, retorno);
    }
    
    @Test
    public void para_MCMXCIX_deveRetornar_1999() {
        String entrada = "MCMXCIX";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(1999, retorno);
    }
    
    @Test
    public void para_IC_deveRetornar_ERRO() throws Throwable {
        String entrada = "IC";
        int retorno = 0;
		try {
			retorno = NumeroRomano.converter(entrada);
		} catch (IllegalArgumentExceptionValorInvalido e) {
			JOptionPane.showMessageDialog(null, String.format(e.getLocalizedMessage()));
		}
        assertNotEquals(99, retorno);
    }
    
    static class NumeroRomano {
    	
    	
        public static int converter(String entrada) throws Throwable {
        	
        	Verificar verificar = new  Verificar();
            int valorAtual = 0, auxValue = 0, valorProximo = 0, valorAcumulado = 0, countProx = 0;
            int tamanhoEntrada = entrada.length();
            String tipoAtual = "",tipoProx= "" ;
        	
        	Map<String, Integer> NumRomanos = new HashMap<String, Integer>();
        	NumRomanos.put("I", 1);
        	NumRomanos.put("V", 5);
        	NumRomanos.put("X", 10);
        	NumRomanos.put("L", 50);
        	NumRomanos.put("C", 100);
        	NumRomanos.put("D", 500);
        	NumRomanos.put("M", 1000);
        	
        	Map<String, String> TipoAtual = new HashMap<String, String>();
        	TipoAtual.put("U", "Unidade");
        	TipoAtual.put("D", "Dezena");
        	TipoAtual.put("C", "Centena");
        	TipoAtual.put("M", "Milhar");
        	                      
            if (entrada.length() > 1) {
                for (int i = 0; i < tamanhoEntrada; i++) {
                	
                	String caractereAtual = String.valueOf(entrada.charAt(i));
                	valorAtual = NumRomanos.get(caractereAtual);
                	countProx= i+1;
                	
             	  if(tamanhoEntrada - countProx > 0) {// tem proximo ?
             		  
                	   String caractereProx = String.valueOf(entrada
                			   				  .charAt(countProx));
                	   valorProximo =  NumRomanos.get(caractereProx); 
                	   
		        	   if(valorProximo > valorAtual) {
		        		   
		        		   tipoAtual =  verificar.verificaGrandeza(valorAtual);
		        		   tipoProx =  verificar.verificaGrandeza(valorProximo);
		        		   
		        		   if(!verificar.verificaGrandezaEntreValores(tipoAtual,tipoProx)) {
		        			   throw new IllegalArgumentExceptionValorInvalido("O valor:\t "+ entrada + " é invalido! \n" +
				        		       "Valor atual é: "+valorAtual + " que é "+ TipoAtual.get(tipoAtual) 
				        		       + "\nValor próximo é "+ valorProximo + " que é " +  TipoAtual.get(tipoProx) 
				        		       +"\n Insira outro valor." );			        			   
		        		   }
		        		   
		        		   auxValue  = (valorProximo - valorAtual);
		        		   i++;
		        		   countProx++;
		        		   valorAcumulado += auxValue;              		   
		        	   }
		        	   else if(valorProximo == valorAtual){
		        		   valorAcumulado += valorAtual;
		        		   valorAcumulado += valorProximo;
		        		   countProx++;
		        		   i++;
		        	   } else { valorAcumulado += valorAtual; }
             	  } else { valorAcumulado += valorAtual; }
             	  
                }
            }else {
            	String caractereAtual = String.valueOf(entrada.charAt(0));
            	valorAtual = NumRomanos.get(caractereAtual);
            	valorAcumulado += valorAtual; 
            }
            return valorAcumulado;
        }
    }
}
