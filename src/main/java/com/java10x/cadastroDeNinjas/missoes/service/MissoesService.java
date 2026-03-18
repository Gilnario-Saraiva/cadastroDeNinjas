package com.java10x.cadastroDeNinjas.missoes.service;

import com.java10x.cadastroDeNinjas.missoes.model.MissoesDTO;
import com.java10x.cadastroDeNinjas.missoes.model.MissoesMapper;
import com.java10x.cadastroDeNinjas.missoes.model.MissoesModel;
import com.java10x.cadastroDeNinjas.missoes.repository.MissoesRepository;
import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){

        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public void deletarMissoesPorId(Long id) {missoesRepository.deleteById(id);}

    public MissoesDTO alterarMissoes(Long id, MissoesDTO missaoDTO){
       Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

       if(missoesModel.isPresent()){
           MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
           missaoAtualizada.setId(id);
           MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
           return missoesMapper.map(missaoSalva);
       }
       return null;
    }
}
