import org.junit.Test
import kotlin.test.assertEquals
const val ERROR_NAME = -1.0
const val ERROR_TRANSFER_LIMIT = -2.0
const val ERROR_VK_LIMIT = -3.0
class MainTest {


    @Test
    fun checkTransferCardLimit() {
        val monthSum = 5000000.0
        val transferSum = 100001.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "visa")
        assertEquals(expected = ERROR_TRANSFER_LIMIT, actual = result)
    }

    @Test
    fun checkTransferCardMasterCardWithZeroHistory() {
        val monthSum = 0.0
        val transferSum = 10001.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "master card")
        assertEquals(expected = 0.0, actual = result)
    }

    @Test
    fun checkTransferCardMaestroWithZeroHistory() {
        val monthSum = 0.0
        val transferSum = 10001.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "maestro")
        assertEquals(expected = 0.0, actual = result)
    }
    @Test
    fun checkTransferCardMaestroWithCommission() {
        val monthSum = 70000.0
        val transferSum = 10001.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "maestro")
        assertEquals(expected = 80.006, actual = result)
    }
    @Test
    fun checkTransferCardVisaWithZeroHistory() {
        val monthSum = 0.0
        val transferSum = 100001.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "visa")
        assertEquals(expected = 750.0074999999999, actual = result)
    }

    @Test
    fun checkTransferCardMirWithZeroHistory() {
        val monthSum = 0.0
        val transferSum = 100001.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "mir")
        assertEquals(expected = 750.0074999999999, actual = result)
    }


    @Test
    fun checkTransferVKLimit() {
        val monthSum = 30000.0
        val transferSum = 13000.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "vk pay")
        assertEquals(expected = ERROR_VK_LIMIT, actual = result)
    }

    @Test
    fun checkTransferVKZeroCommission() {
        val monthSum = 0.0
        val transferSum = 10000.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "vk pay")
        assertEquals(expected = 0.0, actual = result)
    }
    @Test
    fun checkTransferVKZeroCommissionLimit() {
        val monthSum = 400.0
        val transferSum = 100000.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "vk pay")
        assertEquals(expected = ERROR_VK_LIMIT, actual = result)
    }

    @Test
    fun checkCorrectNameType() {
        val monthSum = 10000.0
        val transferSum = 11000.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "vk py")
        assertEquals(expected = ERROR_NAME, actual = result)
    }


}
