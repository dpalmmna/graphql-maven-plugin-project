# GraphQL Maven Plugin

This project is a maven plugin, which makes it easy to work in Java with graphQL in a schema first approach.

TODO : 
- Client : personalize the endpoint
- Serveur : personalize the port number
- Serveur : howto reply with a fonctionnal error

## Aim of this projet

The aim of this project is to:

* Hide all the GraphQL technical stuff and boilerplate code
* Let the developper concentrate on his applicaiton
* Make it __very easy__ to create a GaphQL client, based on the generated POJOs. The calls to the GraphQL server are just the call of a generated Java method, with Java parameters 
* Make it __easy__ to create a GraphQL server. The plugin generated the server boilerplate code and the POJOs. But it's still up to the developper to map the GraphQL schema to the database schema. See the provided samples for different ways to do this. The generated code integrate the JPA schema, making the database access easy, thanks to the Spring Data Repositories.

In the near future :
* Implement also Mutations and Subscriptions. Currently only queries are managed.
* Provides implementation for the GraphQL best practices, including the dataloader (very important for performance, see [https://github.com/graphql-java/java-dataloader](https://github.com/graphql-java/java-dataloader)).    


## How to use it

### Client mode

When in _client_ mode, you can query the server with just one line of code.

For instance :

```Java
Human human = queryType.human("{id name appearsIn homePlanet friends{name}}", "180");
```

Where human is a POJO, that you can manipulate as any java object. This POJOs and the QueryType(s) are generated at build time, from the GraphQL schema, by the Maven Plugin. 

A _good idea_ is to prepare the queries at startup time. Doing this executes all the GraphQL query checks during the application startup. And
then, the ObjectResponse for these queries is built only once, instead of each query execution.

To prepare the queries during startup, it can a be a Spring Bean (like below), or a standard class initialization (like in the samples, see the Forum client and StarWars client)

```Java
	@Bean
	ObjectResponse heroResponse(QueryType queryType) {
		return queryType.getHeroResponseBuilder().build();
	}
```
Doing this allows you to use this ObjectResponse, later on, like this: 

```Java
	Character hero = queryType.hero(heroResponse, Episode.NEWHOPE);
```
 
When you want to also query sub-objects of the queried object, you'll have to describe what's to be returned. This is done by calling additional methods to the builder.

In the sample below, the _withQueryResponseDef_ allows you to define the _Character_'s field (as _hero_ query returns a _Character_), and to define all subobjects
that will be queried. In one method call, you can define several level of subobjects. Here, you go down to the friends of the friends of the hero's friends.

With _withQueryResponseDef_, you only defined the content of the response. GraphQL Java Generator will add the query name, and it(s) parameter(s), properly encoded before sending the request to the GraphQL server.

```Java
		// ObjectResponse (preparation of the query). 
		// This will throw a GraphQLRequestPreparationException, if the request is not valid.
		ObjectResponse objectResponse = queryType.getHeroResponseBuilder().
				.withQueryResponseDef(
						"{id appearsIn name friends {name friends {friends{id name appearsIn}}} primaryFunction }")
				.build();

		// Execution of the query. We get the result back in a POJO
		// This will throw a GraphQLExecutionException if an error occurs during execution
		Character hero = queryType.hero(objectResponse, Episode.NEWHOPE);
```
 
You can also use a Builder to generate the query, by adding field by field, and subobject by subobject, like below. Of course, it's more verbose.

```Java
		// ObjectResponse
		ObjectResponse objectResponse = queryType.getHeroResponseBuilder().withField("id").withField("name")
				.withField("appearsIn")
				.withSubObject("friends", ObjectResponse.newSubObjectBuilder(Character.class).withField("name").build())
				.build();

		// Execution of the query. We get the result back in a POJO
		Character hero = queryType.hero(objectResponse, Episode.NEWHOPE);
```
 
_Note: In all cases, an ObjectResponse is built. This will help to add future functionnalities_. For instance, in the near future, when you access a field, the generated code will check that this field has actually been queried.


### Server mode

The server mode is more complex, as its subject is to link the GraphQL schema to the underlying data structure. This data structure can vary a lot (relational database with lots of possible physical schema, document database like MongoDB, underlying JSON services...). Of course, the generated code can not guess what's your data structure, and how to access it.

So the GraphQL Java Generator generates:
* The GraphQLServer class, wich is the executable Java class. It's actually a Spring Boot application.
    * TODO: in the future, it will also be possible to generate war packages.
* The code expected by the graphql-java library. It depends on no other graphql dependency
* The POJOs, so that you can manipulate your data.
* JPA annotations on the POJO's fields, so that you can with Spring Data (or Hibernate) with a minimum of additional work. 
    * If these annotations don't fit your needs, you can add or replace annotations for the JPA entities and their field, through a configuration file. You can find a sample for that in the Forum server sample. Take a look at the src/main/graphql/forum_personalization.json file.
    * In the future, we'll open the capability to define your own templates, so that the generated code fits exactly in your needs
* The DataFetchersDelegate interfaces. This is entry point, where you'll define how to access to the underlying data structure. There is a DataFetchersDelegate interface for each query, mutation and subscription defined in the GraphQL schema. To find all the DataFetchersDelegate you have to implement, you can either navigate to the generated code, and find all the XxxDataFetchersDelegate java files. Or do it in test and learn: when the GraphQL server starts, it searches for the a spring component for each XxxDataFetchersDelegate generated interface. So it will complains for the missing DataFetchersDelegate.        

Then do a first build :
```
mvn clean install
```

The build will complain about the Data Fetchers Delegate you need to define. 

The short story is this one:
* The code generated by the GraphQL maven plugin directly maps to the entity, thanks to [Spring Data JPA](https://spring.io/projects/spring-data-jpa)'s magic.
* The developper still needs to develop the DataFetchers, to manage the relation between objects (see the samples and below, to see how to do this).

A longer story is this one:
* The GraphQL maven plugin expects a database model that is the same as what's in the GraphQL schema. That is: for each GraphQL object, there is a 
table with the same name, and for each field of each of these GraphQL objects, there is a column with the same name and type. This insure the JPA
access to the database. 
* In GraphQL request, a critical factor for performance is the way to query relations between objects. The [graphql-java site](https://www.graphql-java.com/documentation/v12/batching/)
is very clear on this subject. So the maven plugin mark every relational field as transient, and let the developper manage these relations.

So you have to create the Data Fetchers. You can take a look at the projets that are within the graphql-maven-plugin-samples.

Then... you're app is ready to go!
:)


You can access to the GraphQL server with this URL: [http://localhost:8180/graphiql](http://localhost:8180/graphiql). With this interface, you can test your server, by typing any GraphQL query. You'll have some help to type correct values.

You can access to the H2 Console with this URL: [http://localhost:8180/h2-console/](http://localhost:8180/h2-console/). The jdbc URL to connect to the database is: jdbc:h2:mem:testdb. login: sa, no password.


## State of the project

### Main evolutions for the near future

You'll find below the main changes, that are foreseen in the near future
- Manage Mutations and Subscriptions. Currently, GraphQL Java Generator manages only queries.
- Generate the package as a jar or war form. Currently, GraphQL Java Generator generates a Spring Boot application.
- Add a gradle plugin
- Manage properties which name is a java keyword, like: public, private, class...
- Manage field parameters. Currently, GraphQL Java Generator accepts only parameters at the query level
- Comments should be reported in the generated code, especially the POJOs and the queries, mutations and subsciptions
- Define specific Scalars (for instance Date, DateTime, Time)
- The plugin currently manages only one schema. It would be nice to allow several graphqls files, with a pattern like /*.graphqls
- Fragment in graphql queries


### Note for contributors

This projet is a maven plugin project. 

If you want to compile it, you'll have to add the lombok.jar file in your IDE. Please see the relevant section, in the Install menu of the [https://projectlombok.org/](https://projectlombok.org/) home page. This very nice tools generates all java boiler plate code, like setters, getters, constructors from fields...



# License

`graphql-maven-plugin` is licensed under the MIT License. See [LICENSE](LICENSE.md) for details.
