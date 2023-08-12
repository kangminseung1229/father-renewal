package kr.co.inaus.mskfather.bank

import org.springframework.data.jpa.repository.JpaRepository

interface BankRepository: JpaRepository<Bank, Long>, BankRepositoryExtention {
}