/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.client.response;

import graphql.schema.GraphQLScalarType;

/**
 * This class is a standard Deserializer for Jackson. It uses the {@link GraphQLScalarType} that is implemented by the
 * project for this scalar
 */
public class CustomJacksonDeserializerDate extends AbstractCustomJacksonDeserializer<java.util.Date> {

	private static final long serialVersionUID = 1L;

	public CustomJacksonDeserializerDate() {
		super(java.util.Date.class, com.graphql_java_generator.customscalars.GraphQLScalarTypeDate.Date);
	}
}
