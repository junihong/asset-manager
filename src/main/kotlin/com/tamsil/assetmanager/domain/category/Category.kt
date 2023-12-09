package com.tamsil.assetmanager.domain.category

import com.tamsil.assetmanager.common.contraint.CategoryType
import com.tamsil.assetmanager.domain.BaseTimeEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    var categoryType: CategoryType,
    var categoryName: String,
    var detailName: String,
    var description: String
): BaseTimeEntity() {

}