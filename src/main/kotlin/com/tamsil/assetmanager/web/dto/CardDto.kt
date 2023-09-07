package com.tamsil.assetmanager.web.dto

import com.tamsil.assetmanager.domain.card.Card

data class CardRequestDto(
    val name: String,
    val company: String,
    val payDate: Int,
    val useYn: String,
    val corporationYn: String,
    val checkYn: String,
    val accountId: Long
) {
    fun toEntity(): Card =
        Card(
            null,
            null,
            this.name,
            this.company,
            this.payDate,
            this.useYn,
            this.corporationYn,
            this.checkYn
        )
}