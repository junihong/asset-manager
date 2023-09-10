package com.tamsil.assetmanager.domain.account

import com.tamsil.assetmanager.common.contraint.AccountType
import com.tamsil.assetmanager.domain.BaseTimeEntity
import com.tamsil.assetmanager.domain.card.Card
import com.tamsil.assetmanager.web.dto.AccountRequestDto
import com.tamsil.assetmanager.web.dto.AccountResponseDto
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate

@Entity
@DynamicUpdate
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Enumerated(value = EnumType.STRING)
    var accountType: AccountType?,
    var bank: String,
    var name: String,
    var amount: Int,
    var useYn: String,
    var accountNumber: String
) : BaseTimeEntity() {

    @OneToMany(mappedBy = "account")
    var cards: MutableList<Card> = mutableListOf()

    fun toDto(): AccountResponseDto {
        return AccountResponseDto(
                this.id,
                this.cards.map { it.toDto() },
                this.accountType,
                this.bank,
                this.name,
                this.amount,
                this.useYn,
                this.accountNumber
        )
    }

    fun update(accountRequestDto: AccountRequestDto) {
        this.accountType = accountRequestDto.accountType
        this.bank = accountRequestDto.bank
        this.name = accountRequestDto.name
        this.amount = accountRequestDto.amount
        this.useYn = accountRequestDto.useYn
        this.accountNumber = accountRequestDto.accountNumber
    }
}