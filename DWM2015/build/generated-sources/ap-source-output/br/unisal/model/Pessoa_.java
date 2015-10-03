package br.unisal.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, Integer> idPessoa;
	public static volatile SingularAttribute<Pessoa, String> email;
	public static volatile SingularAttribute<Pessoa, String> nome;

}

