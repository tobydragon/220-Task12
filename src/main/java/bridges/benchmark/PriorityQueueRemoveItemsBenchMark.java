package bridges.benchmark;

import bridges.base.DataStruct;
import bridges.base.LineChart;

import java.util.ArrayList;
import java.util.List;

import edu.ithaca.dragon.datastructures.priorityqueue.PriorityQueue;

public class PriorityQueueRemoveItemsBenchMark extends Benchmark{

    public PriorityQueueRemoveItemsBenchMark(List<? extends PriorityQueue<String>> listToTest, int rounds, int itemsPerRound) {
        super(new LineChart());
    
    	plot.setTitle("Removing items Runtime Comparison");
		plot.setXLabel("Amount of Data");
		plot.setYLabel("Runtime (in ms)");
	
		for (int i=0; i< listToTest.size(); i++){
			PriorityQueue<String> toTest = listToTest.get(i);
			generateDataForRemovingItems(Integer.toString(i+1)+"-poll", toTest, plot, rounds, itemsPerRound);
		}

	}

	public static void generateDataForRemovingItems(String toTestLabel, PriorityQueue<String> toTest, LineChart chartToAddTo, int rounds, int itemsPerRound){
		ArrayList<Double> xDataPoints = new ArrayList<>();
		ArrayList<Double> yDataPoints = new ArrayList<>();
		for (int i=1; i < rounds; i++){
			timeARemove(i, itemsPerRound, toTest, xDataPoints, yDataPoints, rounds*itemsPerRound);
		}
		chartToAddTo.setXData(toTestLabel, xDataPoints);
		chartToAddTo.setYData(toTestLabel, yDataPoints);
	}

	public static void timeARemove(int roundNumber, int numToAddBefore, PriorityQueue<String> toTest, ArrayList<Double> xDataPoints, ArrayList<Double> yDataPoints, int totalDataCount ) {
		
		for (int i=0; i<numToAddBefore; i++){
			toTest.poll();
		}

		long start = System.nanoTime();
		toTest.poll();
		long end = System.nanoTime();
		
		long runTime = (end - start)/ 1000; //runtime in microseconds
		xDataPoints.add(Double.valueOf(totalDataCount - (roundNumber*numToAddBefore)));
		yDataPoints.add(Double.valueOf(runTime));
	}

	public DataStruct getViewableModel(){
		return plot;
	}
    
}
