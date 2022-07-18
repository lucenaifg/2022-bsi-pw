package br.edu.ifg.luziania.bsi.pw.model.bo;

import br.edu.ifg.luziania.bsi.pw.model.dao.impl.PessoaDAO;
import br.edu.ifg.luziania.bsi.pw.model.dto.PessoaDTO;
import br.edu.ifg.luziania.bsi.pw.model.entity.Pessoa;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class PessoaBO {

    @Inject
    PessoaDAO dao;

    private boolean validador(PessoaDTO dto){
        return !(dto.getNome().isBlank() || dto.getTelefone().isBlank());
    }

    public void save(PessoaDTO dto) {
        if (validador(dto)){
            dao.insert(new Pessoa(dto));
        }
        List<Pessoa> pessoas = dao.getAll();
        pessoas.size();
    }
}
