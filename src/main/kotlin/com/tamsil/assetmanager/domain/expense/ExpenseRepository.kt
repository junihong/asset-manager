package com.tamsil.assetmanager.domain.expense

import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<Expense, Long> {
}