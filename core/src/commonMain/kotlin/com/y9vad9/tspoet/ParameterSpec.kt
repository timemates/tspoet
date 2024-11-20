package com.y9vad9.tspoet

public class ParameterSpec private constructor(
    public val name: String,
    public val type: TypeName,
    public val defaultValue: CodeBlock? = null,
) {
    public companion object {
        @JvmStatic
        public fun builder(name: String, type: TypeName): Builder = Builder(name, type)

        @JvmStatic
        public fun of(name: String, type: TypeName): ParameterSpec = ParameterSpec(name, type)
    }

    public class Builder(
        private val name: String,
        private val type: TypeName
    ) {
        private var defaultValue: CodeBlock? = null

        public fun defaultValue(defaultValue: CodeBlock): Builder {
            this.defaultValue = defaultValue
            return this
        }

        public fun build(): ParameterSpec {
            return ParameterSpec(
                name = name,
                type = type,
                defaultValue = defaultValue
            )
        }
    }
}
