package dev.ninjas.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class NinjaController {
    private final NinjaService ninjaService;
    private NinjaMapper ninjaMapper;


    public NinjaController(NinjaService ninjaService, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
        this.ninjaMapper = ninjaMapper;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Minha primeira mensagem com spring";
    }

    @PostMapping("/criar")
    public ResponseEntity criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja: " + ninjaDTO.getNome() + " criado com sucesso");
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<NinjaDTO>> ninjaDTOS() {
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOList);
    }

    @GetMapping("/mostrarninja/{id}")
    public ResponseEntity<?> mostrarNinjaID(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok("Pronto, seu ninja:" + ninjaDTO + " foi acessado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Esse id é inválido.");
        }
    }


    @DeleteMapping("/deletar/{id}")
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
    public ResponseEntity<?> alterarNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok("Ninja atualizado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id digitado inválido");
        }
    }

}

