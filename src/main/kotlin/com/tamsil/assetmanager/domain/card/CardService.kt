package com.tamsil.assetmanager.domain.card

import com.tamsil.assetmanager.web.dto.CardRequestDto
import com.tamsil.assetmanager.web.dto.CardResponseDto
import com.tamsil.assetmanager.web.dto.toEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CardService(private val cardRepository: CardRepository) {

    val logger: Logger = LoggerFactory.getLogger(CardService::class.java)

    fun create(cardRequestDto: CardRequestDto): CardResponseDto {
        val card = cardRequestDto.toEntity()
        val savedCard = cardRepository.save(card)
        logger.info("savedCard : {}", savedCard)
        return savedCard.toDto()
    }

    fun update(id: Long, cardRequestDto: CardRequestDto): CardResponseDto {
        val card = cardRepository.findByIdOrNull(id)
        logger.info("card : {}", card)
        card?.update(cardRequestDto)
        return card!!.toDto()
    }

    fun delete(id: Long) {
        cardRepository.deleteById(id)
    }

    fun findById(id: Long): CardResponseDto {
        val card = cardRepository.findByIdOrNull(id)
        logger.info("findById card : {}", card)
        return card?.toDto() ?: throw Exception("Card is null")
    }

    fun findAll(): List<CardResponseDto> = cardRepository.findAll().map { it.toDto() }
}