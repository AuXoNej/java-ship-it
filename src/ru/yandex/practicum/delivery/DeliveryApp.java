package ru.yandex.practicum.delivery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Parcel> trackableParcels = new ArrayList<>();

    private static ParcelBox<StandardParcel> boxStandardParcel = new ParcelBox<>(100);
    private static ParcelBox<FragileParcel> boxFragileParcel = new ParcelBox<>(200);
    private static ParcelBox<PerishableParcel> boxPerishableParcel = new ParcelBox<>(300);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    getBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Вывести отчет о статусе");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Введите тип посылки:");
        var parcelType = scanner.nextLine();

        switch (parcelType) {
            case "Стандартная посылка" -> addStandardParcel();
            case "Хрупкая посылка" -> addFragileParcel();
            case "Скоропортящаяся посылка" -> addPerishableParcel();
            default -> System.out.println("Неверный ввод - несуществующий тип посылки");
        }
        System.out.println("Посылка добавлена");
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        System.out.println("Отправка посылок");
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            System.out.println("--------------");
        }
        System.out.println("Все посылки отправлены\n");
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        System.out.println("Стоимость доставки:");
        for (var parcel : allParcels) {
            System.out.println("\t" +parcel.getDescription() + ": " + parcel.calculateDeliveryCost());
        }
        System.out.println("Общая стоимость: " + allParcels.stream().mapToInt(Parcel::calculateDeliveryCost).sum() + "\n");
    }

    private static void reportStatus() {
        for (var parcel : trackableParcels) {
            System.out.println("Введите новое местоположение для посылки " + parcel.getDescription());
            var newLocation = scanner.nextLine();

            parcel.reportStatus(newLocation);
        }
    }

    private static void getBox() {

        System.out.println("Введите тип коробки");
        var boxType = scanner.nextLine();
        System.out.println("Содержимое коробки типа: " + "'" + boxType.toLowerCase() + "':");
        System.out.print("\t");
        switch (boxType) {
            case "Стандартная посылка" -> boxStandardParcel.getAllParcels();
            case "Хрупкая посылка" -> boxFragileParcel.getAllParcels();
            case "Скоропортящаяся посылка" -> boxPerishableParcel.getAllParcels();
            default -> System.out.println("Неверный ввод - несуществующий тип посылки");
        }
    }


    private static void addStandardParcel() {
        var fields = getRequiredFields();

        var standardParcel = new StandardParcel(
            (String) fields.get(0),(Integer) fields.get(1), (String) fields.get(2), (Integer) fields.get(3)
        );

        if (boxStandardParcel.addParcel(standardParcel)) {
            allParcels.add(standardParcel);
        }

    }

    private static void addFragileParcel() {
        var fields = getRequiredFields();

        var fragileParcel = new FragileParcel(
            (String) fields.get(0),(Integer) fields.get(1), (String) fields.get(2), (Integer) fields.get(3)
        );

        if (boxFragileParcel.addParcel(fragileParcel)){
            allParcels.add(fragileParcel);
            trackableParcels.add(fragileParcel);
        }

    }

    private static void addPerishableParcel() {
        var fields = getRequiredFields();

        System.out.println("Введите срок годности:");
        var timeToLive = Integer.parseInt(scanner.nextLine());

        var perishableParcel = new PerishableParcel(
            (String) fields.get(0),
            (Integer) fields.get(1),
            (String) fields.get(2),
            (Integer) fields.get(3),
            timeToLive
        );

        if (boxPerishableParcel.addParcel(perishableParcel)) {
            allParcels.add(perishableParcel);
        }

    }

    private static List<Serializable> getRequiredFields() {

        System.out.println("Введите описание:");
        var description = scanner.nextLine();

        System.out.println("Введите вес:");
        var weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки:");
        var deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки:");
        var sendDay = Integer.parseInt(scanner.nextLine());

        return List.of(description, weight, deliveryAddress, sendDay);
    }

}

