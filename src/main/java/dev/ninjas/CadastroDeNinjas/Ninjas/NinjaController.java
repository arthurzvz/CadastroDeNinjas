package dev.ninjas.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<String> deletarNinjaId(@PathVariable Long id) {
    if (ninjaService.listarNinjaPorId(id) != null) {
        ninjaService.deleteNinja(id);
        return ResponseEntity.ok("Ninja deletado com sucesso");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Ninja não existente");
    }
}
    @PutMapping("/atualizar/{id}")
    public NinjaDTO alterarNinjaId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

}

