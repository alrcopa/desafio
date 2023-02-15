package br.com.requeijo.desafio.programas.factory;

public interface AbstractFactory<T, U extends Enum<U>> {
	
	T criar(U tipo);

}
