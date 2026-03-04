package com.java10x.cadastroDeNinjas.missoes.controller;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesModel;
import com.java10x.cadastroDeNinjas.missoes.service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {return missoesService.listarMissoesPorId(id);}

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
