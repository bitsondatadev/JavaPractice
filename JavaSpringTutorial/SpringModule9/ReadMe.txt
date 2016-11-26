Notes on set up...
#################################################################
BASIC SET UP
#################################################################

1) Set up Java Project, Convert to Maven Project
2) Right-click on the project and click Configure > Convert to Maven Project
   Add all required Spring jars and Right-Click the project Maven > Update Project
   Spring Jars
   core, beans, context jdbc, aspects
3) Make a beans.xml and add aop and beans to the namespace.
4) Make a standard class (BasicAOPClass) and an Aspect class (Logger) that will advise the standard class and add beans for each.
5) In aop tab of beans.xml, add aop:config property
6) Right click aop:config property and add pointcut element to specify method of standard class that will be "advised" by aspect and point to standard bean.
7) Right click aop:config property and add aspect element and point to aspect class bean.
8) Right click aop:aspect property and add aop:before and specify method of advice class.

Note: this can also be done with annotations, see BasicAOPClass and Logger classes and we will need to make sure that:
Under context tab of our beans.xml we have added...
 - annotation-config tag with the appropriate packages listed.
 - component-scan is added
Under aop tab of our beans.sml we have added...
 - aspectj-autoproxy tag added

#################################################################
Make pointcuts more generic
#################################################################
Instead of specifying a pointcut for every single method we can use wildcards. 

For example if we have overloaded methods with multiple parameter definitions then we can use methodName(..) to specify any version of the method should be advised by the Aspect.

We can also have set an astrisk to allow for any return type, class name, method name, and any point within the package so for instance 

* us.brianolsen.spring.*.* *(..) will apply the advice to any method of any class with any return type, with any method signature that falls under /us/brianolsen/spring/ directory
String *.* *(String) will apply advice to any method in the project that returns a String and takes 1 string as a parameter.

#################################################################
Different types of advice
################################################################# 

Before - Happens just before method occuring

After - Get's called After method regardless of an exception being throw

AfterReturning - Get's called only if no exception is thrown

AfterThrowing - Get's called only if exception is thrown.

Around - Get's called then one section of the method then a proceed method is called then after the advised method is finished the remainder of around is called.

#################################################################
Proxies, Interfaces, and Aspects
#################################################################
In order to execute an aspect, Spring takes the original advised class (DifferentAdviceClass) and makes a subclass that also extends classes that add methods that allow it to be advised.
There was a bug that used to exist for classes that implemented interfaces, that is best displayed in an example.
interface DifferentAdviceClassInterface
class DifferentAdviceClass implements DifferentAdviceClassInterface

If we had the interface/class above and ran

System.out.println(differentAdviceClass instanceof DifferentAdviceClass);
differentAdviceClass.pointcutMethod();

We would have an issue thrown due to the fact that it would take the interface DifferentAdviceClassInterface and not DifferentAdviceClass and add all the aop methods to the superclass of the interface. Therefore
System.out.println(differentAdviceClass instanceof DifferentAdviceClass) => false 
The old fix for this was to add proxy-target-class="true" to the <aop:aspectj-autoproxy></aop:aspectj-autoproxy> but this isn't required for Spring 4.x

#################################################################
Pointcut Designators 
#################################################################
We started by using execution pointcut designator and this specifies at method granularity where to inject aspect. 
We can use other designators like within that exist at type granularity where pointcuts will be inserted around all methods of a type.
To find documentation on all supported pointcut designators look here:
http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/aop.html#aop-pointcuts-designators

For matching in within (which matches at class/type granularity) we can use wildcards but be careful if you want to match values in a sub-package you need to have the following syntax.
within(us.brianolsen.spring.aop.*) //all methods within all classes under aop.
within(us.brianolsen.spring..*) //all methods within all classes under aop.
within(us.brianolsen.spring.*) //all methods within all classes under spring [NOT under spring.aop.*]

For slightly more specific designator we can use target. Target is useful because it doesn't allow wildcards in it's pointcut. 
It works much like execution but is easier to read and understand as it will point to a specific class or interface.
target(us.brianolsen.spring.aop.PointCutDesignatorClass)
target(us.brianolsen.spring.aop.PointCutDesignatorClassInterface)

The "this" pointcut designator can target actual instances of the class and used to not work with concrete classes due to the proxies/interfaces bug but now it works about the same as target.

You can use the @target designator to specify certain annotation types (e.g. Deprecated, Component, Controller, etc..) to inject in. In spring @within cannot use wildcards so it is nearly identical to @target.

@annotation will do the same but will work at the method level.

@args will add pointcut around method that has an argument of type that is annotated. E.g. A deprecated class getting passed into a method.

The bean pointcut designator can be used to target a specific bean using the id. e.g. bean(<bean_id>)

#################################################################
Combining Poincuts
#################################################################
Pointcuts can be combined by using &&, ||, and ! operators