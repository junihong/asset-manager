package com.tamsil.assetmanager.domain.expense

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val expenseRepository: ExpenseRepository) {

    private val log = LoggerFactory.getLogger(ExpenseService::class.java)


}