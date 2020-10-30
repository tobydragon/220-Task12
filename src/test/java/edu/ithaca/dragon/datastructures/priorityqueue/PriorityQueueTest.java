package edu.ithaca.dragon.datastructures.priorityqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import edu.ithaca.dragon.datastructures.EmptyContainerException;

public class PriorityQueueTest {

    public PriorityQueue<String> getStringPq(){
        return null;
    }
    
    @Test
    public void basicTest(){
        PriorityQueue<String> q = getStringPq();
        assertTrue(q.isEmpty());
        q.offer("Sara", 8);
        assertFalse(q.isEmpty());
        q.offer("Janice", 4);
        q.offer("Maria", 11);
        assertFalse(q.isEmpty());

        assertEquals("Janice", q.poll());
        assertEquals("Sara", q.poll());
        assertFalse(q.isEmpty());

        q.offer("Gwen", 4);
        q.offer("Jen", 15);
        q.offer("Sam", 13);
        q.offer("Max", 8);
        assertFalse(q.isEmpty());

        assertEquals("Gwen", q.poll());
        assertEquals("Max", q.poll());
        assertEquals("Maria", q.poll());
        assertEquals("Sam", q.poll());
        assertEquals("Jen", q.poll());
        assertTrue(q.isEmpty());
    }
    
    @Test
    public void samePriorityTest(){
        PriorityQueue<String> q = getStringPq();
        assertTrue(q.isEmpty());
        q.offer("Sara", 8);
        q.offer("Janice", 2);
        q.offer("Maria", 8);

        assertEquals("Janice", q.poll());
        String name = q.poll();
        assertTrue(name.equals("Sara") || name.equals("Maria"));
        name = q.poll();
        assertTrue(name.equals("Sara") || name.equals("Maria"));
        assertTrue(q.isEmpty());


        q.offer("Gwen", 12);
        q.offer("Jen", 15);
        q.offer("Sam", 12);
        q.offer("Jill", 13);
        q.offer("Max", 15);
        q.offer("Sue", 15);
        q.offer("Isa", 12);
        assertFalse(q.isEmpty());

        name = q.poll();
        assertTrue(name.equals("Sam") || name.equals("Gwen") || name.equals("Isa"));
        name = q.poll();
        assertTrue(name.equals("Sam") || name.equals("Gwen") || name.equals("Isa"));
        name = q.poll();
        assertTrue(name.equals("Sam") || name.equals("Gwen") || name.equals("Isa"));
        
        assertEquals("Jill", q.poll());

        name = q.poll();
        assertTrue(name.equals("Jen") || name.equals("Max") || name.equals("Sue"));
        name = q.poll();
        assertTrue(name.equals("Jen") || name.equals("Max") || name.equals("Sue"));
        name = q.poll();
        assertTrue(name.equals("Jen") || name.equals("Max") || name.equals("Sue"));

        assertTrue(q.isEmpty());
    }

    @Test
    public void smallAndLargePriorityTest(){
        PriorityQueue<String> q = getStringPq();
        assertTrue(q.isEmpty());
        q.offer("Sara", Integer.MAX_VALUE-1);
        q.offer("Janice", Integer.MAX_VALUE);
        q.offer("Maria", 8);

        assertEquals("Maria", q.poll());
        assertEquals("Sara", q.poll());
        assertEquals("Janice", q.poll());

        assertTrue(q.isEmpty());

        q.offer("Sara", Integer.MIN_VALUE + 1);
        q.offer("Janice", Integer.MIN_VALUE);
        q.offer("Maria", 8);

        assertEquals("Janice", q.poll());
        assertEquals("Sara", q.poll());
        assertEquals("Maria", q.poll());
    }


    @Test
    public void testPollOnEmpty(){
        PriorityQueue<String> q = getStringPq();
        assertTrue(q.isEmpty());
        assertThrows(EmptyContainerException.class, () -> {
            q.poll();
        });
    }

}
