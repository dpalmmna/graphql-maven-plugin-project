package ${package};

import java.util.NoSuchElementException;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

/**
 * @author generated by graphql-maven-plugin
 * @See https://github.com/graphql-java-generator/graphql-java-generator
 */
@Component
public class GraphQLDataFetchers {

	/** The logger for this instance */
	protected Logger logger = LogManager.getLogger();

#foreach ($dataFetcherDelegate in $dataFetcherDelegates)
	@Resource
	${dataFetcherDelegate.name} ${dataFetcherDelegate.camelCaseName};

#end

#foreach ($dataFetcherDelegate in $dataFetcherDelegates)
	////////////////////////////////////////////////////////////////////////////////////////////////
	// Data fetchers for ${dataFetcherDelegate.name}
	////////////////////////////////////////////////////////////////////////////////////////////////
#foreach ($dataFetcher in $dataFetcherDelegate.dataFetchers)

	public DataFetcher<#if(${dataFetcher.field.list})Iterable<#end${dataFetcher.field.type.classSimpleName}#if(${dataFetcher.field.list})>#end> ${dataFetcher.camelCaseName}() {
		return dataFetchingEnvironment -> {
#foreach ($argument in $dataFetcher.field.inputParameters)
			${argument.type.classSimpleName} ${argument.camelCaseName} = dataFetchingEnvironment.getArgument("${argument.name}");
#end
#if($dataFetcher.sourceName)
			${dataFetcher.sourceName} source = dataFetchingEnvironment.getSource();
#end

#if (${dataFetcher.field.list})
			Iterable<${dataFetcher.field.type.classSimpleName}> ret = ${dataFetcherDelegate.camelCaseName}.${dataFetcher.camelCaseName}(dataFetchingEnvironment#if($dataFetcher.sourceName), source#end#foreach($argument in $dataFetcher.field.inputParameters), ${argument.camelCaseName}#end);
			if (logger.isDebugEnabled()) {
				int nbLines = 0;
				for (${dataFetcher.field.type.classSimpleName} x : ret)
					nbLines += 1;
				logger.debug("${dataFetcher.name}: {} found rows", nbLines);
			}
			return ret;
#else
			${dataFetcher.field.type.classSimpleName} ret = null;
			try {
				ret = ${dataFetcherDelegate.camelCaseName}.${dataFetcher.camelCaseName}(dataFetchingEnvironment#if($dataFetcher.sourceName), source#end#foreach($argument in $dataFetcher.field.inputParameters), ${argument.camelCaseName}#end);
				logger.debug("${dataFetcher.name}: 1 result found");
			} catch (NoSuchElementException e) {
				// There was no items in the Optional
				logger.debug("${dataFetcher.name}: no result found");
			}
			return ret;
#end
		};
	}

#end
#end
}