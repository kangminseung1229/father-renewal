package kr.co.inaus.mskfather.bank

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface BankRepository: JpaRepository<Bank, Long>, BankRepositoryExtention {

    fun findFirstByYearAndMonth(year: String?, month: String?): Optional<Bank>

    fun findAllByOrderByYearDescMonthDesc(): List<Bank>
}