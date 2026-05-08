package io.github.henrique0120.projetonsei.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.henrique0120.projetonsei.enums.CertificateType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "certificate_table")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(length = 11)
    private String token;

    @Column(length = 50)
    private String password;

    @CreationTimestamp
    private Date date;

    @Column(nullable = false)
    @Enumerated
    private CertificateType type;

//    @ManyToOne
//    @JoinColumn(name = "agr_id", nullable = false)
//    private AGR agr;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;

    public Certificate(){}

    public Certificate(String token, String password, CertificateType type) {
        this.type = type;
        this.token = token;
        this.password = password;
    }

    public CertificateType getType() {
        return type;
    }

    public void setType(CertificateType type) {
        this.type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

//    public AGR getAgr() {
//        return agr;
//    }
//
//    public void setAgr(AGR agr) {
//        this.agr = agr;
//    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //    public CertificateStatus emitirCertificado(ECNPJ ecnpj){
//        if (agr == null){
//            return new CertificateStatus("O certificado precisa ter vínculo com uma AGR");
//        } else{
//            return new CertificateStatus("Certificado emitido com sucesso!");
//        }
//    }

}
