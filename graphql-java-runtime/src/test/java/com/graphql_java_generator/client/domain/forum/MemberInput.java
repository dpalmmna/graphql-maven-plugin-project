/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.client.domain.forum;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("MemberInput")
public class MemberInput 
{

	/**
	 * This map contains the deserialiazed values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public MemberInput(){
		// No action
	}

	@JsonProperty("name")
	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	String name;


	@JsonProperty("alias")
	@GraphQLScalar(fieldName = "alias", graphQLTypeSimpleName = "String", javaClass = String.class)
	String alias;


	@JsonProperty("email")
	@GraphQLScalar(fieldName = "email", graphQLTypeSimpleName = "String", javaClass = String.class)
	String email;


	@JsonProperty("type")
	@GraphQLScalar(fieldName = "type", graphQLTypeSimpleName = "MemberType", javaClass = MemberType.class)
	MemberType type;



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	public MemberType getType() {
		return type;
	}


	/**
	 * This method is called during the json deserialization process, by the {@link GraphQLObjectMapper}, each time an
	 * alias value is read from the json.
	 * 
	 * @param aliasName
	 * @param aliasDeserializedValue
	 */
	public void setAliasValue(String aliasName, Object aliasDeserializedValue) {
		aliasValues.put(aliasName, aliasDeserializedValue);
	}

	/**
	 * Retrieves the value for the given alias, as it has been received for this object in the GraphQL response. <BR/>
	 * This method <B>should not be used for Custom Scalars</B>, as the parser doesn't know if this alias is a custom
	 * scalar, and which custom scalar to use at deserialization time. In most case, a value will then be provided by
	 * this method with a basis json deserialization, but this value won't be the proper custom scalar value.
	 * 
	 * @param alias
	 * @return
	 * @throws GraphQLRequestExecutionException
	 *             If the value can not be parsed
	 */
	public Object getAliasValue(String alias) throws GraphQLRequestExecutionException {
		Object value = aliasValues.get(alias);
		if (value instanceof GraphQLRequestExecutionException)
			throw (GraphQLRequestExecutionException) value;
		else
			return value;
	}

    public String toString() {
        return "MemberInput {"
				+ "name: " + name
				+ ", "
				+ "alias: " + alias
				+ ", "
				+ "email: " + email
				+ ", "
				+ "type: " + type
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Name("name"),
		Alias("alias"),
		Email("email"),
		Type("type");

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
		private String name;
		private String alias;
		private String email;
		private MemberType type;


		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withAlias(String alias) {
			this.alias = alias;
			return this;
		}
		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder withType(MemberType type) {
			this.type = type;
			return this;
		}

		public MemberInput build() {
			MemberInput _object = new MemberInput();
			_object.setName(name);
			_object.setAlias(alias);
			_object.setEmail(email);
			_object.setType(type);
			return _object;
		}
	}
}
