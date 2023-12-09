package com.tamsil.assetmanager.domain.payment

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Payment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    val id: Long,

    val paymentCode: String,
    val name: String,
    var description: String
) {
}