package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("greeting","Sawaddee");//key คือ greeting แต่มันจะเอาvalue คำว่า Sawaddee มาใส่หน้าเว็บแทน
        return "home"; // home template (home.html)
    }
}
