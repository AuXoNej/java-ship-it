package ru.yandex.practicum.delivery;

// Хрупкая посылка
public class FragileParcel extends Parcel implements Trackable {

    public static final Integer BASE_COST = 3;

    public FragileParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }


    @Override
    public int getBaseCost() {
        return BASE_COST;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation + "\n");
    }

}
