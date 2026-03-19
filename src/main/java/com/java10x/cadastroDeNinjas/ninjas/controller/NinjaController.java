package com.java10x.cadastroDeNinjas.ninjas.controller;

import com.java10x.cadastroDeNinjas.ninjas.model.NinjaDTO;
import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import com.java10x.cadastroDeNinjas.ninjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Rota com mensagem de boas vidas para quem acessa.")
    public String boasVindas() {
        return "Bem-vindo a aplicação cadastro de ninjas.";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja.", description = "Rota cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {@ApiResponse (responseCode = "201", description = "Ninja criado com sucesso.")})
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com Sucesso: " + ninjaDTO.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {

        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {

        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);

        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado.");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjasPoId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado. Impossível alterar.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja Deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não eoncontrado");
        }
    }
}