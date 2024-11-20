package com.y9vad9.tspoet

public class TypeSpec private constructor(
    public val name: String,
    internal val kind: Kind,
    public val properties: List<PropertySpec>,
    public val functions: List<FunctionSpec>,
    public val superClass: TypeName?,
    public val superClassParameters: List<CodeBlock>,
    public val superInterfaces: List<TypeName>,
    override val doc: CodeBlock?,
    override val decorators: List<Decorator>
) : Documentable, Decoratable {
    public companion object {
        @JvmStatic
        public fun interfaceBuilder(name: String): Builder = Builder(name, Kind.INTERFACE)

        @JvmStatic
        public fun classBuilder(name: String): Builder = Builder(name, Kind.CLASS)
    }

    internal enum class Kind {
        CLASS,
        INTERFACE
    }

    public class Builder internal constructor(
        private val name: String,
        private val kind: Kind
    ) {
        private var doc: CodeBlock = CodeBlock.of("")
        private val properties: MutableList<PropertySpec> = mutableListOf()
        private val functions: MutableList<FunctionSpec> = mutableListOf()
        private var superClass: TypeName? = null
        public val superClassParameters: MutableList<CodeBlock> = mutableListOf()
        private val superInterfaces: MutableList<TypeName> = mutableListOf()
        private val decorators: MutableList<Decorator> = mutableListOf()

        public fun doc(doc: CodeBlock): Builder {
            this.doc = doc
            return this
        }

        public fun addProperty(spec: PropertySpec): Builder {
            properties.add(spec)
            return this
        }

        public fun addFunction(spec: FunctionSpec): Builder {
            functions.add(spec)
            return this
        }

        public fun setSuperClass(superClass: TypeName?): Builder {
            require(kind != Kind.INTERFACE) { "Superclass cannot be used on interfaces" }
            this.superClass = superClass
            return this
        }

        public fun addSuperClassParameter(codeBlock: CodeBlock): Builder {
            this.superClassParameters += codeBlock
            return this
        }

        public fun addSuperInterface(superInterface: TypeName): Builder {
            superInterfaces.add(superInterface)
            return this
        }

        public fun addDecorator(decorator: Decorator): Builder {
            decorators.add(decorator)
            return this
        }

        public fun build(): TypeSpec {
            return TypeSpec(
                name = name,
                kind = kind,
                properties = properties,
                functions = functions,
                superClass = superClass,
                superClassParameters = superClassParameters,
                superInterfaces = superInterfaces,
                doc = doc,
                decorators = decorators,
            )
        }
    }
}