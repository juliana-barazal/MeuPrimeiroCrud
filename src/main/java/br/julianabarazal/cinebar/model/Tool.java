package br.julianabarazal.cinebar.model;

import java.util.Map;

public class Tool {
    public static Filme converterFilme(Map<String,Object> registro){
         //Como registro.get retorna Object, devemos usar o polimorfismo
        //de subtipos (downcast) para recuperar os tipos originais.
        return new Filme((Integer) registro.get("id"),
        (String) registro.get("titulo"),
        (String) registro.get("genero"),
        (Integer) registro.get("ano"),
        (String) registro.get("diretor"));
    }
}
