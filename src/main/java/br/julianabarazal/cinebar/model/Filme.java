package br.julianabarazal.cinebar.model;

//POJO - Plain Old Java Object(pesquisar sobre)

public class Filme {
    private int id;
    private int ano;
    private String titulo, genero, diretor;

    //Para a tela de cadastro, precisa estar vazio; sobrecarga
    public Filme(){
    }

    //Para atualizar, para update
    public Filme(int id, String titulo, String genero, int ano, String diretor) {
        this.ano = ano;
        this.diretor = diretor;
        this.genero = genero;
        this.id = id;
        this.titulo = titulo;
    }

    //Para inserir o registro, porque o id é serial
    public Filme(String titulo, String genero, int ano, String diretor) {
        this.ano = ano;
        this.diretor = diretor;
        this.genero = genero;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
