package io.github.henrique0120.projetonsei.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ECNPJ_table")
public class ECNPJ extends Certificate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 11)
    private String cnpj;

    public ECNPJ(String token, String password) {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
