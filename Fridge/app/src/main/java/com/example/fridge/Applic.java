package com.example.fridge;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Applic extends Application {
    private static List<Products> ProductsList = new ArrayList<Products>();
    private static int nextID = 10;

    public Applic() {
        stockProductList();
    }

    private void stockProductList() {
        Products p0 = new Products(0, "KDD Mango Juice", 15, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/kddmango.png?alt=media&token=caca8e5f-60cc-4a32-8c8e-7529a84db1bc", 8, 12, 2023 );
        Products p1 = new Products(1, "Danette Chocolate" , 25, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/danette.png?alt=media&token=0372b220-0720-4e3f-9a13-d324ab9b0afe", 4, 8, 2022);
        Products p2 = new Products(2, "Pinar Labaneh", 1,"https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/pinarlabaneh.png?alt=media&token=2043822a-795f-4fb3-8d29-adf45dac2ca0", 1, 5, 2024);
        Products p3 = new Products(3, "Heinz Mayonnaise", 17, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/mayonnaiseheinz.png?alt=media&token=e9e2ecae-e552-4a1f-ac9d-65de28d4b9dc", 1, 3, 2023);
        Products p4 = new Products(4, "Eggs", 8, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/egg.png?alt=media&token=4c9b4489-13e1-4f05-878d-cd92ad145212", 30, 11, 2025);
        Products p5 = new Products(5, "Nutella",  25, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/nutella.png?alt=media&token=e8667fe3-108a-4da8-b363-35933143f2d8", 1, 12, 2026);
        Products p6 = new Products(6, "Kitco Nice: Salt", 19, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/kitconicelightlysalted.png?alt=media&token=fc5a0d1d-1479-49ac-842c-cd229d3f6f09", 3, 7, 2022);
        Products p7 = new Products(7, "Starbucks Mocha", 23, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/starbucksfrappmocha.png?alt=media&token=414d1e17-07ab-45d1-9b66-7fd7aac9ac1c", 3, 2, 2022);
        Products p8 = new Products(8, "Almarai Laban", 11, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/almaraifreshlaban.png?alt=media&token=76a9f0a0-439f-4808-ad1d-58fe78e22d50", 6, 7, 2024);
        Products p9 = new Products(9, "Kraft Cheese Slice", 10, "https://firebasestorage.googleapis.com/v0/b/fridge-31d37.appspot.com/o/kraftslices.png?alt=media&token=3e37e439-a30d-46f9-b74c-1a4eedc4b108", 1, 4, 2027);

        ProductsList.add(p0);
        ProductsList.add(p1);
        ProductsList.add(p2);
        ProductsList.add(p3);
        ProductsList.add(p4);
        ProductsList.add(p5);
        ProductsList.add(p6);
        ProductsList.add(p7);
        ProductsList.add(p8);
        ProductsList.add(p9);
    }

    public static List<Products> getProductsList() {
        return ProductsList;
    }

    public static void setProductsList(List<Products> productsList) {
        ProductsList = productsList;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Applic.nextID = nextID;
    }
}
