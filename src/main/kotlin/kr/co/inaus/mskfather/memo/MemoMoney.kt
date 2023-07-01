package kr.co.inaus.mskfather.memo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class MemoMoney(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var year: Int,
    var month: Int,
    var datememo: LocalDate,
    var companyPrice: Long,
    var myPrice: Long,
    var totalPrice: Long

) {
}

data class MemoMoneyDto(val id: Long, val year: Int, val month: Int, val day: Int, val companyPrice: Int, val myPrice: Int )