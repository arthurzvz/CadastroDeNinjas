package dev.ninjas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
            MissoesModel missao = missoesMapper.map(missoesDTO); //DTO convertido para Model
            missoesRepository.save(missao);
            return missoesMapper.map(missao); //Model convertido para DTO
    }

}
