package br.julianabarazal.cinebar.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//service faz a conexão do model(banco) com a view(front)
@Service
public class FilmeService {
    @Autowired
    FilmeDAO filmeDAO;

    //Create
    public void inserirFilme(Filme filme){
        filmeDAO.inserirFilme(filme);
    }

    //Read
    public List<Map<String,Object>> obterFilmes(){
        return filmeDAO.obterFilmes();
    }

    public Filme obterFilme(int id){
        return filmeDAO.obterFilme(id);
    }

    //Update
    public void atualizar(int id, Filme filme){
        filmeDAO.atualizar(id, filme);
    }

    //Delete
    public void deletar(int id){
        filmeDAO.deletar(id);
    }
}
