package com.java10x.cadastroDeNinjas.ninjas.model;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoes;
    private String rank;
}