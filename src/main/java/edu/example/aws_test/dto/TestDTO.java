package edu.example.aws_test.dto;

import edu.example.aws_test.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDTO {
    private Long id;

    private String name;

    public TestDTO(Test test) {
        this.id = test.getId();
        this.name = test.getName();
    }

    public Test toEntity() {
        return Test.builder().id(id).name(name).build();
    }
}
