package io.github.henrique0120.projetonsei.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ECPF_table")
public class ECPF extends Certificate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 11)
    private String cpf;

    public ECPF(String token, String password) {
        super(token, password);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
