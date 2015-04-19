package br.pereira.listaencadeada;

public class Cabeca<T extends Comparable<? super T>> extends No<T> {

	private No<T> sucessor;

	public Cabeca() {
		sucessor = new Calda<T>();
	}

	@Override
	public No<T> adicionar(T dado) {
		sucessor = sucessor.adicionar(dado);
		return this;
	}

	@Override
	public String listar() {
		return sucessor.listar();
	}

}