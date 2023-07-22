package kr.co.inaus.mskfather.bank

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class BankService (
    val bankRepository: BankRepository
){
    fun insertBank(bank: Bank) {
        bank.sum()
        bankRepository.save(bank)
    }
}