/**
 * 
 */
package com.graphql_java_generator.samples.forum.client;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.graphql_java_generator.client.SubscriptionClient;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import com.graphql_java_generator.samples.forum.client.graphql.forum.client.GraphQLRequest;
import com.graphql_java_generator.samples.forum.client.graphql.forum.client.SubscriptionType;

/**
 * This class allows to manually test subscription. It subscribes to the GraphQL subscription subscribeToNewPost defined
 * in the forum GraphQL schema.<BR/>
 * Then:
 * <UL>
 * <LI>Start the Forum server (by executing its generated GraphQLMain java class)</LI>
 * <LI>Execute this class</LI>
 * <LI>Create Posts by using graphiql, available at this URL:
 * <A HREF="http://localhost:8180/graphiql">http://localhost:8180/graphiql</A> once you start the Forum server</A></LI>
 * </UL>
 * And you'll see the newly created posts beeing displayed by this class, as it subscribed to the subscribeToNewPost
 * GraphQL subscription.
 * 
 * 
 * @author etienne-sf
 */
public class ManualSubscriptionTest {

	SubscriptionType subscriptionType;
	GraphQLRequest subscriptionRequest;
	public static Thread currentThread;

	public static void main(String... args) throws Exception {
		new ManualSubscriptionTest().exec();
	}

	ManualSubscriptionTest() throws GraphQLRequestPreparationException {
		subscriptionType = new SubscriptionType("http://localhost:8180/graphql/subscription");
		subscriptionRequest = subscriptionType
				.getSubscribeToNewPostGraphQLRequest("{id date author publiclyAvailable title content}");
		currentThread = Thread.currentThread();
	}

	private void exec() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {

		System.out.println("Subscribing to the GraphQL subscription");
		SubscriptionClient client = subscriptionType.subscribeToNewPost(subscriptionRequest,
				new PostSubscriptionCallback(), "Board name 1");

		// Let's wait 10 minutes (600 seconds), so that we display the received notifications during this time
		try {
			Thread.sleep(600 * 1000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted");
		}

		client.unsubscribe();
		System.out.println("Stopped listening");
	}

	private void exec2() throws Exception {
		System.out.println("Creating container");
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		System.out.println("Connecting");
		String uri;
		uri = "ws://localhost:8080/stockticker";
		uri = "ws://localhost:8180/graphql";
		try (Session session = container.connectToServer(PostSubscriptionCallback.class, URI.create(uri))) {
			System.out.println("Sending request");
			session.getBasicRemote().sendObject("A test");
		}

		// Let's wait 10 minutes (600 seconds), so that we display the received notifications during this time
		try {
			Thread.sleep(600 * 1000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted");
		}

		// client.unsubscribe();
		System.out.println("Stopped listening");
	}
}