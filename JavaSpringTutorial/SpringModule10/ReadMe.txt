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

#################################################################
Add Security Filter
#################################################################
To add the login page provided by spring we must first add a security filter. 
Right click pom.xml > click dependencies tab > add spring-security-core, spring-security-web, and spring-security-config

Update Maven dependencies

Right click SpringModule10 > New > Filter >  Check "Use existing filter class" > DelegatingFilterProxy > Name it exactly "springSecurityFilterChain"
in web.xml change url-pattern value to the following <url-pattern>/*</url-pattern>

Right click spring.web.config package > New > Other > Spring Beans Configuration file > "security-context.xml"
In config file, go to Namespaces > check security namespace

Click on sec tab > Right click beans > Insert <security:authentication-manager> element > 
Right click the new element > Insert <security-authentication-provider> element > 
Right click the new element > Insert <user-service> element > 
Right click the new element > Insert <security:user> element > fill in users name/password/authorities (admi, etc..)

Right click beans > Insert <security:http> element > set "use-expressions" property to true >
Right click <security:http> element > Insert <security:intercept-url> element > set pattern to "/**" and access to "denyAll"
Right click <security:http> element > Insert <security:form-login> element >
Copy current <security:intercept-url> and make pattern of "/", "/offers", "" to have access "permit all"

#################################################################
Create Custom Login Form
#################################################################

Create new login.jsp and have it use style.css similar to other jsp files and add same class to .
Add new LoginController to handle requests of login and have the method taking "/login" return login to map to the login.jsp.
Tell spring to use new login by clicking on security-context.xml > sec > expand http bean > click form-login > set login-page to /login
In spring 4 we need to add
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
in the header and
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
in the table brackets because the _csrf is now hashed

When creating our own login page we lose the automatic error messages provided by spring and to get those back we must do the following.
In security-context.xml go to the sec tab > expand the http bean > click on the form-login bean > and add /login?error=true to the authentication-failure-url
The error parameter is set just to indicate there was an error and we can use jstl to do the rest.
Add jstl core <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> to login.jsp
Add <c:if test="${param.error != null}"> check and within the tags put the error message. If the error param exists it will print the error.


#################################################################
Connect user login to a database
#################################################################

To connect the user login to a database, we must go to the security-context.xml go to the sec tab > 
right-click authentication manager > insert authentication-provider
right-click the new authentication-provider element > choose insert jdbc-user-service > 
point service to dataSource ref in dao-context.xml created in previous tutorial.

Now 

Why is login.jsp using ${pageContext.request.contextPath}/j_spring_security_check and not ${pageContext.request.contextPath}/login? on john's form in video 99/100

#################################################################
Logout user 
#################################################################
Create new jsp loggedout.jsp
In security-context.xml 
    add <security:intercept-url pattern="/loggedout" access="permitAll" /> to http element
    right click http element and insert security:logout and set logout-success-url to /loggedout.jsp 
    
    Add <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
        <input type="submit" value="Log out"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    to logout page in order to enable the ability to logout in Spring 4
    
#################################################################
User Roles
#################################################################
Add pattern in security-context.xml <security:intercept-url pattern="/admin" access="hasRole('ADMIN')" />
To find all security patterns like hasRole(), isAuthenticated(), etc.. search Google "spring security pattern"

**IMPORTANT NOTE**
Make sure that the user roles instead of being just 'admin' and 'user', that they follow the spring convention of 'ROLE_ADMIN' and 'ROLE_USER'
in your database. You can keep out the "ROLE_" part in the security access patterns.
    
    https://docs.spring.io/spring-security/site/docs/4.2.2.RELEASE/reference/html/el-access.html
    Add this tag to your home.jsp
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
    use
    <sec:authorize access="isAuthenticated()"> Only allows authorized users to see</sec:authorize>
#################################################################
Map rows of database
#################################################################
    
    Adding the below statement with a query that has all the necessary matching fields from the database to the class methods
    (e.g. 'username' to setUsername()) will automatically map all rows selected by query to List of Users.
    
    List<User> users = jdbc.query("select * from users, authorities where users.username=authorities.username", BeanPropertyRowMapper.newInstance(User.class));
    
#################################################################
Method level access control
#################################################################
In security-context.xml add the tag <security:global-method-security  secured-annotations="enabled">
Add @Secured("ADMIN") to any method you want to specify for securing


**IMPORTANT NOTE**
In order for this to work I needed to make sure my component-scanning was configured correctly in my main bean config (offers-servlet.xml).
It was..
<context:component-scan base-package="us.brianolsen.spring.web"></context:component-scan>
and I suppose that scanning
<context:component-scan base-package="us.brianolsen.spring.web.controller"></context:component-scan>

To show specific jsp in the event that the method level access is denied do the following:
In security-context.xml, go to the sec tab > right click the http bean > add <security:access-denied-handler error-page="/denied" />

#################################################################
Remember me
#################################################################
In web.xml add <session-config><session-timeout>20</session-timeout></session-config>
In security-context.xml go to the sec tab > right click the http bean > add <security:remember-me > tag
In remember-me ui add random key like "offersAppKey" to key
Then to refer to a specific user provider (as you may have multiple databases/providers) add random key "jdbcUserService" to user-service-ref
In authentication-manager > authentication-provider > jdbc-user-service type "jdbcUserService" to id

In login.jsp add a checkbox with exact name "remember-me"

#################################################################
Encrypting passwords
#################################################################
In security-context.xml go to the beans and add 
<bean id="passwordEncoder" class="org.springframework.security.crypto.password.StandardPasswordEncoder"></bean>
In sec tab in authentication-manager > authentication-provider > jdbc-user-service add <security:password-encoder ref="passwordEncoder">

In UsersDAO add 
@Autowired
private PasswordEncoder passwordEncoder; //connects us to bean with StandardPasswordEncoder

MapSqlParameterSource params = new MapSqlParameterSource();
		
params.addValue("username", user.getUsername());
params.addValue("password", passwordEncoder.encode(user.getPassword()));
params.addValue("email", user.getEmail());
params.addValue("enabled", user.isEnabled());
params.addValue("authority", user.getAuthority());

