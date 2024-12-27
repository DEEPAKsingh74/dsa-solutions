
//1 =======================  Traversal ======================

/*
	//5 ==================  Complexity  ===================

		Time: O(N)
		Space: O(1)

*/

class Pair{
	private int first;
	private int second;

	public int getFirst(){
		return this.first;
	}

	public void setFirst(int value){
		this.first = value;
	}

	public int getSecond(){
		return this.second;
	}

	public void setSecond(int value){
		this.second = value;
	}
}

class Solution {
	public Pair minMaxArr(int[] arr){
		Pair p = new Pair();

		p.setFirst(Integer.MAX_VALUE);
		p.setSecond(Integer.MIN_VALUE);

		for(int i = 0; i < arr.length; i++){
			p.setFirst(Math.min(arr[i], p.getFirst()));
			p.setSecond(Math.max(arr[i], p.getSecond()));
		}

		return p;
	}
}