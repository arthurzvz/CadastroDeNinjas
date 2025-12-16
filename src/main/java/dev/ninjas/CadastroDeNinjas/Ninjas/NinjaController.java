package dev.ninjas.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {
    private NinjaService ninjaService;
    private NinjaMapper ninjaMapper;


    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Minha primeira mensagem com spring";
    }

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/mostrar")
    public List<NinjaDTO> ninjaDTOS(){
        return ninjaService.listarNinjas();
    }

@GetMapping("/mostrarNinjas/{id}")
public NinjaDTO mostrarNinjaID(@PathVariable Long id){
    return ninjaService.listarNinjaPorId(id);
}


@DeleteMapping("/deletarrNinjaId/{id}")
public void deletarNinjaId(@PathVariable Long id){
    ninjaService.deleteNinja(id);
}
    @PutMapping("/atualizar/{id}")
    public NinjaDTO alterarNinjaId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

}

