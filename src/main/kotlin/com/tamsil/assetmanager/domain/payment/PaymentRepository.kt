package com.tamsil.assetmanager.domain.payment

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository: JpaRepository<Payment, Long> {
}