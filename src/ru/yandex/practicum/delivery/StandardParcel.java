package ru.yandex.practicum.delivery;

// Стандартная посылка
public class StandardParcel extends Parcel {

    public static final Integer BASE_COST = 2;

    public StandardParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getBaseCost() {
        return BASE_COST;
    }

}
