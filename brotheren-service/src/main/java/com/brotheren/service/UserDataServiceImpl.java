package com.brotheren.service;

import com.brotheren.model.UserData;
import com.brotheren.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    private UserDataRepository userDataRepository;

    @Autowired
    public UserDataServiceImpl(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @Override
    public List<UserData> listAll() {
        List<UserData> userDataList = new ArrayList<>();
        userDataRepository.findAll().forEach(userDataList::add);
        return userDataList;
    }

    @Override
    public UserData getById(String id) {
        return userDataRepository.findOne(id);
    }

    @Override
    public UserData saveOrUpdate(UserData userData) {
        userDataRepository.save(userData);
        return userData;
    }

    @Override
    public void delete(String userId) {
        userDataRepository.delete(userId);
    }
}
