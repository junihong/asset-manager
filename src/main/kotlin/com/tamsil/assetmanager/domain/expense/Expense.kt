package com.tamsil.assetmanager.domain.expense

import com.tamsil.assetmanager.domain.BaseTimeEntity
import com.tamsil.assetmanager.domain.payment.Payment
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    val id: Long,

    val name: String,
    val place: String,
    val cost: Int,
    var description: String,
    val expenseDate: LocalDate,
    var isInstallments: String,
    var categoryId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    var payment: Payment?
): BaseTimeEntity() {

}