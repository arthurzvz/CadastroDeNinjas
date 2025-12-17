package dev.ninjas.CadastroDeNinjas.Ninjas;

import dev.ninjas.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "clã")
    private String cla;
    @Column(unique = true,name = "email")
    private String email;
    private String rank;

    @ManyToOne()
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
