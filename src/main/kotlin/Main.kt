fun main() {
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