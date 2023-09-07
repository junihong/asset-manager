package com.tamsil.assetmanager.domain.expense

import com.tamsil.assetmanager.common.contraint.ExpenseType
import jakarta.persistence.*

@Entity
class ExpenseCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Enumerated(value = EnumType.STRING)
    val categoryName: ExpenseType,
    val detailName: String
) {

}