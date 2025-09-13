import kotlin.system.exitProcess

fun main() {

   var text="""
       |0 - выход из программы
        |1 пункт -  подсчет количества подряд идущих одинаковых символов во введенной строке.
    |2 - подсчет количества различных символов во введенной строке.
    |3 - преобразование введенного пользователем натурального числа из 10-ичной системы в двоичную.
    |4 - приложение, с помощью которого пользователь, введя два числа и символ операции, узнает результат. 
    |5 - приложение, с помощью которого пользователь, введя целое число n и основание степени x узнает, существует ли целочисленный показатель степени y для которого выполняется равенство xy = n.
    |6 - приложение, в котором пользователь вводит две различных цифры. На выходе приложение выдает, если это возможно, из введенных цифр, нечетное число.
    |Введите число программы:
    """.trimMargin()
    println(text)
    val x = readln()
     when (x){
         "0"-> exitProcess(0)
        "1"->project1()
         "2"->project2()
         "3"->project3()
         "4"->project4()
         "5"->project5()
         "6"->project6()
    }
}
fun project1(){
    var r = ""
    var c = 1
    print("введите строку: ")
    val input = readln()
    println()

    for(i in 0  ..  input.length-1){
    }
    for (i in input.indices) {
        if (i < input.lastIndex && input[i] == input[i + 1]) c++
        else { r += input[i] + if (c > 1) "$c" else ""; c = 1 }
    }

    println(r)
}

fun project2(){
    println("Введите строку:")
    val input = readln() ?: ""

    val x = input.groupingBy { it }.eachCount()


    x.toSortedMap().forEach { (char, count) ->
        println("$char - $count")
    }
}

fun project3(){
    println("Введите натуральное число:")
    val input = readln() ?: return
    var number = input.toInt()

    if (number <= 0) {
        println("Число должно быть натуральным.")
        return
    }

    var x = ""

    while (number > 0) {
        val y = number % 2
        x = y.toString() + x
        number /= 2
    }

    println("Двоичное представление: $x")
}

fun project4(){
    println("Пожалуйста, введите два числа и оператор (например: 5 3 +)")

    val firstNumber = readln().toDoubleOrNull()
    val secondNumber = readln().toDoubleOrNull()
    val operator = readln()

    if (firstNumber == null || secondNumber == null) {
        println("Ошибка: введите корректные числа.")
        return
    }

    val result: Double

    when (operator) {
        "+" -> result = firstNumber + secondNumber
        "-" -> result = firstNumber - secondNumber
        "*" -> result = firstNumber * secondNumber
        "/" -> {
            if (secondNumber != 0.0) {
                result = firstNumber / secondNumber
            } else {
                println("Ошибка: деление на ноль!")
                return
            }
        }
        else -> {
            println("Ошибка: неверный оператор!")
            return
        }
    }

    println("$firstNumber $operator $secondNumber = $result")
}

fun project5(){
    println("Введите целое число n:")
    val n = readln()?.toIntOrNull()

    println("Введите основание степени x:")
    val x = readln()?.toIntOrNull()

    if (n == null || x == null || x <= 0) {
        println("Ошибка: введите корректные целые числа, основание должно быть положительным.")
        return
    }

    var y = 0
    var power = 1

    while (power < n) {
        y++
        power = Math.pow(x.toDouble(), y.toDouble()).toInt()
    }

    if (power == n) {
        println("Существует целочисленный показатель степени: y = $y")
    } else {
        println("Целочисленный показатель не существует.")
    }
}

fun project6(){
    println("Введите 2 цифры:")
    val firstDigit = readln()!!.toInt()
    val secondDigit = readln()!!.toInt()

    if (firstDigit == secondDigit) {
        println("Цифры должны быть различными.")
        return
    }

    val oddNumber = if (firstDigit % 2 != 0) {
        "$secondDigit$firstDigit"
    } else if (secondDigit % 2 != 0) {
        "$firstDigit$secondDigit"
    } else {
        null
    }
    if (oddNumber != null) {
        println("Составленное нечетное число: $oddNumber")
    } else {
        println("Создать нечетное число невозможно")
    }
}