/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.server.domain.forum;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.WebRequest;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring.Builder;
import graphql.spring.web.servlet.ExecutionInputCustomizer;
import graphql.spring.web.servlet.GraphQLInvocation;
import graphql.spring.web.servlet.GraphQLInvocationData;
import graphql.spring.web.servlet.OnDemandDataLoaderRegistry;
import graphql.spring.web.servlet.components.DefaultGraphQLInvocation;

import com.graphql_java_generator.server.util.BatchLoaderDelegate;

import java.util.Date;

/**
 * This class is responsible for providing all the GraphQL Beans to the graphql-java Spring Boot integration.
 * <BR/><BR/>
 * Based on the https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/ tutorial
 * 
 * @author etienne-sf
 */
@Component
public class GraphQLWiring {

	/** The logger for this instance */
	protected Logger logger = LoggerFactory.getLogger(GraphQLWiring.class);

	@Autowired
	protected GraphQLDataFetchers graphQLDataFetchers;

	protected RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
			//
			// Wiring every custom scalar definitions
			.scalar(com.graphql_java_generator.customscalars.GraphQLScalarTypeDate.Date)
			//
			// Wiring every GraphQL type
			.type("QueryType", typeWiring -> addWiringForQueryType(typeWiring))
			.type("MutationType", typeWiring -> addWiringForMutationType(typeWiring))
			.type("SubscriptionType", typeWiring -> addWiringForSubscriptionType(typeWiring))
			.type("Board", typeWiring -> addWiringForBoard(typeWiring))
			.type("Topic", typeWiring -> addWiringForTopic(typeWiring))
			.type("Post", typeWiring -> addWiringForPost(typeWiring))
			.type("Member", typeWiring -> addWiringForMember(typeWiring))
			//
			// Let's finish the job
			.build();
	} // buildWiring()


	/**
	 * Wiring for the QueryType object type. This method actually calls the 
	 * <I>getQueryType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getQueryType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForQueryType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("boards", graphQLDataFetchers.dataFetchersDelegateQueryTypeBoards());
		typeWiring.dataFetcher("nbBoards", graphQLDataFetchers.dataFetchersDelegateQueryTypeNbBoards());
		typeWiring.dataFetcher("topics", graphQLDataFetchers.dataFetchersDelegateQueryTypeTopics());
		typeWiring.dataFetcher("findTopics", graphQLDataFetchers.dataFetchersDelegateQueryTypeFindTopics());
		return typeWiring;
	}

	/**
	 * Wiring for the MutationType object type. This method actually calls the 
	 * <I>getMutationType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getMutationType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForMutationType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("createBoard", graphQLDataFetchers.dataFetchersDelegateMutationTypeCreateBoard());
		typeWiring.dataFetcher("createTopic", graphQLDataFetchers.dataFetchersDelegateMutationTypeCreateTopic());
		typeWiring.dataFetcher("createPost", graphQLDataFetchers.dataFetchersDelegateMutationTypeCreatePost());
		typeWiring.dataFetcher("createPosts", graphQLDataFetchers.dataFetchersDelegateMutationTypeCreatePosts());
		typeWiring.dataFetcher("createMember", graphQLDataFetchers.dataFetchersDelegateMutationTypeCreateMember());
		return typeWiring;
	}

	/**
	 * Wiring for the SubscriptionType object type. This method actually calls the 
	 * <I>getSubscriptionType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getSubscriptionType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForSubscriptionType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("subscribeToNewPost", graphQLDataFetchers.dataFetchersDelegateSubscriptionTypeSubscribeToNewPost());
		return typeWiring;
	}

	/**
	 * Wiring for the Board object type. This method actually calls the 
	 * <I>getBoard_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getBoard_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForBoard(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("topics", graphQLDataFetchers.dataFetchersDelegateBoardTopics());
		return typeWiring;
	}

	/**
	 * Wiring for the Topic object type. This method actually calls the 
	 * <I>getTopic_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getTopic_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForTopic(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("author", graphQLDataFetchers.dataFetchersDelegateTopicAuthorWithDataLoader());
		typeWiring.dataFetcher("posts", graphQLDataFetchers.dataFetchersDelegateTopicPosts());
		return typeWiring;
	}

	/**
	 * Wiring for the Post object type. This method actually calls the 
	 * <I>getPost_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getPost_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForPost(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("author", graphQLDataFetchers.dataFetchersDelegatePostAuthorWithDataLoader());
		return typeWiring;
	}

	/**
	 * Wiring for the Member object type. This method actually calls the 
	 * <I>getMember_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getMember_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForMember(TypeRuntimeWiring.Builder typeWiring) {
		return typeWiring;
	}

	
}
