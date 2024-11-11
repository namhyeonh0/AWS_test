package edu.example.aws_test.service;

import edu.example.aws_test.dto.TestDTO;

import java.util.List;

public interface TestService {
    TestDTO read(Long id);
    List<TestDTO> readAll();
    TestDTO create(TestDTO testDTO);
    TestDTO update(TestDTO testDTO);
    void delete(Long id);
}
