package br.pereira.listaencadeada;

public class Calda<T extends Comparable<? super T>> extends No<T> {

	@Override
	public No<T> adicionar(T dado) {
		return new Interno<T>(dado, this);
	}

	@Override
	public String listar() {
		return "";
	}

}