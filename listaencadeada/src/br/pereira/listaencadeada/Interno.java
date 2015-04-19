package br.pereira.listaencadeada;
public class Interno<T extends Comparable<? super T>> extends No<T> {

	private T dado;
	private No<T> sucessor;
	
	public Interno(T dado, No<T> sucessor) {
		this.dado = dado;
		this.sucessor = sucessor;
	}

	@Override
	public No<T> adicionar(T dado) {
		if (dado.compareTo(this.dado) < 0) {
			return new Interno<T>(dado, this);
		} else {
			sucessor = sucessor.adicionar(dado);
			return this;
		}
	}

	@Override
	public String listar() {
		return "[" + dado + "]" + sucessor.listar();
	}

}