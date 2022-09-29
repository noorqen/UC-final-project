package com.example.fridge;

import java.util.Comparator;

public class Products {
    private int id;
    private String prodname;
    private int Expirydate;
    private String imageLink;
    private int Quantityno;
    private int ExpiryMM;
    private int Expiryyyy;

    public Products(int id, String prodname, int expirydate, String imageLink, int quantityno, int expiryMM, int expiryyyy) {
        this.id = id;
        this.prodname = prodname;
        Expirydate = expirydate;
        this.imageLink = imageLink;
        Quantityno = quantityno;
        ExpiryMM = expiryMM;
        Expiryyyy = expiryyyy;
    }

    public static Comparator<Products> Prodnameatoz =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p1.getProdname().compareTo(p2.getProdname());
        }
    };

    public static Comparator<Products> Prodnameztoa =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p2.getProdname().compareTo(p1.getProdname());
        }
    };

    //Ascending date-month-year
    public static Comparator<Products> Prodexpdateasc =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p1.getExpirydate() - p2.getExpirydate();
        }
    };
    public static Comparator<Products> ProdexpdateMMasc =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p1.getExpiryMM() - p2.getExpiryMM();
        }
    };
    public static Comparator<Products> Prodexpdateyyyyasc =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p1.getExpiryyyy() - p2.getExpiryyyy();
        }
    };

    //Descending date-month-year
    public static Comparator<Products> Prodexpdatedesc =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p2.getExpirydate() - p1.getExpirydate();
        }
    };
    public static Comparator<Products> ProdexpdateMMdesc =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p2.getExpiryMM() - p1.getExpiryMM();
        }
    };
    public static Comparator<Products> Prodexpdateyyyydesc =new Comparator<Products>() {
        @Override
        public int compare(Products p1, Products p2) {
            return p2.getExpiryyyy() - p1.getExpiryyyy();
        }
    };


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", prodname='" + prodname + '\'' +
                ", Expirydate=" + Expirydate +
                ", imageLink='" + imageLink + '\'' +
                ", Quantityno=" + Quantityno +
                ", ExpiryMM=" + ExpiryMM +
                ", Expiryyyy=" + Expiryyyy +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpirydate() {
        return Expirydate;
    }

    public void setExpirydate(int expirydate) {
        Expirydate = expirydate;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getExpiryMM() {
        return ExpiryMM;
    }

    public void setExpiryMM(int expiryMM) {
        ExpiryMM = expiryMM;
    }

    public int getExpiryyyy() {
        return Expiryyyy;
    }

    public void setExpiryyyy(int expiryyyy) {
        Expiryyyy = expiryyyy;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public int getQuantityno() {
        return Quantityno;
    }

    public void setQuantityno(int quantityno) {
        Quantityno = quantityno;
    }
}
