package model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Animal")
public class Animal {
    private short id;
    private String nome;
    private byte[] imagem;
    private byte[] som;
    private short dificuldade;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "imagem")
    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @Basic
    @Column(name = "som")
    public byte[] getSom() {
        return som;
    }

    public void setSom(byte[] som) {
        this.som = som;
    }

    @Basic
    @Column(name = "dificuldade")
    public short getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(short dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        if (dificuldade != animal.dificuldade) return false;
        if (nome != null ? !nome.equals(animal.nome) : animal.nome != null) return false;
        if (!Arrays.equals(imagem, animal.imagem)) return false;
        if (!Arrays.equals(som, animal.som)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(imagem);
        result = 31 * result + Arrays.hashCode(som);
        result = 31 * result + (int) dificuldade;
        return result;
    }
}
