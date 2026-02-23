package com.java10x.cadastroDeNinjas.ninjas.model;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "idade")
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
