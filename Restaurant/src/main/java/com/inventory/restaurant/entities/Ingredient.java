package com.inventory.restaurant.entities;

import java.util.Objects;

public class Ingredient {
    private String sku;
    private String name;
    private Category_ingredient category;
    private String brand;
    private Integer quantity;
    private Unit unit;
    private String description;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient( String name, Category_ingredient category, String brand, Integer quantity,Unit unit, String description) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
        this.unit=unit;
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category_ingredient getCategory() {
        return category;
    }

    public void setCategory(Category_ingredient category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
    public void AddQuantity(Integer quantity)
    {
         this.quantity+=quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return name.equals(that.name) && category == that.category && brand.equals(that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, brand);
    }
}
