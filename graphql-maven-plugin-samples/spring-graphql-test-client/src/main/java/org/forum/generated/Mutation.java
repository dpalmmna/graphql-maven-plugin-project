/** Generated by the default template from graphql-java-generator */
package org.forum.generated;

import java.util.HashMap;
import java.util.Map;

import org.forum.generated.Mutation;
import org.forum.generated.util.CustomJacksonDeserializers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLQuery;
import com.graphql_java_generator.annotation.GraphQLScalar;
import com.graphql_java_generator.annotation.RequestType;

import java.util.List;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLQuery(name = "Mutation", type = RequestType.mutation)
@GraphQLObjectType("Mutation")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class Mutation 
 implements com.graphql_java_generator.client.GraphQLRequestObject{

	private ObjectMapper mapper = null;
	private JsonNode extensions;
	private Map<String, JsonNode> extensionsAsMap = null;

	/**
	 * This map contains the deserialized values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public Mutation(){
		// No action
	}

	@JsonProperty("createBoard")
	@GraphQLInputParameters(names = {"name", "publiclyAvailable"}, types = {"String", "Boolean"}, mandatories = {true, false}, listDepths = {0, 0}, itemsMandatory = {false, false})
	@GraphQLNonScalar(fieldName = "createBoard", graphQLTypeSimpleName = "Board", javaClass = org.forum.generated.Board.class)
	org.forum.generated.Board createBoard;


	@JsonProperty("createTopic")
	@GraphQLInputParameters(names = {"topic"}, types = {"TopicInput"}, mandatories = {false}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "createTopic", graphQLTypeSimpleName = "Topic", javaClass = org.forum.generated.Topic.class)
	org.forum.generated.Topic createTopic;


	@JsonProperty("createPost")
	@GraphQLInputParameters(names = {"post"}, types = {"PostInput"}, mandatories = {true}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "createPost", graphQLTypeSimpleName = "Post", javaClass = org.forum.generated.Post.class)
	org.forum.generated.Post createPost;


	@JsonProperty("createPosts")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListPost.class)
	@GraphQLInputParameters(names = {"spam"}, types = {"PostInput"}, mandatories = {true}, listDepths = {1}, itemsMandatory = {true})
	@GraphQLNonScalar(fieldName = "createPosts", graphQLTypeSimpleName = "Post", javaClass = org.forum.generated.Post.class)
	List<org.forum.generated.Post> createPosts;


	@JsonProperty("createMember")
	@GraphQLInputParameters(names = {"input"}, types = {"MemberInput"}, mandatories = {true}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "createMember", graphQLTypeSimpleName = "Member", javaClass = org.forum.generated.Member.class)
	org.forum.generated.Member createMember;


	@JsonProperty("__typename")
	@GraphQLScalar(fieldName = "__typename", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String __typename;



	public void setCreateBoard(org.forum.generated.Board createBoard) {
		this.createBoard = createBoard;
	}

	public org.forum.generated.Board getCreateBoard() {
		return createBoard;
	}
		

	public void setCreateTopic(org.forum.generated.Topic createTopic) {
		this.createTopic = createTopic;
	}

	public org.forum.generated.Topic getCreateTopic() {
		return createTopic;
	}
		

	public void setCreatePost(org.forum.generated.Post createPost) {
		this.createPost = createPost;
	}

	public org.forum.generated.Post getCreatePost() {
		return createPost;
	}
		

	public void setCreatePosts(List<org.forum.generated.Post> createPosts) {
		this.createPosts = createPosts;
	}

	public List<org.forum.generated.Post> getCreatePosts() {
		return createPosts;
	}
		

	public void setCreateMember(org.forum.generated.Member createMember) {
		this.createMember = createMember;
	}

	public org.forum.generated.Member getCreateMember() {
		return createMember;
	}
		

	public void set__typename(java.lang.String __typename) {
		this.__typename = __typename;
	}

	public java.lang.String get__typename() {
		return __typename;
	}
		

 
	/**
	 * This method is called during the json deserialization process, by the {@link GraphQLObjectMapper}, each time an
	 * alias value is read from the json.
	 * 
	 * @param aliasName
	 * @param aliasDeserializedValue
	 */
	public void setAliasValue(String aliasName, Object aliasDeserializedValue) {
		aliasValues.put(aliasName, aliasDeserializedValue);
	}

	/**
	 * Retrieves the value for the given alias, as it has been received for this object in the GraphQL response. <BR/>
	 * This method <B>should not be used for Custom Scalars</B>, as the parser doesn't know if this alias is a custom
	 * scalar, and which custom scalar to use at deserialization time. In most case, a value will then be provided by
	 * this method with a basis json deserialization, but this value won't be the proper custom scalar value.
	 * 
	 * @param alias
	 * @return
	 */
	public Object getAliasValue(String alias) {
		return aliasValues.get(alias);
	}

    public String toString() {
        return "Mutation {"
				+ "createBoard: " + createBoard
				+ ", "
				+ "createTopic: " + createTopic
				+ ", "
				+ "createPost: " + createPost
				+ ", "
				+ "createPosts: " + createPosts
				+ ", "
				+ "createMember: " + createMember
				+ ", "
				+ "__typename: " + __typename
        		+ "}";
    }

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * The Builder that helps building instance of this POJO. You can get an instance of this class, by calling the
	 * {@link #builder()}
	 */
	public static class Builder {
		private org.forum.generated.Board createBoard;
		private org.forum.generated.Topic createTopic;
		private org.forum.generated.Post createPost;
		private List<org.forum.generated.Post> createPosts;
		private org.forum.generated.Member createMember;

		public Builder withCreateBoard(org.forum.generated.Board createBoard) {
			this.createBoard = createBoard;
			return this;
		}
		public Builder withCreateTopic(org.forum.generated.Topic createTopic) {
			this.createTopic = createTopic;
			return this;
		}
		public Builder withCreatePost(org.forum.generated.Post createPost) {
			this.createPost = createPost;
			return this;
		}
		public Builder withCreatePosts(List<org.forum.generated.Post> createPosts) {
			this.createPosts = createPosts;
			return this;
		}
		public Builder withCreateMember(org.forum.generated.Member createMember) {
			this.createMember = createMember;
			return this;
		}

		public Mutation build() {
			Mutation _object = new Mutation();
			_object.setCreateBoard(createBoard);
			_object.setCreateTopic(createTopic);
			_object.setCreatePost(createPost);
			_object.setCreatePosts(createPosts);
			_object.setCreateMember(createMember);
			_object.set__typename("Mutation");
			return _object;
		}
	}
	private ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}
	
	public JsonNode getExtensions() {
		return extensions;
	}
	
	public void setExtensions(JsonNode extensions) {
		this.extensions = extensions;
	}
	
	/**
	 * Returns the extensions as a map. The values can't be deserialized, as their type is unknown.
	 * 
	 * @return
	 */
	public Map<String, JsonNode> getExtensionsAsMap() {
		if (extensionsAsMap == null) {
			ObjectMapper mapper = new ObjectMapper();
			extensionsAsMap = mapper.convertValue(extensions, new TypeReference<Map<String, JsonNode>>() {
			});
		}
		return extensionsAsMap;
	}
	
	/**
	 * Parse the value for the given _key_, as found in the <I>extensions</I> field of the GraphQL server's response,
	 * into the given _t_ class.
	 * 
	 * @param <T>
	 * @param key
	 * @param t
	 * @return null if the key is not in the <I>extensions</I> map. Otherwise: the value for this _key_, as a _t_
	 *         instance
	 * @throws JsonProcessingException
	 *             When there is an error when converting the key's value into the _t_ class
	 */
	public <T> T getExtensionsField(String key, Class<T> t) throws JsonProcessingException {
		JsonNode node = getExtensionsAsMap().get(key);
		return (node == null) ? null : getMapper().treeToValue(node, t);
	}
}