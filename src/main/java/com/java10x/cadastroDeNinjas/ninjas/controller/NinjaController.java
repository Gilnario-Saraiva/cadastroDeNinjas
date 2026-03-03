package com.java10x.cadastroDeNinjas.ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem-vindo a aplicação cadastro de ninjas.";
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Todos os ninjas";
    }

    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPoId(){
        return "Ninja por id";
    }

    @PutMapping("/alterarID")
    public String alterarNinjasPoId(){
        return "alterarNinjasPoId";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }
}