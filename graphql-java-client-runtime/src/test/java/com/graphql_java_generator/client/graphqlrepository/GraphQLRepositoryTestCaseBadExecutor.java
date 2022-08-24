package com.graphql_java_generator.client.graphqlrepository;

import com.graphql_java_generator.domain.client.allGraphQLCases.CharacterInput;
import com.graphql_java_generator.domain.client.allGraphQLCases.MyQueryTypeExecutorMySchema;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

/**
 * This interface contains the test cases for the {@link GraphQLRepositoryInvocationHandler} tests
 * 
 * @author etienne-sf
 */
@GraphQLRepository(queryExecutor = MyQueryTypeExecutorMySchema.class)
public interface GraphQLRepositoryTestCaseBadExecutor {

	/** The return type of this method is not the good one */
	@PartialRequest(request = "{appearsIn name}")
	public Integer withOneOptionalParam(CharacterInput character) throws GraphQLRequestExecutionException;

}
