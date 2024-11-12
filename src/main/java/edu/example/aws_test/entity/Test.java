package edu.example.aws_test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public void changeName(String name) {
        this.name = name;
    }
}
