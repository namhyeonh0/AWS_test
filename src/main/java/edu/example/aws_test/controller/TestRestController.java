package edu.example.aws_test.controller;

import edu.example.aws_test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestRestController {
    private final TestService testService;
}
