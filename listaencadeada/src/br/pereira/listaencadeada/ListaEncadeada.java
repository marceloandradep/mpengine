package br.pereira.listaencadeada;

public class ListaEncadeada<T extends Comparable<? super T>> {

	private Cabeca<T> cabeca;

	public ListaEncadeada() {
		cabeca = new Cabeca<T>();
	}

	public void adicionar(T dado) {
		cabeca.adicionar(dado);
	}

	public String listar() {
		return cabeca.listar();
	}

}