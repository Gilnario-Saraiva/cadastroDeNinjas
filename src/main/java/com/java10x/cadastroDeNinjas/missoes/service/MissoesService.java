package com.java10x.cadastroDeNinjas.missoes.service;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesModel;
import com.java10x.cadastroDeNinjas.missoes.repository.MissoesRepository;
import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissoesPorId(Long id){return missoesRepository.findById(id).orElse(null);}

    public MissoesModel criarMissao(MissoesModel missoes){return missoesRepository.save(missoes);}

    public void deletarMissoesPorId(Long id) {missoesRepository.deleteById(id);}

    public MissoesModel alterarMissoes(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }
}
