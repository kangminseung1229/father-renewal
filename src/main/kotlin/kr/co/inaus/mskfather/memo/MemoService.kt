package kr.co.inaus.mskfather.memo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
@Transactional
class MemoService(
    val memoMoneyRepository: MemoMoneyRepository
) {

    fun saveDatememo(memoMoneyDto : MemoMoneyDto) : Optional<MemoMoney> {
        val datememo : LocalDate = LocalDate.of(memoMoneyDto.year, memoMoneyDto.month, memoMoneyDto.day)

        val ass = MemoMoney()

        var targetMemoMoney = memoMoneyRepository.findById(memoMoneyDto.id)

        return targetMemoMoney

    }

    fun deleteMemoMoney(id: Long) {
        memoMoneyRepository.deleteById(id)
    }
}