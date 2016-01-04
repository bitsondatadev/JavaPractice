# InterviewPractice
Practice for my interviews from the Cracking the coding interview book. I've set up a test bed using JUnit. It will run in both linux terminal and is used in an Eclipse program.
Here is how I have structured the packages:
![test](https://github.com/brianolsen87/InterviewPractice/blob/master/images/tree.png "Package Tree")

All you have to do is run it and it will output the following for all the tests that you specify in TestRunner.java.
![test](https://github.com/brianolsen87/InterviewPractice/blob/master/images/testOutput.png "Test Output")

In src you will find the implementation. I used instance classes for each question and set up a package for each chapter to keep things seperate.

I have also defined a DataStructures package that will hold my own implementations of the Data Structures described in the book. So far I have only done Linked List and Hash table but I will soon add Stack and Queue and later BST, Trie and Graphs.

I do also have a Main.java that is doing nothing at the moment but maybe I'll use it later for some sort of integration testing or something.
