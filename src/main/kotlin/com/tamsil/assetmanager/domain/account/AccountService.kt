package com.tamsil.assetmanager.domain.account

import com.tamsil.assetmanager.web.dto.AccountRequestDto
import com.tamsil.assetmanager.web.dto.AccountResponseDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {

    private val log = LoggerFactory.getLogger(AccountService::class.java)

    fun create(accountRequestDto: AccountRequestDto): AccountResponseDto {
        val account = accountRequestDto.toEntity()
        val savedAccount = accountRepository.save(account)
        log.info("savedAccount : {}, bank: {}", savedAccount.id, savedAccount.bank)
        return AccountResponseDto(savedAccount.id, null,
            savedAccount.accountType, savedAccount.bank,
            savedAccount.name, savedAccount.amount,
            savedAccount.useYn, savedAccount.accountNumber)
    }
}