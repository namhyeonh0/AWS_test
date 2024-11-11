package edu.example.aws_test.controller;

import edu.example.aws_test.dto.TestDTO;
import edu.example.aws_test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestRestController {
    private final TestService testService;

    @GetMapping("/{id}")
    ResponseEntity<TestDTO> getTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testService.read(id));
    }

    @GetMapping
    ResponseEntity<List<TestDTO>> getTests() {
        return ResponseEntity.ok(testService.readAll());
    }

    @PostMapping
    ResponseEntity<TestDTO> createTest(@Validated @RequestBody TestDTO testDTO) {
        return ResponseEntity.ok(testService.create(testDTO));
    }

    @PutMapping("/{id}")
    ResponseEntity<TestDTO> updateTest(@PathVariable("id") Long id, @Validated @RequestBody TestDTO testDTO) {
        testDTO.setId(id);
        return ResponseEntity.ok(testService.update(testDTO));
    }

    @DeleteMapping("/{id}")
    void deleteTest(@PathVariable("id") Long id) {
        testService.delete(id);
    }
}
