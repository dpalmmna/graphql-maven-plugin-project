/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.server.domain.forum;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.reactivestreams.Publisher;

import graphql.schema.DataFetchingEnvironment;

import java.util.Date;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public interface DataFetchersDelegateMutationType {
	
	/**
	 * This method loads the data for MutationType.createBoard. 
	 * <BR/>
	 * <BR/>
	 * 
	 * @param dataFetchingEnvironment 
	 *     The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this DataFetcher
	 * @param name 
	 *     The input parameter sent in the query by the GraphQL consumer, as defined in the GraphQL schema.
	 * @param publiclyAvailable 
	 *     The input parameter sent in the query by the GraphQL consumer, as defined in the GraphQL schema.
	 * @throws NoSuchElementException 
	 *     This method may return a {@link NoSuchElementException} exception. In this case, the exception is trapped 
	 *     by the calling method, and the return is consider as null. This allows to use the {@link Optional#get()} method directly, without caring of 
	 *     whether or not there is a value. The generated code will take care of the {@link NoSuchElementException} exception. 
	 */
	public Board createBoard(DataFetchingEnvironment dataFetchingEnvironment, String  name, Boolean  publiclyAvailable);

	/**
	 * This method loads the data for MutationType.createTopic. 
	 * <BR/>
	 * <BR/>
	 * 
	 * @param dataFetchingEnvironment 
	 *     The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this DataFetcher
	 * @param topic 
	 *     The input parameter sent in the query by the GraphQL consumer, as defined in the GraphQL schema.
	 * @throws NoSuchElementException 
	 *     This method may return a {@link NoSuchElementException} exception. In this case, the exception is trapped 
	 *     by the calling method, and the return is consider as null. This allows to use the {@link Optional#get()} method directly, without caring of 
	 *     whether or not there is a value. The generated code will take care of the {@link NoSuchElementException} exception. 
	 */
	public Topic createTopic(DataFetchingEnvironment dataFetchingEnvironment, TopicInput  topic);

	/**
	 * This method loads the data for MutationType.createPost. 
	 * <BR/>
	 * <BR/>
	 * 
	 * @param dataFetchingEnvironment 
	 *     The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this DataFetcher
	 * @param post 
	 *     The input parameter sent in the query by the GraphQL consumer, as defined in the GraphQL schema.
	 * @throws NoSuchElementException 
	 *     This method may return a {@link NoSuchElementException} exception. In this case, the exception is trapped 
	 *     by the calling method, and the return is consider as null. This allows to use the {@link Optional#get()} method directly, without caring of 
	 *     whether or not there is a value. The generated code will take care of the {@link NoSuchElementException} exception. 
	 */
	public Post createPost(DataFetchingEnvironment dataFetchingEnvironment, PostInput  post);

	/**
	 * This method loads the data for MutationType.createPosts. 
	 * <BR/>
	 * <BR/>
	 * 
	 * @param dataFetchingEnvironment 
	 *     The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this DataFetcher
	 * @param spam 
	 *     The input parameter sent in the query by the GraphQL consumer, as defined in the GraphQL schema.
	 * @throws NoSuchElementException 
	 *     This method may return a {@link NoSuchElementException} exception. In this case, the exception is trapped 
	 *     by the calling method, and the return is consider as null. This allows to use the {@link Optional#get()} method directly, without caring of 
	 *     whether or not there is a value. The generated code will take care of the {@link NoSuchElementException} exception. 
	 */
	public List<Post> createPosts(DataFetchingEnvironment dataFetchingEnvironment, List<PostInput>  spam);

}