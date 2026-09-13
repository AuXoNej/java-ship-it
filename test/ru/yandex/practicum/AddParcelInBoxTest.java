package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddParcelInBoxTest {

    private static final String description = "testDescription";
    private static final Integer weight = 10;
    private static final String deliveryAddress = "testAddress";
    private static final Integer sendDay = 1;

    // Проверка добавления новой посылки в коробку. Если максимальный вес не превышен, посылка должна добавляться, а если превышен — нет.
    @Test
    void addParcelTest_success() {

        ParcelBox<StandardParcel> boxStandardParcels = new ParcelBox<>(100);

        var standardParcel1 = new StandardParcel(description, weight, deliveryAddress, sendDay);
        var standardParcel2 = new StandardParcel(description, 90, deliveryAddress, sendDay);

        // значение из промежутка класса эквивалентности (weight не превышает maxWeightBox)
        assertTrue(boxStandardParcels.addParcel(standardParcel1));

        // граничное значение (сумма весов двух посылок равна maxWeightBox)
        assertTrue(boxStandardParcels.addParcel(standardParcel2));

    }

    @Test
    void addParcelTest_fail() {

        ParcelBox<StandardParcel> box1 = new ParcelBox<>(9);

        var standardParcel1 = new StandardParcel(description, weight, deliveryAddress, sendDay);
        var standardParcel2 = new StandardParcel(description, 5, deliveryAddress, sendDay);
        var standardParcel3 = new StandardParcel(description, 15, deliveryAddress, sendDay);

        // значение из промежутка класса эквивалентности (weight превышает maxWeightBox)
        assertFalse(box1.addParcel(standardParcel1));

        ParcelBox<StandardParcel> box2 = new ParcelBox<>(15);
        box1.addParcel(standardParcel2);

        // значение из промежутка класса эквивалентности (сумма весов двух посылок превышает maxWeightBox)
        assertFalse(box1.addParcel(standardParcel3));

    }
}
