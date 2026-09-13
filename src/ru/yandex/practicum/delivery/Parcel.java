package ru.yandex.practicum.delivery;

public abstract class Parcel implements Trackable {

    private String description;
    private Integer weight;
    private String deliveryAddress;
    private Integer sendDay;

    public Parcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }


    public abstract Integer calculateDeliveryCost();


    public String getDescription() {
        return description;
    }

    public Integer getSendDay() {
        return sendDay;
    }

    public Integer getWeight() {
        return weight;
    }


    public void packageItem(){
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver(){
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    @Override
    public void reportStatus(String newLocation){}

}
