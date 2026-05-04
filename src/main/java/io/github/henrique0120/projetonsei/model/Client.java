package io.github.henrique0120.projetonsei.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Entity
@Table(name = "client_table")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private String email;

    @ManyToOne
    @JoinColumn(name = "agr_id", nullable = false)
    private AGR agr;

    @OneToMany(mappedBy = "client")
    private List<Certificate> certificates;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public AGR getAgr() {
        return agr;
    }

    public void setAgr(AGR agr) {
        this.agr = agr;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
