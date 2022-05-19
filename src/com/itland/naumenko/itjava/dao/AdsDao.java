package com.itland.naumenko.itjava.dao;

import com.itland.naumenko.itjava.model.Ads;

import java.util.List;

public interface AdsDao {

    void insert(Ads user);
    boolean update(Ads user);
    void delete(int id);
    List<Ads> getAllAds();
    Ads getAds(int id);

}
