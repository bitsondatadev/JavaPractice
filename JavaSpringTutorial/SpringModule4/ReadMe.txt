#Spring Module 4 - Wiring with Annotations

Notes on set up...
#################################################################
BASIC SET UP
#################################################################

1) Set up New Maven Project
2) Add all required Spring jars and Right-Click the project Maven > Update Project
	Spring Jars - core, beans, context, expression

3) Add beans.xml
4) Add p, context, and beans namespaces
5) In context screen add context:annotation-config tag and context:component-scan tag with base-package="us.brianolsen.spring.model" to read @Component classes