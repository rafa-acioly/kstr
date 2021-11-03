package kstr

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertEquals
import kotlin.test.expect

class LibraryTest {


    @Test fun `should return the remainder of a string after the first occurrence of a given value`() {
        val expected = "bar baz"
        val actual = "foo bar baz".after("foo")

        assertEquals(expected, actual)
    }

    @Test fun `should return the remainder of a string after the last occurrence of a given value`() {
        val expected = "foo"
        val actual = "bar,baz,foo".afterLast(",")

        assertEquals(expected, actual)
    }

    @Test fun `should get the trailing name component of the path`() {
        val expected = "foo.bar"
        val actual = "foo/bar/baz/foo.bar".baseName()

        assertEquals(expected, actual)
    }

    @Test fun `should get the portion of a string before the first occurrence of a given value`() {
        val expected = "foo"
        val actual = "foo bar baz".before("bar")

        assertEquals(expected, actual)
    }

    @Test fun `should get the portion of a string before the last occurrence of a given value`() {
        val expected = "foo, bar"
        val actual = "foo, bar, baz".beforeLast(",")

        assertEquals(expected, actual)
    }

    @Test fun `should get the portion of a string between two given values`() {
        val expected = "bar"
        val actual = "foo bar baz".between("foo", "baz")

        assertEquals(expected, actual)
    }

    @Test fun `should cap a string with a single instance of a given value`() {
        val expected = "foo!"
        val actual = "foo".finish("!")

        assertEquals(expected, actual)
    }

    @Test fun `should limit the number of characters in a string`() {
        val expected = "foo..."
        val actual = "foo bar baz".limit(3)

        assertEquals(expected, actual)
    }

    @Test fun `should masks a portion of a string with a repeated character`() {
        val expected = "foo******"
        val actual = "foo bar baz".mask(6, "*")

        assertEquals(expected, actual)
    }

    @Test fun `should determine if the string matches the given pattern`() {
        val expected = true
        val actual = "foo bar baz".matches("foo.*")

        assertEquals(expected, actual)
    }

    @Test fun `should pad both sides of the string with another`() {
        val expected = "***foo***"
        val actual = "foo".padBoth(3, "*")

        assertEquals(expected, actual)
    }

    @Test fun `should pad the left side of the string with another`() {
        val expected = "***foo"
        val actual = "foo".padLeft(3, "*")

        assertEquals(expected, actual)
    }

    @Test fun `should pad the right side of the string with another`() {
        val expected = "foo***"
        val actual = "foo".padRight(3, "*")

        assertEquals(expected, actual)
    }

    @Test fun `should Call the given callback and return a new string`() {
        val expected = "BOO"
        val actual = "foo".pipe { it.uppercase() }.pipe { it.replace("f", "b") }

        assertEquals(expected, actual)
    }

    @Test fun `should prepend the given values to the string`() {
        val expected = "foo bar baz"
        val actual = "foo".prepend("bar", "baz")

        assertEquals(expected, actual)
    }

    @Test fun `should replace the first occurrence of a given value in the string`() {
        val expected = "foo baz baz"
        val actual = "foo bar baz".replaceFirst("bar", "baz")

        assertEquals(expected, actual)
    }

    @Test fun `should replace the last occurrence of a given value in the string`() {
        val expected = "foo bar baz *"
        val actual = "foo bar baz baz".replaceLast("baz", "*")

        assertEquals(expected, actual)
    }

    @Test fun `should execute the given callback if the string is empty`() {
        val expected = "foo"
        val actual = "".whenEmpty { "foo" }

        assertEquals(expected, actual)
    }

    @Test fun `should execute the given callback if the string is not empty`() {
        val expected = "bar"
        val actual = "foo".whenNotEmpty { "bar" }

        assertEquals(expected, actual)
    }

    @Test fun `should limit the number of words in a string`() {
        val expected = "foo bar baz"
        val actual = "foo bar baz baz".limit(3)

        assertEquals(expected, actual)
    }

    @Test fun `should get the number of words a string contains`() {
        val expected = 3
        val actual = "foo bar baz".wordCount()

        assertEquals(expected, actual)
    }
}
