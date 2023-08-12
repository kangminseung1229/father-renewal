package kr.co.inaus.mskfather.bank

import org.modelmapper.ModelMapper
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/bank")
class BankController(
    val bankRepository: BankRepository,
    val bankService: BankService,
    val modelMapper: ModelMapper
) {

    @GetMapping("/list")
    fun list(model: Model, @RequestParam(required = false) id: Long?): String {


        id?.let { nonNullId ->
            bankRepository.findById(nonNullId).ifPresent { bank ->
                model.addAttribute("bankDto", modelMapper.map(bank, BankDto::class.java))
            }
        } ?: run {
            model.addAttribute("bankDto", BankDto(null, null, null, null))
        }

        val bankList: List<Bank> = bankRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
        model.addAttribute("bankList", bankList)

        return "html/bank-list"
    }

//    @PostMapping("/insert")
//    fun dataInsert(@RequestParam(required = false, defaultValue = "0") basicPay: String, @RequestParam(required = false, defaultValue = "0") plusPay: String,
//                   @RequestParam(required = false, defaultValue = "0") memoPay: String,
//                   @RequestParam(required = false) id: Long): String{
//    }

    @PostMapping("/insert")
    fun dataInsert(bankDto: BankDto): String {
        // modelmapper 는 init 이 동작하지 않으므로 sum 을 별도 동작해야한다.
        var bank: Bank = modelMapper.map(bankDto, Bank::class.java)

        bankService.insertBank(bank)

        return "redirect:/bank/list"
    }


    @GetMapping("/year-list")
    fun yearList(model: Model) : String{

        //TODO: 연간매출구하기
         model.addAttribute("yearList",bankRepository.findYearGroup())

        //TODO: 삭제기능 구하기


        return "html/year-list"

    }


}