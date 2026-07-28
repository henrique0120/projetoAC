package io.github.henrique0120.projetonsei.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Data
@ToString(exclude = {"certificates"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agr_id", nullable = false)
    @JsonBackReference
    private AGR agr;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    //@Transient
    @JsonManagedReference
    private List<Certificate> certificates;

}
