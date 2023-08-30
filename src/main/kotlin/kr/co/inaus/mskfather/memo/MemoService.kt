package kr.co.inaus.mskfather.memo

import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class MemoService(
    val memoMoneyRepository: MemoMoneyRepository,
    val modelMapper: ModelMapper
) {

    fun saveDatememo(memoMoneyDto: MemoMoneyDto): MemoMoney {

        var newMemoMoney: MemoMoney = modelMapper.map(memoMoneyDto, MemoMoney::class.java)
        newMemoMoney.totalPrice = memoMoneyDto.companyPrice + memoMoneyDto.myPrice
        newMemoMoney.datememo = LocalDate.of(memoMoneyDto.year, memoMoneyDto.month, memoMoneyDto.day)

        return memoMoneyRepository.save(newMemoMoney)
    }

    fun deleteMemoMoney(id: Long) {
        memoMoneyRepository.deleteById(id)
    }
}