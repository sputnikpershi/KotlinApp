@file:Suppress("DEPRECATION")

import java.util.Date
import kotlin.math.min

fun  main () {
    agoToText(secAgo = 259200)
}

fun agoToText(secAgo: Int) = println(returnDateText(secAgo))

fun returnDateText(seconds: Int): String {
    var result = ""
    var min = seconds/60
    var hour = seconds/60/60
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
