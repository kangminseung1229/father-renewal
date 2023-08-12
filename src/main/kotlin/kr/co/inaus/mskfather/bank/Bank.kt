package kr.co.inaus.mskfather.bank

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate

@Entity
class Bank(
    var basePay: Long = 0, // 기본급
    var plusPay: Long = 0, // 상여

) {
    @Id
    @GeneratedValue
    var id: Long? = null
    var memoPay: Long = 0 // 메모
    var totalPay: Long = 0
        get() = basePay + plusPay


    @CreationTimestamp
    @Column(updatable = false)
    var payDate: LocalDate? = null

    var year: String?= null

    init {
        sum()
        year = LocalDate.now().year.toString()
    }

    fun sum() {
        println("합계가 계산되었습니다.")
        totalPay = basePay + plusPay
    }
}

data class BankDto (val basePay:Long?, val plusPay: Long?, val memoPay: String?, val id: Long?)
data class BankYearDto (val year: String, val yearPay: Long)
