package dev.ninjas.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Minha primeira mensagem com spring";
    }
    @PostMapping("/criar")
    public String criarNinja(){
        return "Criar ninja";
    }
    @GetMapping("/mostrar")
    public String mostrarNinjaID(){
        return "mostrar ninja";
    }
    @GetMapping("/mostrarNinjas")
    public List<NinjaModel> mostrarTodosNinjas(){
        return ninjaService.listarNinjas();
    }


    @GetMapping("/mostrarNinja")
    public String mostrarTodosNinja(){
        return "Mostrar todos ninja";
    }
    @PutMapping("/alterarNinjaId")
    public String alterarNinjaId(){
        return "alterar id do Ninja";
    }
    @DeleteMapping("/deletarrNinjaId")
    public String deletarNinjaId(){
        return "Deletar Ninja por id";
    }
}
