package com.tamsil.assetmanager.domain.card

import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card, Long> {
}