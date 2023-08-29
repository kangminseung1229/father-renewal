package kr.co.inaus.mskfather.memo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import java.time.LocalDate

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = ["id"])
class MemoMoney(

    @Id
    @GeneratedValue
    var id: Long = 0,
    var year: Int = 0,
    var month: Int = 0,
    var datememo: LocalDate = LocalDate.now(), // 기록 시간
    var companyPrice: Long = 0, // 매출
    var myPrice: Long = 0, // 입금
    var totalPrice: Long = 0 // 합계

){
}
data class MemoMoneyDto(val id: Long, val year: Int, val month: Int, val day: Int, val companyPrice: Long, val myPrice: Long )