package dev.ninjas.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {
    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criarmissao")
    public ResponseEntity<?> criarMissao(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missao = missoesService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao cadastrada com sucesso"+missao);
    }
    @GetMapping("/listarmissao")
    public ResponseEntity<?> listarMissao(){
        return null;
    }

}
