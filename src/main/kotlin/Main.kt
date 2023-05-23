fun main () {
    println(transaction("Mastercard", 75000, 100))
}

fun calcCommission (card: String = "VK Pay", pastTransfer: Int = 0, currentTransfer: Int) = when (card) {
    "Mastercard", "Maestro" -> mastercardMaestroCommission(pastTransfer, currentTransfer)
    "Visa", "Mir" -> visaMirCommission(currentTransfer)
    else -> 0.0
}

fun mastercardMaestroCommission (pastTransfer: Int, currentTransfer: Int): Double {
    val commission = 0.006
    val additionalCommission = 20
    val limit = 75000
    return if (pastTransfer + currentTransfer < limit) 0.0 else (currentTransfer * commission) + additionalCommission
}

fun visaMirCommission (currentTransfer: Int): Double {
    val commission = 0.0075
    val minCommission = 35
    return if (currentTransfer * commission < minCommission) minCommission.toDouble() else currentTransfer * commission
}

fun limitCheck (card: String, pastTransfer: Int, currentTransfer: Int) = when (card) {
    "VK Pay" -> (currentTransfer <= 15000 && pastTransfer + currentTransfer <= 40000)
    else -> (currentTransfer <= 150000 && pastTransfer + currentTransfer <= 600000)
}

fun transaction (card: String, pastTransfer: Int, currentTransfer: Int) =
    if (limitCheck(card, pastTransfer, currentTransfer)) {
        calcCommission(card, pastTransfer, currentTransfer)
    } else {
        "Превышен лимит по карте"
    }
