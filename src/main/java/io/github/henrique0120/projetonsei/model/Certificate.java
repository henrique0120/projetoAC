package io.github.henrique0120.projetonsei.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "certificate_table")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 11)
    private String token;

    @Column(length = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "agr_id")
    private AGR agr;

    public Certificate(String token, String password) {
        this.token = token;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AGR getAgr() {
        return agr;
    }

    public void setAgr(AGR agr) {
        this.agr = agr;
    }
}
