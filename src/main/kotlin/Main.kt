fun main () {
    println(calcCommission("Maestro", 80000, 500000))
}

fun calcCommission (card: String = "VK Pay", pastTransfer: Int = 0, currentTransfer: Int) = when (card) {
    "Mastercard", "Maestro" -> mastercardMaestroCommission(pastTransfer, currentTransfer)
    "Visa", "Mir" -> visaMirCommission(currentTransfer)
    else -> 0
}

fun mastercardMaestroCommission (pastTransfer: Int, currentTransfer: Int): Double {
    val commission = 0.006
    val additionalCommission = 20
    val limit = 75000
    return if (pastTransfer < limit) 0.0 else (currentTransfer * commission) + additionalCommission
}

fun visaMirCommission (currentTransfer: Int): Double {
    val commission = 0.0075
    val minCommission = 35
    return if (currentTransfer * commission < minCommission) minCommission.toDouble() else currentTransfer * commission
}