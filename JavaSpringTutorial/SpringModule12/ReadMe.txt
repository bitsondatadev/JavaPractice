#Spring Module 12 - Logging and Testing

#################################################################
Maven Conflicts
#################################################################
Sometimes there are conflicts between sub-dependencies of different modules. For example different modules depend on different
versions of log4j logging implementations. To resolve this go to pom dependency hierarchy and find conflicting module under
Resolved Dependencies. Click on conflicting module and right-click on its location in the Dependency hierarchy and "Exclude Maven Artifact".

#################################################################
Spring Profiles
#################################################################
In dao-context.xml surround the existing datasource implementations with <beans profile="foo"></beans>.
Now you can make multiple profiles for different environments that have variable settings changed.

To choose a specific profile spring has a parameter you can set as follows
-Dspring.profiles.active=foo

An alternative would be to set the variable in web.xml which can be done by adding the following.
  <context-param>
  <param-name>spring.profiles.active</param-name>
  <param-value>foo</param-value>
  </context-param>

#################################################################
Set up for test
#################################################################

Add junit, commons-dbcp