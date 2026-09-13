package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsExpiredTest {

    private static List<PerishableParcel> perishableParcel;

    @BeforeAll
    public static void init() {

        String description = "testDescription";
        Integer weight = 10;
        String deliveryAddress = "testAddress";
        Integer sendDay = 1;
        Integer timeToLive = 5;

        perishableParcel = new ArrayList<>();
        perishableParcel.add(new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive));
    }

    // Работа метода isExpired — метод должен корректно вычислять, не испортилась ли посылка.
    @Test
    void isExpiredTest_true(){
        // граничное значение
        assertTrue(perishableParcel.getFirst().isExpired(1));
        // значение из промежутка класса эквивалентности
        assertTrue(perishableParcel.getFirst().isExpired(2));
        // граничное значение
        assertTrue(perishableParcel.getFirst().isExpired(5));
    }

    @Test
    void isExpiredTest_false(){
        // граничное значение
        assertFalse(perishableParcel.getFirst().isExpired(6));
        // значение из промежутка класса эквивалентности
        assertFalse(perishableParcel.getFirst().isExpired(10));
    }
}
