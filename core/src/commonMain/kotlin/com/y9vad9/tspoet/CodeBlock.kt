package com.y9vad9.tspoet

public class CodeBlock private constructor(
    internal val formatParts: List<String>,
    internal val args: List<Any?>,
) {
    public fun isEmpty(): Boolean = formatParts.isEmpty()

    public fun isNotEmpty(): Boolean = !isEmpty()

    public companion object {
        @JvmStatic
        public fun of(format: String, vararg args: Any?): CodeBlock {
            return CodeBlock(listOf(format), args.toList())
        }
    }
}