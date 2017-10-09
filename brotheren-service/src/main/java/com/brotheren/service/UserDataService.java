package com.brotheren.service;

import com.brotheren.model.UserData;

import java.util.List;

public interface UserDataService {
    List<UserData> listAll();

    UserData getById(String id);

    UserData saveOrUpdate(UserData userData);

    void delete(String id);
}
