package br.julianabarazal.cinebar.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

//Data Access Object - serve para repositório; métodos para se conectar o banco ao service
@Repository
public class FilmeDAO {
    @Autowired // instância automática; injetada pelo Spring
    DataSource dataSource; //referencia o datasource do yaml; para se conectar com banco de dados
    JdbcTemplate jdbc; //classe que torna possível a manipulação de string sql

    @PostConstruct //método chamado após injeção de dependências(jdbc, datasource)
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

//CREATE
    public void inserirFilme(Filme filme){
        String sql = "INSERT INTO filmes(titulo, genero, ano, diretor) VALUES (?,?,?,?)";
        jdbc.update(sql, filme.getTitulo(), filme.getGenero(), filme.getAno(), filme.getDiretor()); //cada get irá substituir os placeholders "?" de sql;
    }

//READ
    public List<Map<String, Object>> obterFilmes(){
        String sql = "SELECT * FROM filmes";
        return jdbc.queryForList(sql);
    }

    public Filme obterFilme(int id){
        String sql = "SELECT * FROM filmes WHERE id = ?";
        return Tool.converterFilme(jdbc.queryForMap(sql, id));
    }

//UPDATE
    public void atualizar(int id, Filme filme){
        String sql = "UPDATE filmes SET titulo = ?, genero = ?, ano = ?, diretor = ? where id = ?";
        jdbc.update(sql, filme.getTitulo(), filme.getGenero(), filme.getAno(), filme.getDiretor(), id);
    }
    
//DELETE
    public void deletar(int id){
        String sql = "DELETE FROM filmes WHERE id = ?";
        jdbc.update(sql, id);
    }
}
