package com.tamsil.assetmanager.web.dto

import com.tamsil.assetmanager.common.contraint.AccountType
import com.tamsil.assetmanager.domain.account.Account

data class AccountRequestDto(
    val accountType: AccountType,
    val bank: String,
    val name: String,
    val amount: Int,
    val useYn: String,
    val accountNumber: String
)

fun AccountRequestDto.toEntity() = Account(
    null,
    null,
    this.bank,
    this.name,
    this.amount,
    this.useYn,
    this.accountNumber
)

data class AccountResponseDto(
    val id: Long?,
    var cards: List<CardResponseDto>?,
    var accountType: AccountType?,
    val bank: String,
    val name: String,
    val amount: Int?,
    val useYn: String,
    val accountNumber: String
)