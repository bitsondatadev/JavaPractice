package Chapter8;

import java.util.ArrayList;
import java.util.List;

public class Question4{
	public Question4(){
	}
	public List<ArrayList<Integer>> generatePowerSet(List<Integer> set){
		if(set == null){ 
			return new ArrayList<ArrayList<Integer>>();
		}
		
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		List<ArrayList<Integer>> temp;
		
		for(Integer val: set){
			temp = copyLists(result);
			for(List<Integer>subList: temp){
				subList.add(new Integer(val));
				result.add(new ArrayList<Integer>(subList));
			}
		}
		return result;
	}
	
	private List<ArrayList<Integer>> copyLists(List<ArrayList<Integer>> lists){
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(List<Integer>list:lists){
			result.add(new ArrayList<Integer>());
			int curIndex = result.size() - 1;
			for(Integer val:list){
				result.get(curIndex).add(val);
			}
		}
		return result;
	}
}


