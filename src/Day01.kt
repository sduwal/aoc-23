val mapNumberToDigit =
        mapOf(
                "one" to 1,
                "two" to 2,
                "three" to 3,
                "four" to 4,
                "five" to 5,
                "six" to 6,
                "seven" to 7,
                "eight" to 8,
                "nine" to 9,
                "zero" to 0
        )

fun findNumber(string: String, shouldReturnOnFirstFind: Boolean = true): Int {
    var number = 0
    var tempString = string
    while (!tempString.isEmpty()) {
        if (tempString.first().isDigit()) {
            number = tempString.first().digitToInt()
            if (shouldReturnOnFirstFind) return number
        } else {
            for ((key, value) in mapNumberToDigit) {
                if (tempString.startsWith(key)) {
                    number = value
                    if (shouldReturnOnFirstFind) return number
                }
            }
        }
        tempString = tempString.drop(1)
    }

    return number
}

fun getNumber(string: String): Int {
    var first = findNumber(string, true)
    var last = findNumber(string, false)

    return first * 10 + last
}

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            val list = line.toCharArray().filter { it.isDigit() }.map { it.digitToInt() }
            sum += 10 * list.first() + list.last()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            sum += getNumber(line)
        }

        return sum
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
