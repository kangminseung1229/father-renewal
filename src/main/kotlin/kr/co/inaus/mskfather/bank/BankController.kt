package kr.co.inaus.mskfather.bank

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/bank")
class BankController(
    val bankRepository: BankRepository
) {

    @GetMapping("/list")
    fun list(model: Model, @RequestParam(required = false) id: Long?): String {


        id?.let { nonNullId ->
            bankRepository.findById(nonNullId).ifPresent { bank ->
                model.addAttribute("targetBank", bank)
            }
        }

        val bankList: List<Bank> = bankRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
        model.addAttribute("bankList", bankList)

        return "html/bank-list"
    }
}