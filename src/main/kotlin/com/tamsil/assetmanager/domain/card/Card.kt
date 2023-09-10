package com.tamsil.assetmanager.domain.card

import com.tamsil.assetmanager.domain.BaseTimeEntity
import com.tamsil.assetmanager.domain.account.Account
import com.tamsil.assetmanager.web.dto.CardRequestDto
import com.tamsil.assetmanager.web.dto.CardResponseDto
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate

@Entity
@DynamicUpdate
class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    var account: Account?,

    var name: String,
    var company: String,
    var payDate: Int,
    var useYn: String,
    var corporationYn: String,
    var checkYn: String
): BaseTimeEntity() {

    fun addAccount(account: Account) {
        account.cards.add(this)
        this.account = account
    }

    fun toDto(): CardResponseDto {
        return CardResponseDto(
                this.id!!,
                this.name,
                this.company,
                this.payDate,
                this.useYn,
                this.corporationYn,
                this.checkYn,
                null
        )
    }

    fun update(cardRequestDto: CardRequestDto) {
        this.name = cardRequestDto.name
        this.company = cardRequestDto.company
        this.payDate = cardRequestDto.payDate
        this.useYn = cardRequestDto.useYn
        this.corporationYn = cardRequestDto.corporationYn
        this.checkYn = cardRequestDto.checkYn
    }
}