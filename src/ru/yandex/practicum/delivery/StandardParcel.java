package ru.yandex.practicum.delivery;

// Стандартная посылка
public class StandardParcel extends Parcel {

    private static final Integer BASE_COST = 2;

    public StandardParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }


    @Override
    public Integer calculateDeliveryCost(){
        return getWeight() * BASE_COST;
    }
}
