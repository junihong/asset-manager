package com.tamsil.assetmanager.domain.account

import com.tamsil.assetmanager.common.contraint.AccountType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class AccountRepositoryTest @Autowired constructor(
    val accountRepository: AccountRepository
) {

    @Test
    fun `Account Save`() {
        val account = Account(null, AccountType.LIVING, "국민", "Test Account", 12000000, "Y", "0000-0000-0000")
        val savedAccount = accountRepository.save(account)
        println(savedAccount.id)
    }

    @Test
    fun `findByAccount and result`() {
        // When
        val account = Account(null, AccountType.LIVING, "국민", "Test Account", 5000000, "T", "9999-9999-9999")
        val savedAccount = accountRepository.save(account)

        // then
        val selectedAccount = accountRepository.findByIdOrNull(savedAccount.id)
        println("Account id : ${selectedAccount?.id}, bank: ${selectedAccount?.bank}, name: ${selectedAccount?.name}")
    }
}