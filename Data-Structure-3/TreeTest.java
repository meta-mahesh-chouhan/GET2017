import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
	
	@Test
	public void addElementPass(){
		Tree<Integer> tree = new Tree<Integer>();
		tree.addElement(1);
		tree.addElement(2);
		
		Integer expected = 2;
		assertEquals(expected,tree.getRoot().getLeft().getData());
		
	}
	
	@Test
	public void preOrderTraversalTest(){
		Tree<Integer> tree = new Tree<Integer>();
		tree.addElement(1);
		tree.addElement(2);
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		
		String expected = "1 2 4 5 3 ";
		assertEquals(expected, tree.preOrderTraversal());
		
	}
	
	@Test
	public void postOrderTraversalTest(){
		Tree<Integer> tree = new Tree<Integer>();
		tree.addElement(1);
		tree.addElement(2);
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		
		String expected = "4 5 2 3 1 ";
		assertEquals(expected, tree.postOrderTraversal());
		
	}
	
	@Test
	public void checkMirrorTest(){
		
		Tree<Integer> firstTree = new Tree<Integer>();
		firstTree.addElement(1);
		firstTree.addElement(2);
		firstTree.addElement(3);
		firstTree.addElement(4);
		firstTree.addElement(5);
		
		Tree<Integer> secondTree = new Tree<Integer>();
		
		secondTree.addMirrorElement(1);
		secondTree.addMirrorElement(2);
		secondTree.addMirrorElement(3);
		secondTree.addMirrorElement(4);
		secondTree.addMirrorElement(5);
		
		assertTrue(firstTree.checkMirror(secondTree));
		
	}
	
	@Test
	public void checkMirrorNullTest(){
		
		Tree<Integer> firstTree = new Tree<Integer>();
	
		Tree<Integer> secondTree = new Tree<Integer>();

		assertTrue(firstTree.checkMirror(secondTree));
		
	}
	
	@Test
	public void checkMirrorTestFail(){
		
		Tree<Integer> firstTree = new Tree<Integer>();
		firstTree.addElement(1);
		firstTree.addElement(2);
		firstTree.addElement(3);
		firstTree.addElement(4);
		
		Tree<Integer> secondTree = new Tree<Integer>();

		secondTree.addMirrorElement(1);
		secondTree.addMirrorElement(2);
		secondTree.addMirrorElement(3);
		secondTree.addMirrorElement(4);
		secondTree.addMirrorElement(5);

		assertFalse(firstTree.checkMirror(secondTree));

	}
}
