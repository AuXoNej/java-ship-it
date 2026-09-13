package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateDeliveryCostTest {

    private static List<Parcel> standardParcels;
    private static List<Parcel> fragileParcel;
    private static List<PerishableParcel> perishableParcel;


    @BeforeAll
    public static void init() {
        // Создание списков посылок.

        String description = "testDescription";
        Integer weight = 10;
        String deliveryAddress = "testAddress";
        Integer sendDay = 1;
        Integer timeToLive = 5;

        standardParcels = new ArrayList<>();
        fragileParcel = new ArrayList<>();
        perishableParcel = new ArrayList<>();

        standardParcels.add(new StandardParcel(description, weight, deliveryAddress, sendDay));
        fragileParcel.add(new FragileParcel(description, weight, deliveryAddress, sendDay));
        perishableParcel.add(new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive));

    }

    // Вычисление стоимости посылки для каждого типа посылок.
    @Test
    void costStandardParcelTest() {
        assertEquals(20, standardParcels.getFirst().calculateDeliveryCost());
    }
    @Test
    void costFragileParcelTest() {
        assertEquals(30, fragileParcel.getFirst().calculateDeliveryCost());
    }
    @Test
    void costPerishableParcelTest() {
        assertEquals(40, perishableParcel.getFirst().calculateDeliveryCost());
    }
}
