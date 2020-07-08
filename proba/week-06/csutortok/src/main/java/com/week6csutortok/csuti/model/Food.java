package com.week6csutortok.csuti.model;

public class Food {
    private Integer id;
    private String name;  //ennek meg kell egyeznie a FoodControllerben lévő save-food @ModelAttributum paramétereivel, ha azt a módszert használom
    private Integer amount; //ennek meg kell egyeznie a FoodControllerben lévő save-food @ModelAttributum paramétereivel, ha azt a módszert használom

    private static Integer counter = 1;

    public Food(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
        this.id = counter;
        counter++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAlertStyleClass(){
        return this.amount > 400 ? "red" : "";
    }
}
