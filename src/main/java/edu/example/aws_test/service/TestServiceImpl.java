package edu.example.aws_test.service;

import edu.example.aws_test.dto.TestDTO;
import edu.example.aws_test.entity.Test;
import edu.example.aws_test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    @Override
    public TestDTO read(Long id) {
        return new TestDTO(testRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public List<TestDTO> readAll() {
        return testRepository.findAll().stream().map(TestDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TestDTO create(TestDTO testDTO) {
        try {
            Test saved = testRepository.save(testDTO.toEntity());
            return new TestDTO(saved);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Test data integrity violation");
        }
    }

    @Override
    @Transactional
    public TestDTO update(TestDTO testDTO) {
        Test test = testRepository.findById(testDTO.getId()).orElseThrow(NoSuchElementException::new);
        test.changeName(testDTO.getName());
        return new TestDTO(test);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        testRepository.findById(id).orElseThrow(NoSuchElementException::new);
        testRepository.deleteById(id);
    }
}
