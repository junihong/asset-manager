package com.tamsil.assetmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class AssetManagerApplication

fun main(args: Array<String>) {
	runApplication<AssetManagerApplication>(*args)
}
