package edu.example.aws_test.controller;

import edu.example.aws_test.dto.TestDTO;
import edu.example.aws_test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping
    public String testsPage(Model model) {
        model.addAttribute("tests", testService.readAll());
        return "index";
    }

    @GetMapping("test/create")
    public String newTestPage() {
        return "new-test";
    }

    @PostMapping("/tests")
    public String createTest(@Validated TestDTO testDTO) {
        testService.create(testDTO);
        return "redirect:/";
    }

    @GetMapping("test/update/{id}")
    public String modifyTestPage(@PathVariable Long id, Model model) {
        model.addAttribute("test", testService.read(id));
        return "modify-test";
    }

    @PostMapping("/tests/update")
    public String updateTest(@Validated @ModelAttribute TestDTO testDTO) {
        testService.update(testDTO);
        return "redirect:/";
    }

    @GetMapping("test/delete/{id}")
    public String deleteTest(@PathVariable Long id) {
        testService.delete(id);
        return "redirect:/";
    }
}
