package SpringCycle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BinaryTreeController {

	
	
	@RequestMapping(value = "/createBinaryTree", method = RequestMethod.POST)
	public String   createBinaryTree(@RequestBody Map<Integer, List<Integer>> matrixVars)  throws Exception{
		
		System.out.println(matrixVars);
		return createTree(matrixVars).toString();
		
	}
	
	@RequestMapping(value = "/ancestor", method=RequestMethod.POST)
	public Integer foo(@RequestBody Map<Integer, List<Integer>> matrixVars,@RequestParam("number") List<Integer> to) {
	
		BinaryTree tree =createTree(matrixVars);
	    for(Integer number : to) {
	        System.out.println(number);
	    }
	    
	
	    
	   return findLCA(to.get(0), to.get(1), tree.root);
	}

	public BinaryTree createTree(Map<Integer, List<Integer>> matrixVars ) {
		
		BinaryTree tree = new BinaryTree(); 
		int size=matrixVars.size();
		
		// primer Nivel
		for(int i=1;i<size;i++ ) {
	
			
			  List<Integer> list= matrixVars.get(i);
			  List<Integer> list2= matrixVars.get(i+1);
			  System.out.println("list1 :"+list);
			  System.out.println("list2 :"+list2);
	
			  tree.add(list.get(0));
			  if (list.get(1)!=list2.get(1)) {
				  tree.add(list.get(1));
				  tree.add(list2.get(1));
				  
			  }	
			  
		}
		// segundo nivel
		for(int i=1;i<size;i++ ) {
			  List<Integer> list= matrixVars.get(i);
			  List<Integer> list2= matrixVars.get(i+1);
			  if(i==1) {
			  tree.add(list.get(2));
			  tree.add(list2.get(2));
			  
			  }
			  if(i==4) {
				  tree.add(list.get(2));
				  tree.add(list2.get(2));
			  }
		
		}
		//3 nivel
		for(int i=1;i<size;i++ ) {
			  List<Integer> list= matrixVars.get(i);
			  List<Integer> list2= matrixVars.get(i+1);
			  if((i % 2) == 0) {
			  tree.add(list.get(3));
			  tree.add(list2.get(3));
			  
			  }
			  if(i==5) {
				  tree.add(list2.get(3));
			  }
		
		}
			 
		return tree;
	}
	
	
	
	private static List<Integer> path1 = new ArrayList<>(); 
	private static List<Integer> path2 = new ArrayList<>(); 
	static int findLCA(int n1, int n2,Node root) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private static int findLCAInternal(Node root, int n1, int n2) { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 

            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    } 
      

    private static boolean findPath(Node root, int n, List<Integer> path) 
    { 
     
        if (root == null) { 
            return false; 
        } 
          
    
        path.add(root.value); 
  
        if (root.value == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
  

        path.remove(path.size()-1); 
  
        return false; 
    } 

	
	

}
