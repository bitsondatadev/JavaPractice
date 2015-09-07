#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

bool isUnique(string);

int main(int argc, char* argv[]){
	string str = "abcd";
	if(argc==2){
		str = argv[1];
	}
	cout << "The string " << (isUnique(str)?"contains all":"doesn't contain all") << " unique characters\n";
}

bool isUnique(string str){
	unordered_set<char> mySet;
	for(string::iterator it = str.begin(); it != str.end();++it){
		unordered_set<char>::const_iterator check = mySet.find(*it);
		if(check == mySet.end()){
			mySet.insert(*it);
		}else{
			return false;
		}
	}
	return true;
}