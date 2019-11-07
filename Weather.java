/**
 * Anthony Tortola
 * Description: Takes temperature and wind speed and calculates the windchill
 */
import java.lang.Math;
import java.util.Scanner;


class Weather
{
    private int tempF;
    private int windSpeed;
    public double windChill;
    public boolean severe;

    public Weather() //Default constructor
    {
        tempF = 5;
        windSpeed = 40;
        //windChill = 0;
    }

    public Weather(int tempF, int windSpeed) //Overloaded constructor
    {
        this.tempF = tempF;
        this.windSpeed = windSpeed;
    }

    public int getTempF() // Get method returns the temperature
    {
        return tempF;
    }
    public void setTempF(int tempF ) //Set method, sets the temperature
    {
        if(tempF > -50 && tempF < 150)
        {
            this.tempF = tempF;
        }
        return;
    }

    public double getWindSpeed() //Get method returns wind speed
    {
        return windSpeed;
    }
    public void setWindSpeed(int windSpeed) //Set method, sets the wind speed
    {
        if(windSpeed >= 0)
        {
            this.windSpeed = windSpeed;
        }
        return;
    }

    public double getWindChill() //Get method calculates wind chill using temperature and wind speed, and returns wind chill
    {
        int t = getTempF();
        double v = getWindSpeed();

        windChill = 35.74 + 0.6215*t - 35.75*Math.pow(v, 0.16) + 0.4275*t*Math.pow(v,0.16);
        return windChill;
    }
    public boolean isSevere() //Returns true if severe else false
    {
        if(getWindChill() < -15) //Weather is severe if wind chill is less than -15
        {
            severe = true;
        }
        else
        {
            severe = false;
        }
        return severe;
    }
    public String toString() //To String
    {
        double wind = (Math.round(getWindChill()* 100.0) / 100.0);
        return "Current Temperature is " + tempF + " 'F. Feels like " + wind + " 'F and Wind Speed is " + windSpeed + " mph.";
    }
}

class WeatherTester
{

    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        Weather w = new Weather();
        Weather wT = new Weather(11,20);

        System.out.println(w); //Prints out the default constructor
        System.out.println(wT); //Prints out the overloaded constructor using initialized values
        System.out.println(wT.isSevere() ? "Weather is severe!" : "Weather is ok"); //Determines if weather is severe
        System.out.println("Please enter temp value"); //Asks the user for a temp value from the user
        int temp = keyboard.nextInt(); //Saves the temp value in "temp" variable
        System.out.println("Please enter wind speed value"); //Asks the user for a wind speed value
        int windspeed = keyboard.nextInt(); //Saves the wind speed value in "windspeed" variable
        Weather U = new Weather(temp, windspeed);
        System.out.println(U); //Prints out the overloaded constructor using values inputted by the user
        System.out.println(U.isSevere() ? "Weather is severe!" : "Weather is ok"); //Determines if weather is severe
    }
}
