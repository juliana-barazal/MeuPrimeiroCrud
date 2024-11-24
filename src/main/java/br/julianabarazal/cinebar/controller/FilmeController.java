package br.julianabarazal.cinebar.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.julianabarazal.cinebar.model.Filme;
import br.julianabarazal.cinebar.model.FilmeService;




@Controller
public class FilmeController {

    @Autowired
    ApplicationContext context; //guarda os objetos da aplicação, aqui está sendo usado para se conectar com o FilmeService

    @GetMapping("/") //ao fazer uma requisição get com "/", se chama o método home, retornando a view "home".
    public String home(){
        return "home";
    }

    //CREATE
    @GetMapping("/cadastrar")
    public String cadastrar(Model model){ //model permite passar os dados para a view
        model.addAttribute("filme", new Filme()); //passando objeto Filme do model para a view com o nome "filme"
        return "cadastrar";
    }
    @PostMapping("/cadastrar")
    public String sucesso(Model model, @ModelAttribute Filme filme) { //o model attribute é o que conecta com o forms da view;
        FilmeService filmeService = context.getBean(FilmeService.class); //pegando a classe do filme service
        filmeService.inserirFilme(filme); //chamando o método contido na classe service
        return "sucesso";
    }

    //READ
    @GetMapping("/preferidos")
    public String preferidos(Model model) {
        FilmeService filmeService = context.getBean(FilmeService.class);
        List<Map<String,Object>> filmes = filmeService.obterFilmes(); 
        //Cada Map é um registro de filme, com as colunas do banco: String (chave) e os valores associados (Object);
        model.addAttribute("filmes", filmes); //passa filmes para o "filmes" da view
        return "preferidos";
    }

    //UPDATE
    @GetMapping("/atualizar/{id}")
    public String atualizar(Model model, @PathVariable int id){
        FilmeService filmeService = context.getBean(FilmeService.class);
        //buscando o cliente pelo id
        Filme filme = filmeService.obterFilme(id);
        model.addAttribute("id", id);
        model.addAttribute("filme", filme);
        return "atualizar";
    }
    @PostMapping("atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Filme filme) {
        FilmeService filmeService = context.getBean(FilmeService.class);
        filmeService.atualizar(id, filme);
        return "redirect:/preferidos";
    }

    //DELETE
    @PostMapping("deletar/{id}")
    public String deletar(@PathVariable int id) {
        FilmeService filmeService = context.getBean(FilmeService.class);
        filmeService.deletar(id);
        return "redirect:/preferidos";
    }
    

}
