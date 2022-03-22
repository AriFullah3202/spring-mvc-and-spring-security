package com.hello.mavenproject.dao;

import java.util.List;

import com.hello.mavenproject.api.Offer;

public interface OfferDao {
 public List<Offer> loadAllOffer();
 public void addOffer(Offer offer);
 public void updateOffer();
 public void deleteOffer();
 public Offer findByOfferId();
}
