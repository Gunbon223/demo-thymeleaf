package org.gb.demothymeleaf.Controller;

import org.gb.demothymeleaf.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private List<User> users = new ArrayList<>(
            List.of(
                    new User(1,"John",21,true),
                    new User(2,"Jane",22,false),
                    new User(3,"Doe",23,true),
                    new User(4,"zoe",27,false),
                    new User(5,"Voe",26,false),
                    new User(6,"Aoe",24,true)
            )
    );

    @GetMapping("/users/{id}")
    public String getUserPage(Model model, @PathVariable("id") int id) {
        User user = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("user", user);
        return "user-detail";
    }

    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(required = false) Boolean status ) {
        List<User> usersList;
        if (status == null) {
            usersList = this.users;
        } else {
            usersList = this.users.stream()
                    .filter(u -> u.isStatus() == status)
                    .toList();
        }


        model.addAttribute("user", users.get(0));
        model.addAttribute("users", usersList);
        return "index";
    }

    @GetMapping("/blog")
    public String getAdminBlogPage() {
        return "admin/blog";
    }


}
