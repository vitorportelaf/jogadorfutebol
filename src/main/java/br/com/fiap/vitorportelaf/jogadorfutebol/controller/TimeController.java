package br.com.fiap.vitorportelaf.jogadorfutebol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @GetMapping("/times") 
    public String listarTimes() {
        return "Times disponíveis: Real Madrid, Barcelona, Manchester United";
    }

    @GetMapping("/times/destaque")
    public String timeDestaque() {
        return "Time destaque da temporada: Real Madrid";
    }

}