package com.tamsil.assetmanager.web.controller

import com.tamsil.assetmanager.domain.account.AccountService
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(private val accountService: AccountService) {
}