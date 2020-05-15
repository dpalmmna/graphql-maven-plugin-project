/** Generated by the default template from graphql-java-generator */
package ${packageUtilName};

#if (${pluginConfiguration.separateUtilityClasses})
import ${pluginConfiguration.packageName}.${object.javaName};
#end

#foreach($import in ${object.imports})
import $import;
#end

/**
 * This class is deprecated. Please use the #if(${pluginConfiguration.separateUtilityClasses})${pluginConfiguration.packageName}.#end${object.javaName} instead.<BR/>
 * It is still generated, for compatibility reason: removing it would break existing application's code. <BR/>
 * It will be removed in 2.0 version
 * 
 * @author etienne-sf
 * @deprecated Please use the {@link ${object.javaName}} class instead.
 */
@Deprecated
${object.annotation}
public class ${object.javaName}Response extends ${object.javaName} {

}
