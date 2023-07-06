package kr.co.inaus.mskfather.memo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import java.time.LocalDate

@Entity
@EqualsAndHashCode(of = ["id"])
class MemoMoney(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var year: Int = 0,
    var month: Int = 0,
    var datememo: LocalDate = LocalDate.now(),
    var companyPrice: Long = 0,
    var myPrice: Long = 0,
    var totalPrice: Long = 0

){
}
data class MemoMoneyDto(val id: Long, val year: Int, val month: Int, val day: Int, val companyPrice: Int, val myPrice: Int )