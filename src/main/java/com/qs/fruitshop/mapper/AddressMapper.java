package com.qs.fruitshop.mapper;

import com.qs.fruitshop.pojo.Address;

import java.util.List;

public interface AddressMapper {

    List<Address> listAddress(Integer uid);

    Address selectAddressByUid(Integer uid);

    Address selectAddressById(Integer id);

    int insert(Address address);

    int deleteByid(Integer addressid);
}
