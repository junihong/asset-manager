package com.tamsil.assetmanager.web.dto

import com.tamsil.assetmanager.common.contraint.ExpenseType
import com.tamsil.assetmanager.domain.expense.ExpenseCategory

data class ExpenseCategoryRequestDto(
    val categoryName: ExpenseType,
    val detailName: String
) {
    fun toEntity(): ExpenseCategory {
        return ExpenseCategory(
            null,
            this.categoryName,
            this.detailName
        )
    }
}

data class ExpenseCategoryResponseDto(
    val id: Long,
    val categoryName: ExpenseType,
    val detailName: String
)