package io.github.henrique0120.projetonsei.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.github.henrique0120.projetonsei.enums.CertificateType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "certificate_table")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticket;

    @Column(length = 50)
    private String password;

    @CreatedDate
    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private CertificateType type;

//    @ManyToOne
//    @JoinColumn(name = "agr_id", nullable = false)
//    private AGR agr;

    @ManyToOne(fetch = FetchType.LAZY)
    @Transient
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;

    public void calcValidade(){
        System.out.println(this.getDataEmissao().getYear() + 1);
    }
}
