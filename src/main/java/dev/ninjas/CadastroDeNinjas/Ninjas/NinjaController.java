package dev.ninjas.CadastroDeNinjas.Ninjas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Boas vindas ao usuário",description = "Essa rota da boas vindas ao usuário")
    public String boasVindas() {
        return "Minha primeira mensagem com spring";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo Ninja",description = "Essa rota cria um novo ninja")
    public ResponseEntity criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja: " + ninjaDTO.getNome() + " criado com sucesso");
    }


    @GetMapping("/mostrar")
    @Operation(summary = "Lista todos os Ninjas",description = "Essa rota lista todos os ninjas cadastrados até o momento")
    public ResponseEntity<List<NinjaDTO>> ninjaDTOS() {
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOList);
    }

    @GetMapping("/mostrarninja/{id}")
    @Operation(summary = "Lista o ninja por id",description = "Essa rota lista um ninja que o usuário digitar seu id")
    public ResponseEntity<?> mostrarNinjaID(
            @Parameter(description = "O usuario digita o id do ninja no caminho")
            @PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok("Pronto, seu ninja:" + ninjaDTO + " foi acessado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Esse id é inválido.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por id",description = "Essa rota deleta o ninja que o usuário digitar o id no caminho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não existente")
    })
    public ResponseEntity<String> deletarNinjaId(
            @Parameter(description = "O usuario digita o id do ninja no caminho")
            @PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não existente");
        }
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza um ninja por id",description = "Essa rota atualiza um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id digitado inválido, nao foi possível atualizar")
    })
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

