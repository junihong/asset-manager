package com.tamsil.assetmanager.common.contraint

enum class PaymentType(name: String) {
    CARD("카드"),
    TRANSFER("계좌이체"),
    CASH("현금"),
    PAY("페이"),
    GIFT("선물"),
    DEDUCTION("급여공제");
}