package com.example.actorfragment.entities;

import android.graphics.drawable.Drawable;

import java.util.Date;

public class Product {
    private String Name;
    private String Type;
    private String Company;

    public Product(String PrName, String PrType, String PrCompany) {
        this.Name = PrName;
        this.Type = PrType;
        this.Company = PrCompany;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }
}
