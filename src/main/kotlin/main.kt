@file:Suppress("DEPRECATION")

fun  main () {

    /*
    Задача №1. Только что
    Социальные сети и мессенджеры показывают, когда ваш собеседник последний раз был онлайн:

    Задача №2. Разная комиссия
     */

    //agoToText(secAgo = 259200)
    println(getCommission(type = "maestro", historySum = 0, 299))
}


fun getCommission(type: String = "VK Pay", historySum: Int, sumWillSend: Int): Double {
    var commission = 0.0
    val totalSum = historySum + sumWillSend
    val text = type.lowercase()
    when (text) {
        "master card" -> commission = commissionForCardMaster(amount = totalSum, sumForSend = sumWillSend, percent = 0.006, addition = 20)
        "maestro" -> commission = commissionForCardMaster(amount = totalSum, sumForSend = sumWillSend, percent = 0.006, addition = 20)
        "visa" -> commission = sendMoneyTax(amount = sumWillSend, percent = 0.0075, minTax = 35)
        "mir" ->  commission = sendMoneyTax(amount = sumWillSend, percent = 0.0075, minTax = 35)
        "vk pay" -> commission = 0.0
        else -> println("Платеж не может быть обработан")
    }
    return commission
}

fun sendMoneyTax (amount: Int, percent: Double, minTax : Int): Double  {
    val value = amount*percent
    val result =  if ( value > 35) {
        value
    } else {
        minTax.toDouble()
    }
    println("Tax equal to $result")
    return result
}

fun commissionForCardMaster (amount: Int, sumForSend: Int, percent: Double, addition: Int): Double  {
    val value = sumForSend*percent
    val minTax = 20
    return if (amount < 300 || amount > 75000) {
        value + minTax.toDouble()
    } else {
        0.0
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
