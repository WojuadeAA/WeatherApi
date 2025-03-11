package com.phoenixspring.WeatherApi;


import org.junit.jupiter.api.Test;


public class HelperTest {

    @Test
    public void testConvertFToC(){
        double fahrenheit = 32;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 0;
    }

    @Test
    public void testConvertFToC2(){
        double fahrenheit = 212;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 100;
    }

    @Test
    public void testConvertFToC3(){
        double fahrenheit = 98.6;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 37;
    }

    @Test
    public void testConvertFToC4(){
        double fahrenheit = 68;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 20;
    }

    @Test
    public void testConvertFToC5(){
        double fahrenheit = 50;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 10;
    }

    @Test
    public void testConvertFToC6(){
        double fahrenheit = 86;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 30;
    }

    @Test
    public void testConvertFToC7(){
        double fahrenheit = 104;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 40;
    }

    @Test
    public void testConvertFToC8(){
        double fahrenheit = 122;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 50;
    }

    @Test
    public void testConvertFToC9(){
        double fahrenheit = 140;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 60;
    }

    @Test
    public void testConvertFToC10(){
        double fahrenheit = 158;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 70;
    }

    @Test
    public void testConvertFToC11(){
        double fahrenheit = 176;
        double celsius = Helper.convertFToC(fahrenheit);
        assert celsius == 80;}
}
