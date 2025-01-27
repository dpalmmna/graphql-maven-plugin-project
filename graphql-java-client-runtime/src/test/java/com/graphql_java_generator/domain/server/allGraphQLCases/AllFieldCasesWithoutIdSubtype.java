/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("AllFieldCasesWithoutIdSubtype")
public class AllFieldCasesWithoutIdSubtype {

	public AllFieldCasesWithoutIdSubtype() {
		// No action
	}

	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "AllFieldCasesWithoutIdSubtype {" + "name: " + name + "}";
	}

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder
	 */
	public static class Builder {
		private String name;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public AllFieldCasesWithoutIdSubtype build() {
			AllFieldCasesWithoutIdSubtype _object = new AllFieldCasesWithoutIdSubtype();
			_object.setName(name);
			return _object;
		}
	}
}
