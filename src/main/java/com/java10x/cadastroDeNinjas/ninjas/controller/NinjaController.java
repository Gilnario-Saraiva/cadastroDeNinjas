package com.java10x.cadastroDeNinjas.ninjas.controller;

import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import com.java10x.cadastroDeNinjas.ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem-vindo a aplicação cadastro de ninjas.";
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listarID")
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