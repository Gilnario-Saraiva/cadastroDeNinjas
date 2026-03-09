package com.java10x.cadastroDeNinjas.missoes.model;

import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninja;
}
