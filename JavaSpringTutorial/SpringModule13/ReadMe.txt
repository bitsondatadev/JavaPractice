#Spring Module 13 - Improving the "Offers" Web Application

#################################################################
One thing about how maven reads in resources etc...
#################################################################
You are trying to build context from classpath. Thus you have to locate your config file accessible from a classpath of your project.

You using Maven for building your project. Maven has defined project structure for code sources and for resources:

/src/main/java  
/src/main/resorces

If you want to make your file accessible from classpath you have to put it exactly under - resources/ folder:

See more here:
https://stackoverflow.com/questions/42833222/filenotfoundexception-in-spring

#################################################################
To get user information from security context
#################################################################

First add java.security.Principal as a parameter in the doCreate method.
To access the current logged in username, do the following.
String username = principal.getName();

This can be used when inserting the username column of the new offer record.