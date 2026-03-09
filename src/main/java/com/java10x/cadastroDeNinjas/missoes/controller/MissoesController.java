package com.java10x.cadastroDeNinjas.missoes.controller;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesDTO;
import com.java10x.cadastroDeNinjas.missoes.model.MissoesMapper;
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
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missaoDTO){
        return missoesService.criarMissao(missaoDTO);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.alterarMissoes(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorId(id);
    }
}
