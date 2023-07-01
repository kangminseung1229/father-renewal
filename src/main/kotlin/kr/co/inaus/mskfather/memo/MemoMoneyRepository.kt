package kr.co.inaus.mskfather.memo

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.Optional

interface MemoMoneyRepository : JpaRepository<MemoMoney, Long>{


    fun findByDatememo(datememo : LocalDate) : Optional<MemoMoney>
}