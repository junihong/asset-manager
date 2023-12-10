package com.tamsil.assetmanager.domain.expense

import com.tamsil.assetmanager.domain.category.CategoryRepository
import com.tamsil.assetmanager.domain.payment.PaymentRepository
import com.tamsil.assetmanager.web.dto.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExpenseService(
        private val expenseRepository: ExpenseRepository,
        private val paymentRepository: PaymentRepository,
        private val categoryRepository: CategoryRepository
) {

    private val log = LoggerFactory.getLogger(ExpenseService::class.java)

    fun create(expenseRequestDto: ExpenseRequestDto): ExpenseResponseDto {
        val payment = paymentRepository.findById(expenseRequestDto.paymentId).orElseThrow()
        val expense = expenseRequestDto.toEntity()
        expense.setPayment(payment)
        val savedEntity = expenseRepository.save(expense)

        val category = categoryRepository.findById(savedEntity.categoryId).orElseThrow()

        return ExpenseResponseDto(
                savedEntity.id,
                savedEntity.name,
                savedEntity.place,
                savedEntity.cost,
                savedEntity.description,
                savedEntity.expenseDate,
                savedEntity.isInstallments,
                CategoryResponseDto(
                    category.id,
                    category.categoryType,
                    category.categoryName,
                    category.detailName,
                    category.description
                ),
                PaymentResponseDto(
                    payment.id,
                    payment.paymentCode,
                    payment.name,
                    payment.description
                )
        )
    }
}