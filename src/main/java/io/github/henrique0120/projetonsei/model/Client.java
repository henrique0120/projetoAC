package io.github.henrique0120.projetonsei.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client_table")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private String email;

    @ManyToOne
    @JoinColumn(name = "agr_id", nullable = false)
    @JsonBackReference
    private AGR agr;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private List<Certificate> certificates;

}
