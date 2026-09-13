package ru.yandex.practicum.delivery;

// Скоропортящаяся посылка
public class PerishableParcel extends Parcel {

    private static final Integer BASE_COST = 4;

    private Integer timeToLive;

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
    public Integer calculateDeliveryCost(){
        return getWeight() * BASE_COST;
    }

    public boolean isExpired(Integer currentDay) {
        return currentDay < (getSendDay() + timeToLive);
    }

}
