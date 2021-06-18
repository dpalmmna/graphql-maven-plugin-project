/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.server.domain.allGraphQLCases;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInterfaceType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInterfaceType("WithID")
public interface WithID  {

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	public void setId(UUID id);

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	public UUID getId();
}
