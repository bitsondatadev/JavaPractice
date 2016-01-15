package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class LongestImagePath {
	public static void main (String[] args){
		LongestImagePath lip = new LongestImagePath();
		String test = "dir1\n dir11\n  picture2.jpeg\n dir12\n  picture1.jpeg\n  dir121\n  dir123\n   picture3.jpeg\n  file1.txt\n picture5.jpeg\ndir2\n file2.gif";
		System.out.println(lip.solution(test));
	}
	
	public int solution(String s){
		if(s == null){
			return -1;
		}
		String[] lines = s.split("\n");
		DirNode dirTree = new DirNode(null);
		DirNode iter = dirTree;
		
		int globalDepth = 0;
		//fill dirTree
		for(String line: lines){
			String dir = line.replace(" ", "");
			int depth = line.length() - dir.length();
			
			if(depth > globalDepth){
				globalDepth++;
				iter = iter.children.get(iter.children.size() - 1);
				
			}else if(depth < globalDepth){
				globalDepth--;
				iter = iter.parent;
			}
			
			DirNode newNode = new DirNode(dir);
			newNode.parent = iter;
			iter.children.add(newNode);
		}

		return getLongestPathSize(dirTree);
	}
	
	public int getLongestPathSize(DirNode iter){
		if(iter==null){
			return -1;
		}
		int max = 0;
		for(DirNode n: iter.children){
			max = getLongestPathSize(n, "/", max);
		}
		return max;
	}
	
	private int getLongestPathSize(DirNode iter, String path, int max){
		String currentPath = path + iter.name;
		
		if(currentPath.contains(".")){
			if(currentPath.contains(".jpeg") || currentPath.contains(".png") || currentPath.contains(".gif")){
				System.out.println(currentPath);
				return currentPath.length() > max ? currentPath.length() : max;
			}
		}
		for(DirNode n: iter.children){
			max = getLongestPathSize(n, currentPath + "/", max);
		}
		return max;
	}

}

class DirNode{
	public String name;
	public DirNode parent;
	public List<DirNode> children;
	
	DirNode(String name){
		this.name = name;
		parent = null;
		children = new ArrayList<DirNode>();
	}
}