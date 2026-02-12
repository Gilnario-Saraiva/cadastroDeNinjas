package com.java10x.cadastroDeNinjas.missoes.model;

import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;
}
