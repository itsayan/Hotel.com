package framework;

import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class abcde {

    public static void main(String[] args) throws NumberFormatException {


        ArrayList<String> strTest = new ArrayList<>();
        strTest.add("12");
        strTest.add("14");
        strTest.add("8");
        strTest.add("9");
        strTest.add("7");

        ArrayList<Double> doubleTest = new ArrayList<>();
        for (String element : strTest) {
            doubleTest.add(Double.valueOf(element));
        }
        System.out.println(doubleTest);
    }
}





















