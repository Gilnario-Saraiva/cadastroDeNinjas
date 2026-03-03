package com.java10x.cadastroDeNinjas.missoes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas.";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso.";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão Alterada.";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada.";
    }
}
