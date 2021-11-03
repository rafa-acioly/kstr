package kstr


/**
 * Return the remainder of a string after the first occurrence of a given value.
 */
fun String.after(value: String): String {
    val index = this.indexOf(value)
    return if (index == -1) this else this.substring(index + value.length).trim()
}

/**
 * Return the remainder of a string after the last occurrence of a given value.
 */
fun String.afterLast(value: String): String {
    val index = this.lastIndexOf(value)
    return if (index == -1) this else this.substring(index + value.length)
}

/**
 * Get the trailing name component of the path.
 */
fun String.baseName(): String {
    val index = this.lastIndexOf('/')
    return if (index == -1) this else this.substring(index + 1)
}

/**
 * Get the portion of a string before the first occurrence of a given value.
 */
fun String.before(value: String): String {
    val index = this.indexOf(value)
    return if (index == -1) this else this.substring(0, index).trim()
}

/**
 * Get the portion of a string before the last occurrence of a given value.
 */
fun String.beforeLast(value: String): String {
    val index = this.lastIndexOf(value)
    return if (index == -1) this else this.substring(0, index)
}

/**
 * Get the portion of a string between two given values.
 */
fun String.between(start: String, end: String): String {
    val startIndex = this.indexOf(start)
    val endIndex = this.indexOf(end)
    return if (startIndex == -1 || endIndex == -1) this else this.substring(startIndex + start.length, endIndex).trim()
}

/**
 * Cap a string with a single instance of a given value.
 */
fun String.finish(value: String): String {
    return if (this.endsWith(value)) this else this + value
}

/**
 * Limit the number of characters in a string.
 */
fun String.limit(length: Int, end: String = "..."): String {
    return if (this.length > length) this.substring(0, length) + end else this
}

/**
 * Masks a portion of a string with a repeated character.
 */
fun String.mask(length: Int, mask: String = "*"): String {
    return if (this.length > length) this.substring(0, length) + mask.repeat(this.length - length) else this
}

/**
 * Determine if the string matches the given pattern.
 */
fun String.matches(pattern: String): Boolean {
    return Regex(pattern).matches(this)
}

/*
 * Pad both sides of the string with another.
 */
fun String.padBoth(length: Int, pad: String = " "): String {
    return this.padLeft(length, pad).padRight(length, pad)
}

/*
 * Pad the left side of the string with another.
 */
fun String.padLeft(length: Int, pad: String = " "): String {
    return pad.repeat(length) + this
}

/*
 * Pad the right side of the string with another.
 */
fun String.padRight(length: Int, pad: String = " "): String {
    return this + pad.repeat(length)
}

/*
 * Call the given callback and return a new string.
 */
fun String.pipe(callback: (String) -> String): String {
    return callback(this)
}

/*
 * Prepend the given values to the string.
 */
fun String.prepend(vararg values: String): String {
    return values.joinToString(separator = "") + this
}

/*
 * Replace the first occurrence of a given value in the string.
 */
fun String.replaceFirst(value: String, replacement: String): String {
    val index = this.indexOf(value)
    return if (index == -1) this else this.substring(0, index) + replacement + this.substring(index + value.length)
}

/*
 * Replace the last occurrence of a given value in the string.
 */
fun String.replaceLast(value: String, replacement: String): String {
    val index = this.lastIndexOf(value)
    return if (index == -1) this else this.substring(0, index) + replacement + this.substring(index + value.length)
}

/*
 * Execute the given callback if the string is empty.
 */
fun String.whenEmpty(callback: () -> String): String {
    if (this.isEmpty()) return callback()
    return this
}

/*
 * Execute the given callback if the string is not empty.
 */
fun String.whenNotEmpty(callback: (param: String) -> String): String {
    if (this.isNotEmpty()) return callback(this)
    return this
}

/*
 * Limit the number of words in a string.
 */
fun String.words(length: Int, end: String = "..."): String {
    return if (this.split(" ").size > length) this.split(" ").take(length).joinToString(" ") + end else this
}

/*
 * Get the number of words a string contains.
 */
fun String.wordCount(): Int {
    return this.split(" ").size
}
