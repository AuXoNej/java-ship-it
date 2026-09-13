package ru.yandex.practicum.delivery;

public abstract class Parcel {

    private final String description;
    private final Integer weight;
    private final String deliveryAddress;
    private final Integer sendDay;

    public Parcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }


    public Integer calculateDeliveryCost() {
        return getWeight() * getBaseCost();
    }

    public String getDescription() {
        return description;
    }

    public Integer getSendDay() {
        return sendDay;
    }

    public Integer getWeight() {
        return weight;
    }

    public abstract int getBaseCost();


    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

}
