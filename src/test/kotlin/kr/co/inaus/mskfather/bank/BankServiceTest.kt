package kr.co.inaus.mskfather.bank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class BankServiceTest
{

    @Autowired
    lateinit var bankRepository: BankRepository

    @Test
    @DisplayName("월 컬럼 값 채우기")
    @Transactional
    @Rollback(false)
    fun monthValue(){

         bankRepository.findAll().stream().forEach { bank ->

             bank.year = bank.payDate?.year.toString();
             bank.month = bank.payDate?.monthValue.toString();

             println("변경값 : ${bank.month}")
         }

//        bankRepository.flush() // flush()를 사용하면 명시적으로 변경 사항이 데이터베이스에 반영됩니다.
    }
}