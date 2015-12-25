TOPPATH = ./
#LIBPATH = lib/index.jar:lib/heap.jar:lib/bufmgr.jar:lib/diskmgr.jar

CLASSPATH = .:..:
BINPATH = $(TOPPATH)bin
JAVAC = javac 
JAVA  = java 

PACKAGES = ch1

all: clean $(PACKAGES)

datastructs:src/DataStructures/*.java
	$(JAVAC) -d $(BINPATH) $(TOPPATH)src/DataStructures/*.java 

ch1:datastructs src/Chapter1/*.java
	$(JAVAC) -cp $(CLASSPATH)bin -d $(BINPATH) $(TOPPATH)src/Chapter1/*.java

clean:
	rm -R $(BINPATH)
	mkdir $(BINPATH)
