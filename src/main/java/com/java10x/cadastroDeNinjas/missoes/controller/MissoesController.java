package com.java10x.cadastroDeNinjas.missoes.controller;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesDTO;
import com.java10x.cadastroDeNinjas.missoes.model.MissoesMapper;
import com.java10x.cadastroDeNinjas.missoes.model.MissoesModel;
import com.java10x.cadastroDeNinjas.missoes.service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoesDTOList = missoesService.listarMissoes();
        return ResponseEntity.ok().body(missoesDTOList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.listarMissoesPorId(id);
        if (missoesDTO != null) {
            return ResponseEntity.ok().body(missoesDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada.");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missaoDTO) {
        MissoesDTO missoesDTO = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(missoesDTO);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missoesDTO = missoesService.alterarMissoes(id, missaoAtualizada);
        if (missoesDTO != null) {
            return ResponseEntity.ok().body(missoesDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.listarMissoesPorId(id);
        if (missoesDTO != null) {
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok().body("Missão deletada.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada.");
        }
    }
}
