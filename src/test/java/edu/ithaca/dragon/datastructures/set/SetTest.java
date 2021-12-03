package edu.ithaca.dragon.datastructures.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SetTest {


    @Test
    public void testTreeSet(){
        fail("Not implemented yet");
        //TODO: call all test methods on your TreeSet
    }

    @Test
    public void testListSet(){
        fail("Not implemented yet");
        //TODO: call all test methods on your ListSet
    }

    public void addContainsSizeTest(Set<String> testSet){
        assertEquals(0, testSet.size());
        assertFalse(testSet.contains("anything"));

        testSet.add("Maria");
        assertTrue(testSet.contains("Maria"));
        testSet.add("George");
        assertTrue(testSet.contains("George"));
        assertTrue(testSet.contains("Maria"));
        assertEquals(2, testSet.size());
        assertFalse(testSet.contains("maria"));

        testSet.add("Maria");
        testSet.add("George");
        assertEquals(2, testSet.size());

        testSet.add("Lisa");
        assertTrue(testSet.contains("Lisa"));
        assertTrue(testSet.contains("Maria"));
        assertTrue(testSet.contains("George"));
        assertEquals(3, testSet.size());

        assertFalse(testSet.contains("Rufus"));
    }

    public void addContainsSizeTestLarge(Set<Integer> testSet){
        for (int i=0; i<597; i++){
            testSet.add(i);
        }
        assertEquals(597, testSet.size());
        for (int i=333; i<399; i++){
            testSet.add(i);
        }
        assertEquals(597, testSet.size());
        for (int i=555; i<673; i++){
            testSet.add(i);
        }
        assertEquals(673, testSet.size());
        for (int i=0; i<673; i++){
            assertTrue(testSet.contains(i));
        }
        for (int i=673; i<899; i++){
            assertFalse(testSet.contains(i));
        }
        
    }

    public void toOrderedListTest(Set<String> testSet){
        testSet.add("Maria");
        testSet.add("George");
        testSet.add("Lisa");
        
        List<String> ansList = testSet.toOrderedList();
        assertEquals(3, ansList.size());
        assertEquals("George", ansList.get(0));
        assertEquals("Lisa", ansList.get(1));
        assertEquals("Maria", ansList.get(2));

        ansList.remove(2);
        ansList.remove(1);
        ansList.remove(0);

        assertTrue(testSet.contains("Lisa"));
        assertTrue(testSet.contains("Maria"));
        assertTrue(testSet.contains("George"));

    }

    public void toOrderedListTestLarge(Set<Integer> testSet){
        assertEquals(0, testSet.toOrderedList().size());

        int size = 1000;
        List<Integer> list = new ArrayList<>(size);
        for (int i=0; i<size; i++){
            list.add(i);
        }
        Collections.shuffle(list);

        for (Integer num : list){
            testSet.add(num);
        }

        List<Integer> ansList = testSet.toOrderedList();
        assertEquals(size, ansList.size());
        for (int i=0; i<size; i++){
            assertEquals(i, ansList.get(i).intValue());
        }
    }
    
    public void unionTest1(Set<Integer> testSet1, Set<Integer> testSet2){
        testSet1.add(1);
        testSet1.add(2);
        testSet1.add(3);
        
        testSet2.add(4);
        testSet2.add(5);
        testSet2.add(6);

        Set<Integer> ansSet = testSet1.union(testSet2);
        assertEquals(6, ansSet.size());
        for (int i=1; i<7; i++){
            assertTrue(ansSet.contains(i));
        }
        assertEquals(3, testSet1.size());
        assertEquals(3, testSet2.size());

        Set<Integer> ansSet2 = testSet2.union(testSet1);
        assertEquals(6, ansSet2.size());
        for (int i=1; i<7; i++){
            assertTrue(ansSet2.contains(i));
        }
        assertEquals(3, testSet1.size());
        assertEquals(3, testSet2.size());
    }
    
    public void unionTest2(Set<Integer> testSet1, Set<Integer> testSet2){
        assertEquals(0, testSet1.union(testSet2).size());

        testSet2.add(2);
        testSet2.add(3);
        testSet2.add(100);
        testSet2.add(4);
        testSet2.add(5);
        
        testSet1.add(6);
        testSet1.add(3);
        testSet1.add(2);
        testSet1.add(1);
        testSet1.add(200);
        testSet1.add(5);
        testSet1.add(5);

        Set<Integer> ansSet1 = testSet1.union(testSet2);
        assertEquals(8, ansSet1.size());
        for (int i=1; i<6; i++){
            assertTrue(ansSet1.contains(i));
        }
        assertTrue(ansSet1.contains(100));
        assertTrue(ansSet1.contains(200));

        assertEquals(6, testSet1.size());
        assertEquals(5, testSet2.size());

        Set<Integer> ansSet2 = testSet2.union(testSet1);
        assertEquals(8, ansSet2.size());
        for (int i=1; i<6; i++){
            assertTrue(ansSet2.contains(i));
        }
        assertTrue(ansSet2.contains(100));
        assertTrue(ansSet2.contains(200));
    }

    public void intersectionTest1(Set<Integer> testSet1, Set<Integer> testSet2){
        assertEquals(0, testSet1.intersection(testSet2).size());

        testSet1.add(1);
        testSet1.add(2);
        testSet1.add(3); 
        testSet1.add(4);
        testSet1.add(5);
        testSet1.add(6);

        assertEquals(0, testSet1.intersection(testSet2).size());
        
        testSet2.add(4);
        testSet2.add(7);
        testSet2.add(9);
        testSet2.add(2);
        testSet2.add(8);
        testSet2.add(6);

        Set<Integer> ansSet = testSet1.intersection(testSet2);
        assertEquals(3, ansSet.size());
        assertTrue(ansSet.contains(2));
        assertTrue(ansSet.contains(4));
        assertTrue(ansSet.contains(6));

        Set<Integer> ansSet2 = testSet2.intersection(testSet1);
        assertEquals(3, ansSet2.size());
        assertTrue(ansSet2.contains(2));
        assertTrue(ansSet2.contains(4));
        assertTrue(ansSet2.contains(6));

        assertEquals(6, testSet1.size());
        assertEquals(6, testSet2.size());

        Set<Integer> ansSet3 = testSet1.intersection(testSet1);
        assertEquals(6, ansSet3.size());
        assertTrue(ansSet3.contains(1));
        assertTrue(ansSet3.contains(2));
        assertTrue(ansSet3.contains(3));
        assertTrue(ansSet3.contains(4));
        assertTrue(ansSet3.contains(5));
        assertTrue(ansSet3.contains(6));
    }
}
