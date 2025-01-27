package phadungkit.naphat.lab7;

public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector,HealthMonitorer {
    
    private double pace,totalDistance,time,avgHeartRate,maxHeartRate,avgSleepHours;
    
    public AppleWatchNike(String model, double price, String color){
        super(model, price, color);
    }

    public AppleWatchNike(String color, double price, String modelName,double totalDistance,double avgHeartRate,double avgSleepHours){
        super(color, price, modelName);
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }
    
    @Override
    public boolean isWatch() {
        return true;
    }

    @Override
    public void displayRunningStats(){
        System.out.println("Total distance run: "+ totalDistance +" km");
    }

    @Override
    public void displayHeartRate(){
        System.out.println("Average heart rate: "+ avgHeartRate +" bpm");
    }

    @Override
    public void displaySleepHours(){
        System.out.println("Average sleep durations: "+ avgSleepHours +" hours");
    }

    @Override
    public String toString() {
        return "AppleWatchNike(" + "color: " + getColor() + " price:" + getPrice() + " model name:" + getModelName() + " distance:"+ totalDistance +" km)";
    }
}