package kr.co.inaus.mskfather.memo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface MemoMoneyRepository : JpaRepository<MemoMoney, Long>{


    fun findByDatememo(datememo : LocalDate): MemoMoney?

    // 납입금 월별 합계
    @Query(value = "SELECT sum(company_price) FROM memo_money where year = :year AND month = :month ;", nativeQuery = true)
    fun sumCompanyPrice(year: Int, month: Int): Long?

    // 소득 월별 합계
    @Query(value = "SELECT sum(my_price) FROM memo_money where year = :year AND month = :month ;", nativeQuery = true)
    fun sumMyPrice(year: Int, month: Int): Long?

    // 리스트
    fun findByYearAndMonthOrderByDatememo(year: Int, month: Int): List<MemoMoney>

}