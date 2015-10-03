/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.bean;

/**
 *
 * @author JETHER
 */
import br.unisal.dao.PessoaDao;
import br.unisal.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List pessoas = new ArrayList();
    private Pessoa pessoa;    
    private PessoaDao dao;

    //construtor
    public PessoaBean() {        
        pessoas = getDao().getAll();
        pessoa = new Pessoa();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(pessoa);
        pessoas = getDao().getAll();
        pessoa = new Pessoa();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(pessoa);
        pessoas = getDao().getAll();
        pessoa = new Pessoa();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(pessoa);
        pessoas = getDao().getAll();
        pessoa = new Pessoa();
    }

    //getters and setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List getPessoas() {
        return pessoas;
    }

    public void setPessoas(List pessoas) {
        this.pessoas = pessoas;
    }

    public final PessoaDao getDao() {        
        if(dao == null){
            dao = new PessoaDao();
        }
        return dao;
    }
}
