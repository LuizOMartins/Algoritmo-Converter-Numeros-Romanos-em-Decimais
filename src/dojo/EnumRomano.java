package dojo;

public enum EnumRomano {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

	public int valor;
	EnumRomano(int i) {
	    valor = i;
	}
}
