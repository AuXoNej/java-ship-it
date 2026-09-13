package ru.yandex.practicum.delivery;

// Скоропортящаяся посылка
public class PerishableParcel extends Parcel {

    public static final Integer BASE_COST = 4;

    private final Integer timeToLive;

    public PerishableParcel(
        String description,
        Integer weight,
        String deliveryAddress,
        Integer sendDay,
        Integer timeToLive
    ) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBaseCost() {
        return BASE_COST;
    }

    public boolean isExpired(Integer currentDay) {
        return currentDay < (getSendDay() + timeToLive);
    }

}
