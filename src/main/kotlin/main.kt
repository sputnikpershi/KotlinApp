@file:Suppress("DEPRECATION")

import kotlin.math.max

const val ERROR_NAME = -1.0
const val ERROR_TRANSFER_LIMIT = -2.0
const val ERROR_NEW_VK_LIMIT = -3.0

fun  main () {
    //agoToText(secAgo = 259200)
    println(transferMoney(historySum = 10000.0, sendSum = 100000.0, type = "maestro"))
}



fun transferMoney(historySum: Double, sendSum: Double,type: String): Double {
    val text = type.lowercase()
    if (sendSum < 150_000 && (historySum + sendSum) < 600_000) {
        return when (text) {
            "master card" -> if (sendSum + historySum < 300.0 || sendSum + historySum > 75000.0) sendSum * 0.006 + 20.0 else return  0.0
            "maestro" -> if (sendSum + historySum < 300.0 || sendSum + historySum > 75000.0) sendSum * 0.006 + 20.0 else return  0.0
            "visa" -> max(a = 35.0, sendSum * 0.0075)
            "mir" -> max(a = 35.0, sendSum * 0.0075)
            "vk pay" -> if (sendSum < 15_000 && historySum + sendSum < 40_000) return 0.0 else return ERROR_NEW_VK_LIMIT
            else ->  ERROR_NAME
        }
    } else {
        return ERROR_TRANSFER_LIMIT
    }
}


fun agoToText(secAgo: Int) = println(returnDateText(secAgo))

fun returnDateText(seconds: Int): String {
    var result = ""
    val min = seconds/60
    val hour = seconds/60/60
    var days = seconds/60/60/24
    val hourText = returnMinText(hour = hour)
    val minText = returnMinText(min = min)
    return when (seconds) {
        in 0..60 -> "был(а) в сети только что"
        in 61..3600 -> "был(а) в сети $min $minText назад"
        in 3601..86400 ->  "был(а) в сети $hour $hourText назад"
        in 86400..172800 -> "был(а) в сети вчера"
        in 172800..259200 -> "был(а) в сети позавчера"
        in 86400..345600 -> "был(а) в сети давно"
        else -> "был(а) в сети очень давно"
    }
}

fun returnMinText(min: Int = 0, hour: Int = 0): String {
    if (hour == 0) {
        return when (min) {
            1 -> "минуту"
            2 -> "минуты"
            4 -> "минуты"
            21 -> "минуту"
            else -> "минут"
        }
    } else {
        return when (hour) {
            1 -> "час"
            2 -> "часа"
            3 -> "часа"
            4 -> "часа"
            24 -> "часа"
            23 -> "часа"
            21 -> "час"
            22 -> "часа"
            else -> "часов"
        }
    }
}
