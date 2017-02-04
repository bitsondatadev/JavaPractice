#Spring Module 10 - Spring Security and Managing Users

Notes on set up...
#################################################################
BASIC SET UP
#################################################################

First project was set up using 
New > Project > Web > Dynamic Web Project

Select Tomcat server using Dynamic web module version 2.5. (for use of web.xml)
Make sure Generate web.xml checkbox is checked before finishing the wizard.

Make a new folder under the WebContent/WEB-INF folder called jsps.
Then right click jsps and go to (New > JSP File) and call your it home.jsp.

#################################################################
MAVEN 
#################################################################
Right-click on the project and click Configure > Convert to Maven Project
Add all required Spring jars and Right-Click the project Maven > Update Project

Spring Jars
core, beans, context jdbc, web, webmvc
#################################################################
DISPATCHER SERVLET
#################################################################
DispatcherServlet is Spring MVC's implementation of the front controller pattern. 
Essentially, it's a servlet that takes the incoming request, and delegates processing of that 
request to one of a number of handlers, the mapping of which is specific in the DispatcherServlet configuration.

Right-click project New > Servlet

In wizard check Use an existing Servlet class or JSP and search for Dispatcher Servlet

In WEB-INF/web.xml change display-name(optional) and servlet-name of DispatcherServlet (we called it offers) 
We also want to change servlet-name under the mapping to match the name in servlet tags. and finally change the url patter accordingly.

In servlet under servlet-class tag add load-on-startup tag and place 1 inside.

Dispatcher Bean Configs
Add beans in <name>-servlet.xml
In Namespaces tab of xml make sure beans, context and mvc are checked.

In context tab right-click bean <context:component-scan> and put base package of models (scan for beans)

In mvc tab right-click bean <mvc:annotation-driven> (enables annotations)


#################################################################
CONTROLLER
#################################################################
Right-click on project New > Class > <name>Controller.java
Add @Controller annotation on class

Add method with signature public String showHome() and add @RequestMapping("/") annotation and return string "<jspFileName>"

#################################################################
VIEW RESOLVER
#################################################################
Takes the name given by the Dispatcher servlet and translate it into an actual view (JSP page) to return and display.
Under WEB-INF add a folder for jsps called WEB-INF/jsps and put all .jsp files in this folder.

In <name>-servlet.xml in beans tab click New Bean
Give name jspViewResolver and set the class org.springframework.web.servlet.view.InternalResourceViewResolver
right click beans > insert <property> element set name to "prefix" and value to "WEB-INF/jsps/"
right click beans > insert <property> element set name to "suffix" and value to ".jsp"

Should be able to run by right-clicking project > Run As.. > Run on Server > Tomcat Server

#################################################################
JSTL
#################################################################
The JavaServer Pages Standard Tag Library (JSTL) is a collection of useful 
JSP tags which encapsulates core functionality common to many JSP applications.

First, add the urls needed described in one of the sites below...
http://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html
https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm

#################################################################
JNDI (Java Naming and Directory Interface)
#################################################################
The Java Naming and Directory Interface (JNDI) is a Java API for a directory service that 
allows Java software clients to discover and look up data and objects via a name. Like 
all Java APIs that interface with host systems, JNDI is independent of the underlying 
implementation.

Look up server (Tomcat in our case) and database (MySQL in our case) and JDNI and you 
should find instructions like this...
https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#MySQL_DBCP_Example

Sine the database is already set up you can add a resource tag to the context.xml and connection 
handle to web.xml.

The url I had to use was jdbc:mysql://localhost:3306/<databasename>?serverTimezone=CST
because for some reason I defaulted ot CDT for timezone and this caused an error with conficting names.

#################################################################
Add DAO Code
#################################################################
In order to add DAO code we need to define a new xml configuration for dao code (dao-context.xml or whatever).

In order to do context scanning in web projects you have to add a listener in web.xml file.
Do this by adding <listener> tags and inside the tags add <listener-class> tags and put the
org.springframework.web.context.ContextLoaderListener in it.

Now add a context-param tag underneath listern and inside add a param-name tag and add contextConfigLocation inside.
Then add a context-value tag under param-value with classpath:path/to/dao-context.xml

Now OffersDao Component can be loaded but we use the Autowired annotation for DataSource and have not defined a data source bean
yet so we should still expect an error. Prior in the Database Module (Module 6) we created a BasicDataSource bean using the apache
class and loading it with the required parameters. Now instead we will do the following:

In the dao-context.xml Go to Namespace and check jee, right click on bean and add jee:jndi-lookup with the properties.