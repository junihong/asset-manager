package com.tamsil.assetmanager.web.dto

import com.tamsil.assetmanager.domain.expense.Expense
import java.time.LocalDate

data class ExpenseRequestDto (
    val name: String,
    val place: String,
    val cost: Int,
    var description: String,
    val expenseDate: LocalDate,
    var isInstallments: String,
    var categoryId: Long,
    var paymentId: Long
)

data class ExpenseResponseDto (
    val id: Long,
    val name: String,
    val place: String,
    val cost: Int,
    var description: String,
    val expenseDate: LocalDate,
    var isInstallments: String,
    var categoryId: Long,
    var paymentId: Long
)

fun ExpenseRequestDto.toEntity() = Expense(
    0,
    this.name,
    this.place,
    this.cost,
    this.description,
    this.expenseDate,
    this.isInstallments,
    0,
    null
)