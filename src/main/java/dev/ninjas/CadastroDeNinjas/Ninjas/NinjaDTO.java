package dev.ninjas.CadastroDeNinjas.Ninjas;
import dev.ninjas.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String cla;
    private String email;
    private MissoesModel missoes;
    private String rank;
}
