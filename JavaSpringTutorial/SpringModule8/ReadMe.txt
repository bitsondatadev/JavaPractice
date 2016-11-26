#Spring Module 8 - Working with web forms

Notes on set up...
#################################################################
BASIC SET UP
#################################################################

See ReadMe.txt from SpringModule7

#################################################################
SERVING STATIC RESOURCES
#################################################################

1) Add a folder for resources (in our case WebContent/resources)
2) Add some resources (css, images, js, etc..)
3) Add an entry in the dispatcher servlet
   1) Go to offers-servlet.xml and click on the mvc tab.
   2) Right click beans and choose insert mvc:resources element.
   3) Add entry to location box of "/resources/" to point dispatcher servlet to this folder.
   4) Also we need to add mappings of how external entities can reach resources and all subfolders (in our case static/** allows us to access files in resources an ** allows us to access subfolders as well).
  
#################################################################
FORM VALIDATION
#################################################################
1) We need to add following jar dependencies in our pom.xml
   1) javax.validation                           (For tags)
   2) org.hibernate    hibernate module          (For hibernate)
   3) org.hibernate    hibernate-validate module (For validation specification)
2) We must add a BindingResult paramter in the controller.
3) Add an @Valid tag to the object being validated.
4) Now we can add constains using annotation under the javax.validation.constraints package (https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html) See Offers.java model.

#################################################################
Tag Libs for remembering values during submit (not "Remember Me")
#################################################################
1) Copy the following jsp directive into the jsp file found by searching "spring form tags".
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="myPrefix"%>
2) Add myPrefix: to any forms such as form, input, textarea, etc.. and add a path field to match name e.g. name="email" -> path="email" this is used to bind to an object.
3) In a myPrefix:form element, add the commandName attribute and set it to a name of your model (e.g. "offer").
4) Now we must add that model with the same name from step 3 in the controller when the offer is created. offerCreated(Model model). model.addAttribute("offer", new Offer())

#################################################################
Adding Error output on form
#################################################################
Add sf:errors tag within field row as shown below. Make sure path attributes line up.
<tr>
	<td class="label">Name: </td>
	<td><sf:input class="control" type="text" path="name" name="name" /><br/>
	<sf:errors path="name" cssClass="error"></sf:errors>
	</td>
</tr>

#################################################################
Making our own Validation Annotations
#################################################################
1) Search google with "custom validation constraint java" to look for standard java constraint libraries (not spring specific) find good docs like this https://docs.jboss.org/hibernate/validator/4.1/reference/en-US/html/validator-customconstraints.html and follow instructions or
2) Another option would be to look at a current annotation (e.g. Size) and copy the interface and remove and rename the class as needed.
3) In the Constaint annotation add a classpath to a custom validator class as so... @Constraint(validatedBy = <valid classpath to custom class that implements ConstraintValidator> see ValidEmailImpl)
4) Instead of writing our own validator for something common like an email address we should use a preexisting validator and can pull in commons-validator jar in dependencies to use an industry standard).
5) Now you can get an instance of an email validator and verify the email using EmailValidator.getInstance().isValid(email)

#################################################################
EXCEPTION HANDLING
#################################################################
1) Add method in controller to rerout to an error landing page (e.g. error.jsp) and add the @ExceptionHandler(<myExceptionType>Exception.class) above the method.
2) You can also move all error handling methods to a single class by Annotating it with @ControllerAdvice public class DatabaseErrorHandler {} and add methods inside