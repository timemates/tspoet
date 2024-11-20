package com.y9vad9.tspoet

public sealed interface TypeName {
    public companion object {
        @JvmStatic
        public fun named(name: String): NamedTypeName {
            return NamedTypeName(name)
        }

        @JvmStatic
        public fun parameterized(
            name: String,
            typeParameters: List<TypeName>,
        ): ParameterizedNamedTypeName {
            return ParameterizedNamedTypeName(
                name = name,
                typeParameters = typeParameters,
            )
        }

        @JvmStatic
        public fun union(types: List<TypeName>): UnionTypeName {
            return UnionTypeName(types)
        }
    }
}

public data class NamedTypeName internal constructor(
    public val name: String,
) : TypeName

public data class ParameterizedNamedTypeName internal constructor(
    public val name: String,
    public val typeParameters: List<TypeName>,
) : TypeName

public data class UnionTypeName internal constructor(
    public val types: List<TypeName>,
): TypeName