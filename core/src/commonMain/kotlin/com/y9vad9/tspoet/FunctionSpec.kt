package com.y9vad9.tspoet

public class FunctionSpec private constructor(
    public val modifiers: List<TSModifier>,
    public val name: String,
    public val parameters: List<ParameterSpec>,
    public val returnType: TypeName?,
    public val body: CodeBlock?,
    override val doc: CodeBlock?,
    public override val decorators: List<Decorator>
) : Documentable, Decoratable {

    public companion object {
        @JvmStatic
        public fun builder(name: String, returnType: TypeName? = null): Builder = Builder(name, returnType)
    }

    public class Builder(
        private val name: String,
        private var returnType: TypeName? = null,
    ) {
        private val modifiers: MutableList<TSModifier> = mutableListOf()
        private val parameters: MutableList<ParameterSpec> = mutableListOf()
        private var body: CodeBlock? = null
        private var doc: CodeBlock? = null
        private val decorators: MutableList<Decorator> = mutableListOf()

        public fun addModifier(modifier: TSModifier): Builder {
            modifiers.add(modifier)
            return this
        }

        public fun addParameter(parameter: ParameterSpec): Builder {
            parameters.add(parameter)
            return this
        }

        public fun body(body: CodeBlock): Builder {
            this.body = body
            return this
        }

        public fun doc(doc: CodeBlock): Builder {
            this.doc = doc
            return this
        }

        public fun addDecorator(decorator: Decorator): Builder {
            decorators.add(decorator)
            return this
        }

        public fun returns(returnType: TypeName): Builder {
            this.returnType = returnType
            return this
        }

        public fun build(): FunctionSpec {
            return FunctionSpec(
                modifiers = modifiers,
                name = name,
                parameters = parameters,
                returnType = returnType,
                body = body,
                doc = doc,
                decorators = decorators
            )
        }
    }
}
