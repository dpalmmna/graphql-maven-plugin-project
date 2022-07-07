/**
 * 
 */
package com.graphql_java_generator.client;

import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

/**
 * This interface allows the application to interact with the subscription, once it has subscribed to it. The currently
 * only available action is {@link #unsubscribe()}.<BR/>
 * This instance also allows to retrieve the {@link WebSocketSession} that is connected, if the application needs to
 * interact with it.
 * 
 * @author etienne-sf
 */
public interface SubscriptionClient {

	/**
	 * Allows the client application to unsubscribe from a previously subscribed subscription. No more notification will
	 * be sent for this subscription. <BR/>
	 * This will free resources on both the client and the server.
	 * 
	 * @throws GraphQLRequestExecutionException
	 * 
	 */
	void unsubscribe() throws GraphQLRequestExecutionException;

}
