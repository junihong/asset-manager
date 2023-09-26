package com.tamsil.assetmanager.domain.account

import com.tamsil.assetmanager.common.contraint.AccountType
import com.tamsil.assetmanager.web.dto.AccountRequestDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccountServiceTest @Autowired constructor(val accountService: AccountService) {

    @Test
    fun `Create Account Test`() {
        val accountRequestDto = getAccountRequestDto()
        val savedAccount = accountService.create(accountRequestDto)
        println("accountId: ${savedAccount.id}, bank: ${savedAccount.bank}," +
                " name: ${savedAccount.name}, amount: ${savedAccount.amount}")
    }

    @Test
    fun `Update Account Test`() {
        val accountRequestDto = getAccountRequestDto()
        val savedAccount = accountService.create(accountRequestDto)
        println("create accountId: ${savedAccount.id}, bank: ${savedAccount.bank}," +
                " name: ${savedAccount.name}, amount: ${savedAccount.amount}," +
                " accountNumber : ${savedAccount.accountNumber}")

        val updateAccountRequestDto = AccountRequestDto(AccountType.LIVING, "KB", "Test2 Account", 5000000, "", "")
        val updatedAccount = accountService.update(1, updateAccountRequestDto)

        println("update accountId: ${updatedAccount.id}, bank: ${updatedAccount.bank}," +
                " name: ${updatedAccount.name}, amount: ${updatedAccount.amount}," +
                " accountNumber: ${updateAccountRequestDto.accountNumber}")
    }

    private fun getAccountRequestDto(): AccountRequestDto {
        val accountRequestDto = AccountRequestDto(
                AccountType.LIVING,
                "Woorie",
                "Test Account",
                10000000,
                "Y",
                "0000-0000-0000")
        return accountRequestDto
    }
}