package MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String viewTodos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title, RedirectAttributes redirectAttrs) {
        if (title != null && !title.isEmpty()) {
            todoRepository.save(new Todo(title));
            redirectAttrs.addFlashAttribute("message", "Todo added successfully!");
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        todoRepository.deleteById(id);
        redirectAttrs.addFlashAttribute("message", "Todo deleted successfully!");
        return "redirect:/";
    }
}
