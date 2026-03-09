package com.java10x.cadastroDeNinjas.missoes.model;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinja(missoesDTO.getNinja());
        return missoesModel;
    }

    public MissoesDTO map(MissoesModel model) {
        MissoesDTO dto = new MissoesDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setDificuldade(model.getDificuldade());
        dto.setNinja(model.getNinja());

        return dto;
    }
}
