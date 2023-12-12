package com.tamsil.assetmanager.domain.expense

import com.tamsil.assetmanager.domain.category.CategoryRepository
import com.tamsil.assetmanager.domain.payment.PaymentRepository
import com.tamsil.assetmanager.web.dto.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ExpenseService(
        private val expenseRepository: ExpenseRepository,
        private val paymentRepository: PaymentRepository,
        private val categoryRepository: CategoryRepository
) {

    private val log = LoggerFactory.getLogger(ExpenseService::class.java)

    @Transactional
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

    fun findById(id: Long): ExpenseResponseDto {
        val expense = expenseRepository.findById(id).orElseThrow()
        val category = categoryRepository.findById(expense.categoryId).orElseThrow()
        return ExpenseResponseDto(
            expense.id,
            expense.name,
            expense.place,
            expense.cost,
            expense.description,
            expense.expenseDate,
            expense.isInstallments,
            CategoryResponseDto(
                category.id,
                category.categoryType,
                category.categoryName,
                category.detailName,
                category.description
            ),
            PaymentResponseDto(
                expense.payment!!.id,
                expense.payment!!.paymentCode,
                expense.name,
                expense.description
            )
        )
    }
}