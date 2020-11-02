package edu.ithaca.dragon.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.List;

import bridges.benchmark.PriorityQueueAddItemsBenchMark;
import bridges.benchmark.PriorityQueueRemoveItemsBenchMark;
import bridges.connect.Bridges;

public class PriorityQueueEffiencyMain {
    public static void main(String[] args) throws Exception {
        Bridges bridges = new Bridges(3, "tdragon", "29315085544");
        bridges.setTitle("Benchmarking Priority Queues");

        int numDataPoints = 1000;
        int numActionsPerDataPoint = 20;
        List<PriorityQueue<String>> listToTest = new ArrayList<>();
        //TODO: your priority queues here
        // listToTest.add(new FastPollPQ<>());
        // listToTest.add(new FastOfferPQ<>());

        PriorityQueueAddItemsBenchMark addItemsBenchmark = new PriorityQueueAddItemsBenchMark(listToTest, numDataPoints, numActionsPerDataPoint);
        bridges.setDataStructure(addItemsBenchmark.getViewableModel());
        bridges.visualize();
        PriorityQueueRemoveItemsBenchMark removingItemsBenchmark = new PriorityQueueRemoveItemsBenchMark(listToTest, numDataPoints, numActionsPerDataPoint);
        bridges.setDataStructure(removingItemsBenchmark.getViewableModel());
        bridges.visualize();
    }
}
