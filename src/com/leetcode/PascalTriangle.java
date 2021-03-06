package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public int[][] helper(int n){
		int[][] res = new int[n][n];
		for(int i=0; i<n;i++){
			for(int j=0;j<=i;j++){
				if(i==j || j==0) 
					res[i][j] = 1;
				else
					res[i][j] = res[i-1][j] + res[i-1][j-1] ;
			}
		}
		return res;
	}
	
	public List<List<Integer>> parse(int[][] a, int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for(int i=0; i<n;i++){
			List<Integer> sublist = new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				sublist.add(a[i][j]);
			}
			res.add(sublist);
		}
		
		return res;
	}
	
    public List<List<Integer>> generate(int numRows) {
        return parse(helper(numRows), numRows);
    }
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> pre = new ArrayList<Integer>();
    	List<Integer> cur;
    	pre.add(1);
    	
    	for(int j=1;j<=rowIndex;j++){
    		cur = new ArrayList<Integer>(pre.size()+1);
    		for(int i=0;i<=pre.size();i++){
    			if(i==0||i==pre.size())
    				cur.add(1);
    			else
    				cur.add(pre.get(i) + pre.get(i-1));
    		}
    		
    		pre = cur;
    	}
		return pre;        
    }
    
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		System.out.println(pt.getRow(3));
	}

}
