package eganjs.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RandomPasswordTest {
    private val whitespaceCharSingleton: List<Char> = listOf(' ')
    private val pseudoRandomChars: List<Char> = listOf('T', 'y', 'p', 'e', 'w', 'r', 'i', 't', 'e', 'r', '1', '!')

    @Test
    fun whenGeneratePasswordWithZeroLengthThenReturnStringWithCorrectLength() {
        val length = 0
        val whitespacePassword = generatePassword(length, whitespaceCharSingleton)

        assertThat(whitespacePassword)
                .hasSize(length)
    }

    @Test
    fun whenGeneratePasswordWithShortLengthThenReturnStringWithCorrectLength() {
        val length = 3
        val whitespacePassword = generatePassword(length, whitespaceCharSingleton)

        assertThat(whitespacePassword)
                .hasSize(length)
    }

    @Test
    fun whenGeneratePasswordWithLongLengthThenReturnStringWithCorrectLength() {
        val length = 65536
        val whitespacePassword = generatePassword(length, whitespaceCharSingleton)

        assertThat(whitespacePassword)
                .hasSize(length)
    }

    @Test
    fun whenGeneratePasswordWithOnlyWhitespaceCharactersThenReturnStringWithOnlyWhitespaceCharacters() {
        val length = 32
        val whitespacePassword = generatePassword(length, whitespaceCharSingleton)

        assertThat(whitespacePassword)
                .containsOnlyWhitespaces()
    }

    @Test
    fun whenGeneratePasswordWithListOfCharactersThenReturnStringWithOnlyGivenCharacters() {
        val length = 32
        val randomPassword = generatePassword(length, pseudoRandomChars)

        assertThat(randomPassword.toList())
                .isSubsetOf(pseudoRandomChars)
    }
}
