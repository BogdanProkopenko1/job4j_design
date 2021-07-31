package ru.job4j.isp;

import ru.job4j.collection.list.List;

import javax.sql.rowset.Predicate;

public class InterfaceSegregationPrinciple {

    class Product {
    }

    interface Shop {
        List<Product> getAllProducts();
        List<Product> getProducts(Predicate predicate);
        boolean deleteAll();
        boolean addProduct(Product product);
        boolean deleteProduct(int id);
        boolean changeProduct(int id);
        boolean getProduct(int id);
    }

    interface Triangle {
        double getSin();
        double getCos();
        double getTg();
        double getCtg();
        double getArcSin();
        double getArcCos();
        double getArcTg();
        double getArcCtg();
    }

    interface Converter {
        double smToMeter(double sm);
        double kmToMeter(double km);
        double gramToKilogram(double gram);
        double tonToKilogram(double ton);
        double centnerToKilogram(double centner);
        double minuteToHour(double minute);
    }

    interface TimeConverter {
        double minuteToHour(double minute);
    }

    interface DistanceConverter {
        double smToMeter(double sm);
        double kmToMeter(double km);
    }

    interface WeightConverter {
        double gramToKilogram(double gram);
        double tonToKilogram(double ton);
        double centnerToKilogram(double centner);
    }
}
