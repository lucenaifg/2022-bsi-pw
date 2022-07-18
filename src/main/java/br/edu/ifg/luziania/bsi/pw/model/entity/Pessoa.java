package br.edu.ifg.luziania.bsi.pw.model.entity;

import br.edu.ifg.luziania.bsi.pw.model.dto.PessoaDTO;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;

//@Entity
public class Pessoa {

//    @Id
//    @SequenceGenerator(name = "pessoa_id", sequenceName = "pessoa_id_seq", allocationSize = 1, initialValue = 1)
//    @GeneratedValue(generator = "pessoa_id")
    private Integer id;
    private String nome;
    private String telefone;

    public Pessoa(){

    }

    public Pessoa(PessoaDTO dto){
        this.nome = dto.getNome();
        this.telefone = dto.getTelefone();
    }

    public Pessoa(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
