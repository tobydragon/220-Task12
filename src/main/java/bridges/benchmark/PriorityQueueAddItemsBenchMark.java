package bridges.benchmark;

import bridges.base.DataStruct;
import bridges.base.LineChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.ithaca.dragon.datastructures.priorityqueue.PriorityQueue;

public class PriorityQueueAddItemsBenchMark extends Benchmark{
    private static Random random = new Random();

    public PriorityQueueAddItemsBenchMark(List<? extends PriorityQueue<String>> listToTest, int rounds, int itemsPerRound) {
        super(new LineChart());
    
    	plot.setTitle("Adding items Runtime Comparison");
		plot.setXLabel("Amount of Data");
		plot.setYLabel("Runtime (in ms)");
	
		for (int i=0; i< listToTest.size(); i++){
			PriorityQueue<String> toTest = listToTest.get(i);
			generateDataForAddingItems(Integer.toString(i+1)+"-offer", toTest, plot, rounds, itemsPerRound);
		}

	}

	public static void generateDataForAddingItems(String toTestLabel, PriorityQueue<String> toTest, LineChart chartToAddTo, int rounds, int itemsPerRound){
		ArrayList<Double> xDataPoints = new ArrayList<>();
		ArrayList<Double> yDataPoints = new ArrayList<>();
		for (int i=1; i < rounds; i++){
			timeAnAdd(i, itemsPerRound, toTest, xDataPoints, yDataPoints, rounds*itemsPerRound);
		}
		chartToAddTo.setXData(toTestLabel, xDataPoints);
		chartToAddTo.setYData(toTestLabel, yDataPoints);
	}

	public static void timeAnAdd(int roundNumber, int numToAddBefore, PriorityQueue<String> toTest, ArrayList<Double> xDataPoints, ArrayList<Double> yDataPoints, int totalDataCount ) {
		
		for (int i=0; i<numToAddBefore; i++){
			toTest.offer(("an example string"), random.nextInt(totalDataCount));
		}

		int randomPriority = random.nextInt(totalDataCount);
		long start = System.nanoTime();
		toTest.offer(("an example string"), randomPriority);
		long end = System.nanoTime();
		
		long runTime = (end - start)/ 1000; //runtime in microseconds
		xDataPoints.add(Double.valueOf(roundNumber*numToAddBefore));
		yDataPoints.add(Double.valueOf(runTime));
	}

	public DataStruct getViewableModel(){
		return plot;
	}
    
}
