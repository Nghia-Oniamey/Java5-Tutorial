package code.exam.democrud2table.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }


}
