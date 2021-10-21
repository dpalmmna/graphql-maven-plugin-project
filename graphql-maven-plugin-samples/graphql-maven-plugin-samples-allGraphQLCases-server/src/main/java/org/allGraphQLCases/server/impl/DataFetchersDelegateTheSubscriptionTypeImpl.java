/**
 * 
 */
package org.allGraphQLCases.server.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.allGraphQLCases.server.Episode;
import org.allGraphQLCases.server.Human;
import org.allGraphQLCases.server.SubscriptionTestParam;
import org.allGraphQLCases.server.util.DataFetchersDelegateTheSubscriptionType;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetchingEnvironment;
import reactor.core.publisher.Flux;

/**
 * @author etienne-sf
 *
 */
@Component
public class DataFetchersDelegateTheSubscriptionTypeImpl implements DataFetchersDelegateTheSubscriptionType {

	@Autowired
	DataGenerator dataGenerator;

	@Override
	public Publisher<Human> subscribeNewHumanForEpisode(DataFetchingEnvironment dataFetchingEnvironment,
			Episode episode) {
		// The Flux class, from Spring reactive, implements the Publisher interface.
		// Let's return one Human, every 0.1 second
		return Flux//
				.interval(Duration.ofMillis(100))// A message every 0.1 second
				.map((l) -> {
					Human h = dataGenerator.generateInstance(Human.class);
					if (!h.getAppearsIn().contains(episode)) {
						h.getAppearsIn().add(episode);
					}
					h.setId(new UUID(0, l));
					return h;
				});
	}

	@Override
	public Publisher<List<Integer>> subscribeToAList(DataFetchingEnvironment dataFetchingEnvironment) {
		// The Flux class, from Spring reactive, implements the Publisher interface.
		// Let's return one list of integer, every 0.1 second
		return Flux//
				.interval(Duration.ofMillis(100))// A message every 0.1 second
				.map((l) -> {
					// This message is a list of two integers
					return Arrays.asList(l.intValue(), 2 * l.intValue());
				});
	}

	@Override
	public Publisher<Date> issue53(DataFetchingEnvironment dataFetchingEnvironment, Date date) {
		// The Flux class, from Spring reactive, implements the Publisher interface.
		// Let's returns one item, the date that has been provided as a parameter
		return Flux//
				.interval(Duration.ofMillis(100))// A message every 0.1 second
				.map((l) -> {
					// This message is always the date provided as a parameter
					return date;
				});
	}

	@Override
	public Publisher<String> subscriptionTest(DataFetchingEnvironment dataFetchingEnvironment,
			SubscriptionTestParam param) {
		if (param.getErrorOnSubscription()) {
			// The client asked that an exception is thrown now
			throw new RuntimeException("Oups, the subscriber asked for an error during the subscription");
		} else if (param.getErrorOnNext()) {
			return Flux//
					.interval(Duration.ofMillis(100))// A message every 0.1 second
					.map((l) -> {
						boolean b = true;
						if (b)
							throw new RuntimeException("Oups, the subscriber asked for an error for each next message");
						// The line below will never get executed. But doing this prevents a compilation error !
						return "won't go there";
					});
		} else if (param.getCompleteAfterFirstNotification()) {
			return Flux.just("The subscriber asked for a complete after the first notification");
		} else if (param.getCloseWebSocketBeforeFirstNotification()) {
			return Flux//
					.interval(Duration.ofMillis(100))// A message every 0.1 second
					.map((l) -> {
						boolean b = true;
						if (b)
							throw new RuntimeException(
									"Oups, the subscriber asked that the web socket get disconnected before the first notification");
						// The line below will never get executed. But doing this prevents a compilation error !
						return "won't go there";
					});
		} else {
			// The client didn't ask for any specific error. Let's return a valid flux, that will sent 10 string each
			// second
			return Flux//
					.interval(Duration.ofMillis(100))// A message every 0.1 second
					.map((l) -> Long.toString(l));
		}
	}
}
