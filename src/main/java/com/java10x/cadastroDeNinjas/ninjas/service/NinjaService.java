package com.java10x.cadastroDeNinjas.ninjas.service;

import com.java10x.cadastroDeNinjas.ninjas.model.NinjaModel;
import com.java10x.cadastroDeNinjas.ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorId(Long id){
        return ninjaRepository.findById(id).orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){return ninjaRepository.save(ninja);}
}
