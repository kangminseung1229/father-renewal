package kr.co.inaus.mskfather.bank

interface BankRepositoryExtention {
    fun findYearGroup(): List<BankYearDto>
}