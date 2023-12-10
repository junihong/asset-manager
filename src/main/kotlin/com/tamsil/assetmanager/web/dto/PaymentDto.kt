package com.tamsil.assetmanager.web.dto

data class PaymentRequestDto(
        val paymentCode: String,
        val name: String,
        var description: String
)

data class PaymentResponseDto(
        val id: Long,
        val paymentCode: String,
        val name: String,
        var description: String
)