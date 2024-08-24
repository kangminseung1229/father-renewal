package kr.co.inaus.mskfather.bank

import kr.co.inaus.mskfather.bank.QBank.bank
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.Optional


@Service
@Transactional
class BankService (
    val bankRepository: BankRepository,
    val modelMapper: ModelMapper
){
    fun insertBank(bankDto : BankDto) {

        val dataopt : Optional<Bank> = bankRepository.findFirstByYearAndMonth(bankDto.year, bankDto.month)

        if(dataopt.isPresent){

            val data = dataopt.get()
            data.basePay = bankDto.basePay ?: 0L
            data.plusPay = bankDto.plusPay ?: 0L
            data.memoPay = bankDto.memoPay ?: 0L

            data.sum()

        } else {
            var newData : Bank = modelMapper.map(bankDto, Bank::class.java)
            bankRepository.save(newData)
        }
    }
}