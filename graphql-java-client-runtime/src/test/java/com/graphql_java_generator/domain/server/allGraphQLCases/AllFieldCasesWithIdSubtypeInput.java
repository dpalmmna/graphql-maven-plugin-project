/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;


import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.UUID;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("AllFieldCasesWithIdSubtypeInput")
public class AllFieldCasesWithIdSubtypeInput 
{

	public AllFieldCasesWithIdSubtypeInput(){
		// No action
	}

	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	UUID id;


	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	String name;



	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public String toString() {
        return "AllFieldCasesWithIdSubtypeInput {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Id("id"),
		Name("name");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
			return new Builder();
		}



	/**
	 * Builder
	 */
	public static class Builder {
		private UUID id;
		private String name;


		public Builder withId(UUID id) {
			this.id = id;
			return this;
		}
		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public AllFieldCasesWithIdSubtypeInput build() {
			AllFieldCasesWithIdSubtypeInput _object = new AllFieldCasesWithIdSubtypeInput();
			_object.setId(id);
			_object.setName(name);
			return _object;
		}
	}
}