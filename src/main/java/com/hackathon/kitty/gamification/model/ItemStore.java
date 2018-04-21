package com.hackathon.kitty.gamification.model;

import java.util.List;

public class ItemStore {
    private List<KittyType> listEggs;
    private List<Food> listFoods;

    public ItemStore() {
    }

    public ItemStore(List<KittyType> listEggs, List<Food> listFoods) {
        this.listEggs = listEggs;
        this.listFoods = listFoods;
    }

    public List<KittyType> getListEggs() {
        return listEggs;
    }

    public void setListEggs(List<KittyType> listEggs) {
        this.listEggs = listEggs;
    }

    public List<Food> getListFoods() {
        return listFoods;
    }

    public void setListFoods(List<Food> listFoods) {
        this.listFoods = listFoods;
    }
}
