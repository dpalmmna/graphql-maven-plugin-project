#################################################################################################################
## Import of common.vm  (commons Velocity macro and definitions)
#################################################################################################################
#parse ("templates/common.vm")
##
##
/** Generated by the default template from graphql-java-generator */
package ${configuration.packageName};

#if ($configuration.isGenerateJacksonAnnotations())
import com.fasterxml.jackson.annotation.JsonProperty;
#end
import com.graphql_java_generator.annotation.GraphQLDirective;
import com.graphql_java_generator.annotation.GraphQLEnumType;

/**
#if ($object.description)
#foreach ($line in $object.description.lines)
 * ${line}
#end
#end
 * 
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLEnumType("${object.name}")
#appliedDirectives(${object.appliedDirectives}, "")
@SuppressWarnings("unused")
public enum ${object.javaName} {
#foreach ($value in $object.values)
#if ($graphqlUtils.isJavaReservedWords(${value.name}))
#if ($configuration.isGenerateJacksonAnnotations())
	@JsonProperty("${value.name}") // Needed as ${value.name} is a java reserved keyword
#end
#appliedDirectives(${value.appliedDirectives}, "	")
	${javaKeywordPrefix}${value.name}("${value.name}")#if($foreach.hasNext), #else;#end
#else
	#appliedDirectives(${value.appliedDirectives}, "	")
	${value.name}("${value.name}")#if($foreach.hasNext), #else;#end
#end
#end

	// The graphQlValue is needed on server side, to map the enum value to the value defined in the GraphQL schema. They are different
	// when the value in the GraphQL schema is a java reserved keyword.
	private final String graphQlValue;

	/**
	 * Returns the value of this constant, as specified in the GraphQL schema. This is usually the same as the enum
	 * item's name. But it will differ if this name is a java reserved keyword (in which case the name is prefixed by an
	 * underscore)
	 * 
	 * @return the enum constant with the specified name, as defined in the GraphQL schema
	 */
	public String graphQlValue() {
		return graphQlValue;
	}
	
	/**
	 * Returns the enum constant of this type with the specified name (as specified in the GraphQL schema). The string
	 * must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters
	 * are not permitted.)
	 * 
	 * @param graphQlValue
	 *            The value, as defined in the GraphQL schema. This is usually the same as the enum item's name. But it
	 *            will differ if this name is a java reserved keyword (in which case the name is prefixed by an
	 *            underscore)
	 * @return the enum constant with the specified name
	 * @throws IllegalArgumentException
	 *             if this enum type has no constant with the specified GraphQL name
	 */
	static public ${object.javaName} fromGraphQlValue(String graphQlValue) {
		if (graphQlValue == null) {
			return null;
		}
		for (${object.javaName} e : ${object.javaName}.values()) {
			if (e.graphQlValue().equals(graphQlValue)) {
				return e;
			}
		}
		throw new IllegalArgumentException("No ${object.javaName} exists with '" + graphQlValue + "' as a GraphQL value");
	}

	${object.javaName}(String graphQlValue) {
		this.graphQlValue = graphQlValue;
	}
}
