package dev.ninjas.CadastroDeNinjas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String nome;
    private String cla;
    private String rank;
    private String tecnicas;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String cla, String rank, String tecnicas) {
        this.nome = nome;
        this.cla = cla;
        this.rank = rank;
        this.tecnicas = tecnicas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(String tecnicas) {
        this.tecnicas = tecnicas;
    }
}
