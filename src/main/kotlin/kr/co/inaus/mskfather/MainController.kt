package kr.co.inaus.mskfather

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class MainController {


    @GetMapping("/")
    fun index() : String {
        return "redirect:/memo/write"
    }
}