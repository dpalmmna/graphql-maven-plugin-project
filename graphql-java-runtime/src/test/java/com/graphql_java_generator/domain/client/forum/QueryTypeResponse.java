/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.forum;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLQuery;
import com.graphql_java_generator.annotation.GraphQLScalar;
import com.graphql_java_generator.annotation.RequestType;
import java.util.List;

/**
 * This class is deprecated. Please use the QueryType instead.<BR/>
 * It is still generated, for compatibility reason: removing it would break existing application's code. <BR/>
 * It will be removed in 2.0 version
 * 
 * @author etienne-sf
 * @deprecated Please use the {@link QueryType} class instead.
 */
@Deprecated
@GraphQLQuery(name = "QueryType", type = RequestType.query)
@GraphQLObjectType("QueryType")
public class QueryTypeResponse extends QueryType {

}