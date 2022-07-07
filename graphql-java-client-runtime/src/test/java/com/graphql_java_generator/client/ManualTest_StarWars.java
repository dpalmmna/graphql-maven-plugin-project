package com.graphql_java_generator.client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.graphql_java_generator.domain.client.starwars.Character;
import com.graphql_java_generator.domain.client.starwars.Episode;
import com.graphql_java_generator.domain.client.starwars.Human;
import com.graphql_java_generator.domain.client.starwars.QueryType;

/**
 * Manual test for query execution. Not a JUnit test. The automation for this test is done in the
 * graphql-maven-plugin-samples-StarWars-server module. This class is done for manual testing of the client, before
 * checking all around with the maven build of all modules.
 * 
 * @author etienne-sf
 */
public class ManualTest_StarWars {

	String graphqlEndpoint = "https://localhost:8443/graphql";
	QueryType queryType;

	public static void main(String[] args) throws Exception {
		new ManualTest_StarWars().exec();
	}

	public void exec() throws Exception {
		queryType = new QueryType(graphqlEndpoint, getSslContext(), new NoOpHostnameVerifier());

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////// Short way: your write the GraphQL yourself
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("------------------    executeHero()    ----------------------------------------------");

		// Execution of the query. We get the result back in a POJO
		Character character = queryType.hero("{id name friends {id name appearsIn friends{id name}}}", Episode.NEWHOPE);

		System.out.println(character);

		//

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("------------------    executeHuman()    ---------------------------------------------");

		// Execution of the query. We get the result back in a POJO
		Human human = queryType.human("{id name appearsIn homePlanet friends{name}}",
				"00000000-0000-0000-0000-000000000180");

		System.out.println(human);

		System.out.println("");
		System.out.println("");
		System.out.println("Sample application finished ... enjoy !    :)");
		System.out.println("");
		System.out.println("(please take a look at the other samples, for other use cases)");
	}

	private SSLContext getSslContext() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContext.getInstance("TLSv1");

		KeyManager[] keyManagers = null;
		TrustManager[] trustManager = { new NoOpTrustManager() };
		SecureRandom secureRandom = new SecureRandom();

		sslContext.init(keyManagers, trustManager, secureRandom);

		return sslContext;
	}

	public class NoOpTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}
	}

	public class NoOpHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String s, SSLSession sslSession) {
			return true;
		}
	}
}
