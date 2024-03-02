package kr.co.inaus.mskfather.bank

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory


class BankRepositoryExtentionImpl(
    val jpaQueryFactory: JPAQueryFactory,
    val bank: QBank = QBank.bank
) : BankRepositoryExtention {
    override fun findYearGroup(): List<BankYearDto> {

        return jpaQueryFactory
            .select(
                Projections.constructor(
                    BankYearDto::class.java,
                    bank.year,
                    bank.totalPay.sum()
                )
            )
            .from(bank)
            .groupBy(bank.year)
            .fetch()
    }
}