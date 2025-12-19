package dev.ninjas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setNinja(missoesDTO.getNinja());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        return missoesModel;
    }
    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesDTO.getNome());
        missoesDTO.setNinja(missoesModel.getNinja());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        return missoesDTO;
    }
}
