package com.prabath.rentcloud.service;

import com.prabath.rentcloud.model.DetailResponse;
import com.prabath.rentcloud.model.rent.Rent;
import com.prabath.rentcloud.model.Response;

import java.util.List;

public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id);
}
