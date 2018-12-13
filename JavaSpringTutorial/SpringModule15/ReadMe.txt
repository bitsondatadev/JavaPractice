#Spring Module 15 - Spring WebFlow

#################################################################
Setup Webflow
#################################################################
Add the following dependencies

		<dependency>
			<groupId>org.springframework.webflow</groupId>
			<artifactId>spring-webflow</artifactId>
			<version>2.5.0.RELEASE</version>
		</dependency>
		
Go to WebContent > WEB-INF > offers-servlet and check webflow-config

Add the following config

<webflow-config:flow-registry id="flowRegistry"
		base-path="/WEB-INF/flows">
		<webflow-config:flow-location path="contact-flow.xml"
			id="message">
		</webflow-config:flow-location>
	</webflow-config:flow-registry>
	
And create a folder /WEB-INF/flows and a Spring Web-Flow Definition file called contact-flow.xml under flows.

In summary, each flow will point