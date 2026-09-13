package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final Integer maxWeight;
    private final List<T> parcels;

    private Integer currentWeight;

    public ParcelBox(Integer maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.parcels = new ArrayList<>();
    }

    public boolean addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            return true;
        }
        System.out.println("Невозможно добавить посылку, максимальный вес будет превышен");
        return false;

    }

    public void getAllParcels() {
        System.out.println(parcels.stream().map(Parcel::getDescription).toList());
    }
}
