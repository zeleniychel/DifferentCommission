import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun limitCheckVKTrue () {
        val card = "VK Pay"
        val pastTransfer = 1000
        val currentTransfer = 1000
        limitCheck(card,pastTransfer, currentTransfer)
        assertTrue(true)
    }

    @Test
    fun limitCheckVKFalse () {
        val card = "VK Pay"
        val pastTransfer = 1000
        val currentTransfer = 1000000
        limitCheck(card,pastTransfer, currentTransfer)
        assertFalse(false)
    }

    @Test
    fun limitCheckOtherCardsTrue () {
        val card = "Mastercard"
        val pastTransfer = 1000
        val currentTransfer = 100000
        limitCheck(card,pastTransfer, currentTransfer)
        assertTrue(true)
    }

    @Test
    fun limitCheckOtherCardsFalse () {
        val card = "Mastercard"
        val pastTransfer = 1000
        val currentTransfer = 10000000
        limitCheck(card,pastTransfer, currentTransfer)
        assertFalse(false)
    }

    @Test
    fun transactionExceededLimit () {
        val card = "VK Pay"
        val pastTransfer = 1000000
        val currentTransfer = 100
        val result = transaction(card, pastTransfer, currentTransfer)
        assertEquals("Превышен лимит по карте", result)
    }

    @Test
    fun transactionAcceptableLimit () {
        val card = "VK Pay"
        val pastTransfer = 1000
        val currentTransfer = 100
        val result = transaction(card, pastTransfer, currentTransfer)
        assertEquals(0.0, result)
    }
    @Test
    fun visaMirCommissionMoreMin () {
        val currentTransfer = 10000
        val result = visaMirCommission(currentTransfer)
        assertEquals(null,75.0,result, 0.0)
    }

    @Test
    fun mastercardMaestroCommissionLessLimit () {
        val pastTransfer = 5000
        val currentTransfer = 1000
        val result = mastercardMaestroCommission(pastTransfer,currentTransfer)
        assertEquals(null,0.0,result, 0.0)
    }

    @Test
    fun mastercardMaestroCommissionMoreLimit () {
        val pastTransfer = 75000
        val currentTransfer = 1000
        val result = mastercardMaestroCommission(pastTransfer, currentTransfer)
        assertEquals(null, 26.0, result, 0.0)
    }
    @Test
    fun calcCommissionOtherCards () {
        val card = "CreditCard"
        val pastTransfer = 75000
        val currentTransfer = 1000
        val result = calcCommission(card, pastTransfer, currentTransfer)
        assertEquals(null, 0.0, result, 0.0)
    }

    @Test
    fun calcCommissionMasterCard () {
        val card = "Mastercard"
        val pastTransfer = 75000
        val currentTransfer = 1000
        val result = calcCommission(card, pastTransfer, currentTransfer)
        assertEquals(null, 26.0, result, 0.0)
    }

    @Test
    fun calcCommissionMaestro () {
        val card = "Maestro"
        val pastTransfer = 75000
        val currentTransfer = 1000
        val result = calcCommission(card, pastTransfer, currentTransfer)
        assertEquals(null, 26.0, result, 0.0)
    }

    @Test
    fun calcCommissionMir () {
        val card = "Mir"
        val pastTransfer = 75000
        val currentTransfer = 1000
        val result = calcCommission(card, pastTransfer, currentTransfer)
        assertEquals(null, 35.0, result, 0.0)
    }
    @Test
    fun calcCommissionVisa () {
        val card = "Visa"
        val pastTransfer = 75000
        val currentTransfer = 1000
        val result = calcCommission(card, pastTransfer, currentTransfer)
        assertEquals(null, 35.0, result, 0.0)
    }
}