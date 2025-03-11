import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommisCardType1() {
        val cardType = "МИР"
        val transfer = 150_000

        val result = calculateCommis(cardType = cardType, transfer = transfer)
        assertEquals(0, result)
    }
    @Test
    fun calculateCommisCardType2() {
        val cardType = "Visa"
        val transfer = 150_000

        val result = calculateCommis(cardType = cardType, transfer = transfer)
        assertEquals(1125, result)
    }
    @Test
    fun calculateCommisCardType3() {
        val cardType = "MasterCard"
        val transfer = 75_000

        val result = calculateCommis(cardType = cardType, transfer = transfer)
        assertEquals(0, result)
    }
    @Test
    fun calculateCommisCardType3limit() {
        val cardType = "MasterCard"
        val transfer = 75_000
        val transferTotal = 75_000

        val result = calculateCommis(cardType = cardType, transfer = transfer, transferTotal = transferTotal)
        assertEquals(470, result)
    }
    @Test
    fun calculateCommisCardType3limit1() {
        val cardType = "MasterCard"
        val transfer = 75_000
        val transferTotal = 150_000

        val result = calculateCommis(cardType = cardType, transfer = transfer, transferTotal = transferTotal)
        assertEquals(470, result)
    }
    @Test
    fun calculateCommisLimitDaily() {
        val cardType = "1"
        val transfer = 151_000
        val transferTotal = 200_000

        val result = calculateCommis(cardType = cardType, transfer = transfer, transferTotal = transferTotal)
        assertEquals(-1, result)
    }
    @Test
    fun calculateCommisLimitMonthly() {
        val cardType = "1"
        val transfer = 150_000
        val transferTotal = 500_000

        val result = calculateCommis(cardType = cardType, transfer = transfer, transferTotal = transferTotal)
        assertEquals(-2, result)
    }
    @Test
    fun calculateCommisCardType() {
        val cardType = "Maestro"
        val transfer = 150_000
        val transferTotal = 200_000

        val result = calculateCommis(cardType = cardType, transfer = transfer, transferTotal = transferTotal)
        assertEquals(-3, result)
    }

}