package br.com.fiap.vitorportelaf.jogadorfutebol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {

    @GetMapping("/jogadores")
    public String listarJogadores() {
        return "Jogadores: Cristiano Ronaldo, Lionel Messi, Vini Jr";
    }

}