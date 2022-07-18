package br.edu.ifg.luziania.bsi.pw.model.dao.impl;

import br.edu.ifg.luziania.bsi.pw.model.dao.DAO;
import br.edu.ifg.luziania.bsi.pw.model.entity.Pessoa;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class PessoaDAO extends DAO<Pessoa> {

    @Override
    @PostConstruct
    public void createTable() {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("CREATE TABLE IF NOT EXISTS PESSOA ")
                .append(" (id INTEGER auto_increment,")
                .append(" nome VARCHAR(255), ")
                .append(" telefone VARCHAR(20), ")
                .append(" PRIMARY KEY (id)); ");
        try {
            connect().executeUpdate(sql.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void insert(Pessoa entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("INSERT INTO PESSOA (nome, telefone) VALUES (")
                .append("'"+entity.getNome()+"', ")
                .append("'"+entity.getTelefone()+"');");
        try {
            connect().executeUpdate(sql.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void delete(Pessoa entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("DELETE FROM PESSOA ")
                .append("WHERE id = "+entity.getId()+";");
        try {
            connect().executeUpdate(sql.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void update(Pessoa entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("UPDATE PESSOA SET ")
                .append("nome = '"+entity.getNome()+"', ")
                .append("telefone = '"+entity.getTelefone()+"',")
                .append("WHERE id = "+entity.getId()+";");
        try {
            connect().executeUpdate(sql.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public Pessoa getById(Pessoa entity) {
        Pessoa pessoa = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PESSOA WHERE id = :id");
        try {
            ResultSet resultSet = connect().executeQuery(sql.toString());
            pessoa =  new Pessoa( resultSet.getInt("id"),
                               resultSet.getString("nome"),
                               resultSet.getString("telefone"));

        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return pessoa;
    }

    @Override
    public List<Pessoa> getAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PESSOA");
        try {
            ResultSet resultSet = connect().executeQuery(sql.toString());
            while(resultSet.next()){
                pessoas.add(
                        new Pessoa(
                                resultSet.getInt("id"),
                                resultSet.getString("nome"),
                                resultSet.getString("telefone"))
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return pessoas;
    }
}
