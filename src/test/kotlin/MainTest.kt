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
    fun checkTransferVKLimit() {
        val monthSum = 30000.0
        val transferSum = 13000.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "vk pay")
        assertEquals(expected = ERROR_VK_LIMIT, actual = result)
    }

    @Test
    fun checkCorrectNameType() {
        val monthSum = 10000.0
        val transferSum = 11000.0
        val result = transferMoney(historySum = monthSum, sendSum = transferSum, type = "vk py")
        assertEquals(expected = ERROR_VK_LIMIT, actual = result)
    }


}
