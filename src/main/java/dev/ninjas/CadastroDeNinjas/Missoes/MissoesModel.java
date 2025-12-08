package dev.ninjas.CadastroDeNinjas.Missoes;

import dev.ninjas.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    @Column(name = "ninja")
    private List<NinjaModel> ninja;

}
