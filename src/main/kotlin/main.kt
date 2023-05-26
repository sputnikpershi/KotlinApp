fun main() {
    //1
    //  sendMoneyTax(10000)

    //2
    //   print(returnLikeEndings(1111))

    //3
    //discountMusic(1000, true)
}


//комиссия составляет 0.75 %, минимум 35 рублей.
fun sendMoneyTax (amount: Int): Double  {
     val percent = 0.0075
     val minTax = 35
     val value = amount*percent
     val result =  if ( value > 35) {
         value
     } else {
         minTax.toDouble()
     }
     println("Tax equal to $result")
     return result
}


fun returnLikeEndings(likes: Int): String {
    val stringLikes = likes.toString()
    val lastTwoNumber = stringLikes.takeLast(2)
    val lastSymbol = stringLikes.last()

    if (lastTwoNumber == "11") {
        return ("понравилось $likes людям")
    }
    val result = when (lastSymbol) {
        '1' -> ("понравилось $likes человеку")
        else -> ("понравилось $likes людям")
    }
    return result
}



fun discountMusic(sum: Int, hadCard: Boolean ): Int  {
    var sale: Double = 0.0
    var moneyWithSale = sum

        if (sum in 1..1000) {
            sale = 0.0
        } else if (sum in 1001..10000){
            moneyWithSale -= 100
        } else if (sum > 10000) {
            sale = sum * 0.05
            moneyWithSale = (moneyWithSale.toDouble() - sale).toInt()
        }

    if (hadCard) {
        sale = moneyWithSale * 0.01
        moneyWithSale -= sale.toInt()
    }


print("total sale is $moneyWithSale")
    return moneyWithSale
}