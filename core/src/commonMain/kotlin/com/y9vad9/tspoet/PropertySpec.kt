package com.y9vad9.tspoet

public class PropertySpec private constructor(
    public val modifiers: List<TSModifier>,
    public val name: String,
    public val type: TypeName,
    public val initializer: CodeBlock?,
    override val doc: CodeBlock?,
    override val decorators: List<Decorator>,
) : Documentable, Decoratable {
    public companion object {
        @JvmStatic
        public fun builder(name: String, type: TypeName): Builder = Builder(name, type)
    }

    public class Builder(
        private val name: String,
        private val type: TypeName
    ) {
        private val modifiers: MutableList<TSModifier> = mutableListOf()
        private var initializer: CodeBlock? = null
        private val decorators: MutableList<Decorator> = mutableListOf()
        private var doc: CodeBlock? = null

        public fun addModifier(modifier: TSModifier): Builder {
            modifiers.add(modifier)
            return this
        }

        public fun initializer(initializer: CodeBlock): Builder {
            this.initializer = initializer
            return this
        }

        public fun doc(doc: CodeBlock): Builder {
            this.doc = doc
            return this
        }

        public fun build(): PropertySpec {
            return PropertySpec(
                modifiers = modifiers,
                name = name,
                type = type,
                initializer = initializer,
                decorators = decorators,
                doc = doc,
            )
        }
    }
}
