package com.tamsil.assetmanager.domain.account

import com.tamsil.assetmanager.common.contraint.AccountType
import com.tamsil.assetmanager.domain.BaseTimeEntity
import com.tamsil.assetmanager.domain.card.Card
import jakarta.persistence.*

@Entity
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Enumerated(value = EnumType.STRING)
    val accountType: AccountType? = null,
    var bank: String,
    var name: String,
    var amount: Int,
    var useYn: String,
    var accountNumber: String
) : BaseTimeEntity() {

    @OneToMany(mappedBy = "account")
    var cards: MutableList<Card> = mutableListOf()
}