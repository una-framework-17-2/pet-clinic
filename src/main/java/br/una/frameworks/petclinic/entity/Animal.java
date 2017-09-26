package br.una.frameworks.petclinic.entity;

import br.una.frameworks.petclinic.enumerator.Sexo;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Min(value = 3, message = "Precisa de pelo menos 3 dígitos")
    private String nome;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Sexo é um campo obrigatório")
    private Sexo sexo;
    private String vacina = "";
    @NotNull
    @NotBlank(message = "Espécie é um campo obrigatório")
    private String especie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
