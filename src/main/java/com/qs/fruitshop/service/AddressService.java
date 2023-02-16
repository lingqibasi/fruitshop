package com.qs.fruitshop.service;

import com.qs.fruitshop.pojo.Address;

import java.util.List;

public interface AddressService {

    List<Address> selectAllAddressById(Integer uid);

    int insert(Address address);

    int deleteByid(Integer addressid);
}
