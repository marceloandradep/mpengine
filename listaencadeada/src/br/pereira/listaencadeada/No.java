package br.pereira.listaencadeada;

public abstract class No<T> {

	public abstract No<T> adicionar(T dado);

	public abstract String listar();

}