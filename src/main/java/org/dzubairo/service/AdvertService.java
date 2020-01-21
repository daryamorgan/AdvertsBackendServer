package org.dzubairo.service;

import org.dzubairo.model.Advert;
import org.dzubairo.dao.AdvertDAO;

import java.util.Set;

public class AdvertService {
    public static Advert addAdvert(Advert advert) {
        return AdvertDAO.addAdvert(advert);
    }

    public static Advert getAdvert(int id) {
        return AdvertDAO.getAdvert(id);
    }

    public static Set<Advert> getAdvertsByCustomerId(int id) {
        return AdvertDAO.getAdvertsByCustomerId(id);
    }

    public static Set<Advert> getAllAdverts() {
        return AdvertDAO.getAllAdverts();
    }

    public static boolean removeAdvert(int id) {
        return AdvertDAO.removeAdvert(id);
    }
}
