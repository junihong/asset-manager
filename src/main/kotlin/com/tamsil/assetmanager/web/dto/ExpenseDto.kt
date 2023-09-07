package com.tamsil.assetmanager.web.dto

import com.tamsil.assetmanager.common.contraint.ExpenseType
import com.tamsil.assetmanager.domain.expense.ExpenseCategory

data class ExpenseRequestDto(
    val expenseType: ExpenseType,
    val detailName: String
) {
    fun toEntity() = ExpenseCategory(null, this.expenseType, this.detailName)
}

data class ExpenseResponseDto(
    val id: Long,
    val expenseType: ExpenseType,
    val detailName: String
)