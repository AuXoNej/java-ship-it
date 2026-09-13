package ru.yandex.practicum.delivery;

// Хрупкая посылка
public class FragileParcel extends Parcel {

    private static final Integer BASE_COST = 3;

    public FragileParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }


    @Override
    public void packageItem(){
        System.out.println("Посылка " + getDescription() +" обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public Integer calculateDeliveryCost(){
        return getWeight() * BASE_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation + "\n");
    }

}
