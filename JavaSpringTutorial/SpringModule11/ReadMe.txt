#Spring Module 11 - Apache Tiles and Spring MVC

#################################################################
Adding the dependencies for Tiles.
#################################################################
In pom I added the three main dependencies below and two sub-dependencies that were required:
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>3.0.7</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-servlet</artifactId>
			<version>3.0.7</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-jsp</artifactId>
			<version>3.0.7</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.25</version>
		</dependency>
		<dependency>
			<groupId>org.freemarker</groupId>
			<artifactId>freemarker</artifactId>
			<version>2.3.16</version>
		</dependency>

The versioning can be tricky, try to use an up to date GA release and look here for compatible versions.
https://tiles.apache.org/framework/dependency-management.html

Also look here for spring docs on integrating tiles.
http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/view.html#view-tiles

#################################################################
Basic Tiles setup
#################################################################
In primary bean configuration (offers-servlet.xml) remove the previous jspViewResolver 
and use the new tiles resolver that builds upon jsp view mechanisms.

	<!-- bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"> 
		<property name="prefix" value="/WEB-INF/jsps/"></property> <property name="suffix" 
		value=".jsp"></property> </bean> -->
	<bean id="tilesViewResolver"
		class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
	</bean>
	
Add a location for xml definitions of tiles (/WEB-INF/layouts/) and add a default.xml file
Then add a configurer that takes in a list of xml definitions for tile templates.	

	<bean id="tilesConfigurer"
		class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>/WEB-INF/layouts/default.xml</value>
			</list>
		</property>
	</bean>
