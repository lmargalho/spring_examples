package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @GetMapping("/greeting/{name}")
    public String greeting(
            @PathVariable("name") String name,
            @RequestParam(name = "val", defaultValue = "!!?") String val,
            Model model) {
        model.addAttribute("userInfo", new User(name + val));
        return "greeting";
    }

    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
