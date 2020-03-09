import java.util.Random;

public class Car extends Thread{
    public static  int DISTANCE = 100;

    public static int STEP = 4;

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int distance = 0;

        double startTime = System.currentTimeMillis();
        while (distance < DISTANCE) {
            try {
                int speed = (new Random()).nextInt(20);

                distance += speed;

                String graphic = "|";

                int percentTravel = (distance*100)/DISTANCE;

                for (int i=0;i<DISTANCE;i+=STEP){
                    if (percentTravel >= i+STEP){
                        graphic += "=";
                    }
                    else if (percentTravel >= i && percentTravel < i+ STEP){
                        graphic += "o";
                    }
                    else {
                        graphic += "-";
                    }
                }
                graphic += "|";
                System.out.println("Car "+this.name+": "+graphic+ " "+Math.min(DISTANCE, distance)+" km");
                Thread.sleep(1000);
            }
            catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
        double endTime = System.currentTimeMillis();
        System.out.println("Car "+this.name+" finish in "+(endTime-startTime)/1000+" s");
    }
}
