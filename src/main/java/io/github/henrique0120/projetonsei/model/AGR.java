package io.github.henrique0120.projetonsei.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AGR_table")
public class AGR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @OneToMany(mappedBy = "agr")
    private List<Certificate> certificates;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
