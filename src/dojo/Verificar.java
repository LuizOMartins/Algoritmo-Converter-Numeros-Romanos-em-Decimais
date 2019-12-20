package dojo;

public class Verificar {
	
    public static final String  unidade = "U";
    public static final String dezena = "D";
    public static final String centena = "C";
    public static final String milhar = "M";

    
	public String verificaGrandeza(int valor) {
			String tipoAtual = "";
		
		   if( valor > 99 && valor < 1000) {
			   tipoAtual = centena;
		   }else if( valor > 9  && valor < 100  ) {
			   tipoAtual = dezena;
		   }else if(valor > 0 && valor < 10) {
			   tipoAtual = unidade;
		   }else if(valor > 999) {
			   tipoAtual = milhar;
		   }
		return tipoAtual;
	}
	
	public boolean  verificaGrandezaEntreValores(String tipoAtual, String tipoProx) {
			boolean verificacao = false;
		
		   if( (tipoAtual.equals(unidade) && tipoProx.equals(centena)) || tipoAtual.equals(unidade) && tipoProx.equals(milhar)) {
			   	verificacao =  false;
		   }else {
			   verificacao =  true;
		   }
		   return verificacao;
	}
}
