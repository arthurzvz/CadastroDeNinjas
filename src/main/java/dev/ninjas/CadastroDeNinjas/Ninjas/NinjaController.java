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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/mostrarNinjas/{id}")
    public NinjaModel mostrarNinjaID(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
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
