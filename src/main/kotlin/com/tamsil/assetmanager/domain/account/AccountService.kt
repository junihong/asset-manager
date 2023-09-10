package com.tamsil.assetmanager.domain.account

import com.tamsil.assetmanager.web.dto.AccountRequestDto
import com.tamsil.assetmanager.web.dto.AccountResponseDto
import com.tamsil.assetmanager.web.dto.CardResponseDto
import com.tamsil.assetmanager.web.dto.toEntity
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
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

    fun update(id: Long, accountRequestDto: AccountRequestDto): AccountResponseDto {
        val account = accountRepository.findByIdOrNull(id)
        account?.accountType ?: accountRequestDto.accountType
        account?.bank ?: accountRequestDto.bank
        account?.name ?: accountRequestDto.name
        account?.amount ?: accountRequestDto.amount
        account?.useYn ?: accountRequestDto.useYn
        account?.accountNumber ?: accountRequestDto.accountNumber
        return AccountResponseDto(
            account?.id,
            null,
            account?.accountType,
            account!!.bank,
            account.name,
            account.amount,
            account.useYn,
            account.accountNumber
        )
    }

    fun delete(id: Long) = accountRepository.deleteById(id)

    fun findById(id: Long): AccountResponseDto {
        val account = accountRepository.findByIdOrNull(id)
        val cardResponseDtoList: List<CardResponseDto>? = account?.cards?.map {
            CardResponseDto(it.id!!, it.name, it.company, it.payDate, it.useYn, it.corporationYn, it.checkYn, null)
        }
        return AccountResponseDto(
            account!!.id,
            cardResponseDtoList,
            account.accountType,
            account.bank,
            account.name,
            account.amount,
            account.useYn,
            account.accountNumber
        )
    }
}