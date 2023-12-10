package com.tamsil.assetmanager.web.dto

import com.tamsil.assetmanager.common.contraint.CategoryType
import com.tamsil.assetmanager.domain.category.Category

data class CategoryRequestDto (
    var categoryType: CategoryType,
    var categoryName: String,
    var detailName: String,
    var description: String
) {

}

data class CategoryResponseDto(
    val id: Long?,
    var categoryType: CategoryType,
    var categoryName: String,
    var detailName: String,
    var description: String
)

fun CategoryRequestDto.toEntity() = Category (
    null,
    this.categoryType,
    this.categoryName,
    this.detailName,
    this.description
)