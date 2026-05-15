package io.github.henrique0120.projetonsei.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "AGR_table")
@Data
public class AGR {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    //@OneToMany(mappedBy = "agr")
    @Transient
    @JsonManagedReference
    private List<Client> clients;

}
