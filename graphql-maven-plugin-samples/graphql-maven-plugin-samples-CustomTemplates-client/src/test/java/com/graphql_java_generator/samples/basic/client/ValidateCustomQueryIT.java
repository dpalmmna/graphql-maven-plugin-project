package com.graphql_java_generator.samples.basic.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import com.graphql_java_generator.samples.customtemplates.client.graphql.forum.client.Board;
import com.graphql_java_generator.samples.customtemplates.client.graphql.forum.client.Query;
import com.graphql_java_generator.samples.customtemplates.client.graphql.forum.client.QueryExecutor;
import com.graphql_java_generator.samples.customtemplates.client.graphql.forum.client.Subscription;

@SpringBootTest()
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfiguration.class)
class ValidateCustomQueryIT {

	@Autowired
	QueryExecutor query;

	@Test
	void test_customTemplateInTheProject() throws GraphQLRequestPreparationException, GraphQLRequestExecutionException {
		// Let's check that our QueryType is generated from the custom template
		assertTrue(new Subscription().thisIsADummyFieldToCheckThatThisTemplateIsUsed);
	}

	@Test
	void test_customTemplateInAnExternalJar()
			throws GraphQLRequestPreparationException, GraphQLRequestExecutionException {
		// Let's check that our QueryType is generated from the custom template
		assertTrue(new Query().thisIsADummyFieldToCheckThatThisTemplateIsUsed);

		// And that it still works! :)
		List<Board> response = query.boards("{id name}");
		assertNotNull(response);
		assertTrue(response.size() > 0);
		assertTrue(response.get(0) instanceof Board);
	}

}
