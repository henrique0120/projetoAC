package io.github.henrique0120.projetonsei.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.henrique0120.projetonsei.enums.CertificateType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "certificate_table")
@Data
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

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

}
