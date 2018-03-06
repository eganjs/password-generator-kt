package eganjs.generator

import java.security.SecureRandom

private val lowercaseChars = 'a'..'z'
private val uppercaseChars = 'A'..'Z'
private val numericalChars = '0'..'9'

fun main(args: Array<String>) {
    generatePassword(9, lowercaseChars + uppercaseChars + numericalChars)
            .also { println(it) }
}

fun generatePassword(length: Int, validChars: List<Char>): String {
    val random = SecureRandom()
    return (0 until length)
            .map { random.nextInt(validChars.size) }
            .map { validChars[it] }
            .joinToString("")
}
