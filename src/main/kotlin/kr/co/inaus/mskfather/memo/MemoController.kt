package kr.co.inaus.mskfather.memo

import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Controller
@RequestMapping("/memo")
class MemoController (
    val memoMoneyRepository: MemoMoneyRepository,
    val modelMapper: ModelMapper
)
{

    //TODO: log 객체 찾기

    @GetMapping("/write")
    fun write(model : Model, @RequestParam(defaultValue = "0") year : Int, @RequestParam(defaultValue = "0") month : Int, @RequestParam(defaultValue = "0") day : Int): String {

        val now = LocalDate.now()

        var currentYear : Int = year
        var currentMonth : Int = month
        var currentDay : Int = day

        if (year == 0) currentYear = now.year
        if (month == 0) currentMonth = now.monthValue
        if (day == 0) currentDay = now.dayOfMonth

        var targetDate = LocalDate.of(currentYear, currentMonth, currentDay)

        var memoMoney = memoMoneyRepository.findByDatememo(targetDate)

        if (memoMoney.isPresent){
            var target = memoMoney.get()

            model.addAttribute("id", target.id)
            model.addAttribute("companyPrice", target.companyPrice)
            model.addAttribute("myPrice", target.myPrice)

        }
        model.addAttribute("year", currentYear)
        model.addAttribute("month", currentMonth)
        model.addAttribute("day", currentDay)

        return "html/write"
    }

    @PostMapping("/companyprice-write")
    fun companyPriceSave(@RequestBody memoMoneyDto: MemoMoneyDto) : ResponseEntity<MemoMoney> {

        var newMemoMoney : MemoMoney = modelMapper.map(memoMoneyDto, MemoMoney::class.java)

        newMemoMoney.totalPrice = memoMoneyDto.companyPrice + memoMoneyDto.myPrice
        newMemoMoney.datememo = LocalDate.now()

        return ResponseEntity.ok().body(memoMoneyRepository.save(newMemoMoney))
    }


    @GetMapping("/list")
    fun list (model : Model, @RequestParam(defaultValue = "0") year : Int, @RequestParam(defaultValue = "0") month : Int){
//
//        val now = LocalDate.now()
//
//        var currentYear : Int
//        var currentMonth : Int
//
//        if (year == 0) currentYear = now.year
//        if (month == 0) currentYear = now.monthValue



    }


}