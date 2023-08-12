package kr.co.inaus.mskfather.memo

import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@Controller
@RequestMapping("/memo")
class MemoController(
    val memoMoneyRepository: MemoMoneyRepository,
    val modelMapper: ModelMapper,
    val memoService: MemoService
) {

    @GetMapping("list")
    fun list(
        model: Model,
        @RequestParam(defaultValue = "0") year: Int,
        @RequestParam(defaultValue = "0") month: Int
    ): String {

        // TODO: 기본 오늘 날짜로 쿼리 조회하기

        var currentYear: Int = year
        var currentMonth: Int = month
        val now: LocalDate = LocalDate.now()

        if (currentYear.equals(0) || currentYear == 0) currentYear = now.year
        if (currentMonth.equals(0) || currentMonth == 0) currentMonth = now.monthValue

        var memoMoney: MemoMoney? = memoMoneyRepository.findByDatememo(now)

        val sumMyPrice: Long? = memoMoneyRepository.sumMyPrice(currentYear, currentMonth) ?: 0L
        val sumCompanyPrice: Long? = memoMoneyRepository.sumCompanyPrice(currentYear, currentMonth) ?: 0L

        val memoMoneyList: List<MemoMoney> =
            memoMoneyRepository.findByYearAndMonthOrderByDatememo(currentYear, currentMonth)

        model.addAttribute("list", memoMoneyList)
        model.addAttribute("sumCompanyPrice", sumCompanyPrice)
        model.addAttribute("sumMyPrice", sumMyPrice)
        model.addAttribute("year", currentYear)
        model.addAttribute("month", currentMonth)

        return "html/list"
    }

    @GetMapping("/write")
    fun write(
        model: Model,
        @RequestParam(defaultValue = "0") year: Int,
        @RequestParam(defaultValue = "0") month: Int,
        @RequestParam(defaultValue = "0") day: Int
    ): String {

        val now = LocalDate.now()

        var currentYear: Int = year
        var currentMonth: Int = month
        var currentDay: Int = day

        if (year == 0) currentYear = now.year
        if (month == 0) currentMonth = now.monthValue
        if (day == 0) currentDay = now.dayOfMonth

        var targetDate = LocalDate.of(currentYear, currentMonth, currentDay)

        var memoMoney: MemoMoney? = memoMoneyRepository.findByDatememo(targetDate)

        if (memoMoney != null) {
            model.addAttribute("id", memoMoney.id)
            model.addAttribute("companyPrice", memoMoney.companyPrice)
            model.addAttribute("myPrice", memoMoney.myPrice)

        }
        model.addAttribute("year", currentYear)
        model.addAttribute("month", currentMonth)
        model.addAttribute("day", currentDay)

        return "html/write"
    }

    @PostMapping("/companyprice-write")
    fun companyPriceSave(@RequestBody memoMoneyDto: MemoMoneyDto): ResponseEntity<MemoMoney> {

        var newMemoMoney: MemoMoney = modelMapper.map(memoMoneyDto, MemoMoney::class.java)

        newMemoMoney.totalPrice = memoMoneyDto.companyPrice + memoMoneyDto.myPrice
        newMemoMoney.datememo = LocalDate.now()

        return ResponseEntity.ok().body(memoMoneyRepository.save(newMemoMoney))
    }

    @PostMapping("/delete")
    @ResponseBody
    fun deleteMemo(@RequestParam id: Long): ResponseEntity<String> {

        if (id != null) memoService.deleteMemoMoney(id)

        return ResponseEntity.ok().body("ok")
    }


}