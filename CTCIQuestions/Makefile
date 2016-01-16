TOPPATH = ./
LIBPATH = lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

CLASSPATH = .:..:
BINPATH = $(TOPPATH)bin
JAVAC = javac 
JAVA  = java 

CODELIBS = datastructs algos
PACKAGES = ch1 ch2 ch3 ch4 ch8

all: test 

datastructs:src/DataStructures/*.java test/DataStructures/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/DataStructures/*.java $(TOPPATH)test/DataStructures/*.java

algos:src/Algorithms/*.java test/Algorithms/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Algorithms/*.java $(TOPPATH)test/Algorithms/*.java

ch1:$(CODELIBS) src/Chapter1/*.java test/Chapter1/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter1/*.java $(TOPPATH)test/Chapter1/*.java

ch2:$(CODELIBS) src/Chapter2/*.java test/Chapter2/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter2/*.java $(TOPPATH)test/Chapter2/*.java

ch3:$(CODELIBS) src/Chapter3/*.java test/Chapter3/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter3/*.java $(TOPPATH)test/Chapter3/*.java

ch4:$(CODELIBS) src/Chapter4/*.java test/Chapter4/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter4/*.java $(TOPPATH)test/Chapter4/*.java

ch8:$(CODELIBS) src/Chapter8/*.java test/Chapter8/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter8/*.java $(TOPPATH)test/Chapter8/*.java

main:src/Main.java $(PACKAGES)
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Main.java

test:clean $(PACKAGES) 
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/TestRunner.java
	$(JAVA) -cp '$(CLASSPATH)$(LIBPATH):$(CLASSPATH)bin' TestRunner

clean:
	rm -R $(BINPATH)
	mkdir $(BINPATH)
