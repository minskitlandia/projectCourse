package com.itland.naumenko.itjava.dao;

import com.itland.naumenko.itjava.model.Ads;

import java.util.List;

public interface AdsDao {

    void insert(Ads ads);
    boolean update(Ads ads);
    void delete(int id);
    List<Ads> getAllAds();
    Ads getAds(int id);

}
