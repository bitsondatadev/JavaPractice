CC=g++
CFLAGS=-c -std=c++11

all: q1

q1: q1.o

q1.o: q1.cpp
	$(CC) $(CFLAGS) q1.cpp

clean:
	rm *o q1
#CC=g++
#CFLAGS=-c -Wall
#LDFLAGS=
#SOURCES=main.cpp hello.cpp factorial.cpp
#OBJECTS=$(SOURCES:.cpp=.o)
#EXECUTABLE=hello
#
#all: $(SOURCES) $(EXECUTABLE)
#    
#$(EXECUTABLE): $(OBJECTS) 
#	$(CC) $(LDFLAGS) $(OBJECTS) -o $@
#
#.cpp.o:
#	$(CC) $(CFLAGS) $< -o $@
#
#http://mrbook.org/blog/tutorials/make/