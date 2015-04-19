package br.pereira.listaencadeada;

public class CabecaSemPolimorfismo<T extends Comparable<? super T>> extends No<T> {
	
	private No<T> sucessor;

	public CabecaSemPolimorfismo() {
		sucessor = new Calda<T>();
	}

	@Override
	public No<T> adicionar(T dado) {
		if (sucessor instanceof Calda) {
			sucessor = ((Calda<T>)sucessor).adicionar(dado);
		} else if (sucessor instanceof Interno) {
			sucessor = ((Interno<T>)sucessor).adicionar(dado);
		}
		
		return this;
	}

	@Override
	public String listar() {
		return sucessor.listar();
	}

}
