package com.tamsil.assetmanager.domain.card

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CardRepositoryTest @Autowired constructor(val cardRepository: CardRepository) {

    val logger: Logger = LoggerFactory.getLogger(CardRepositoryTest::class.java)

    @Test
    fun `createCard Test`() {
        val card = Card(null, null, "네이버카드", "현대카드", 25, "Y", "Y", "N")
        val savedCard = cardRepository.save(card)
        logger.info("savedCard : {}, {}", savedCard.name, savedCard.company)
    }
}