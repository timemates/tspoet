package com.y9vad9.tspoet

public class Decorator private constructor(
    public val name: String,
) {
    public companion object {
        @JvmStatic
        public fun of(name: String): Decorator {
            return Decorator(name = name)
        }
    }
}