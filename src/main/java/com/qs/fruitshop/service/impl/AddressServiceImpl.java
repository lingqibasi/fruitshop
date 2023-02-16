package com.qs.fruitshop.service.impl;

import com.qs.fruitshop.mapper.AddressMapper;
import com.qs.fruitshop.pojo.Address;
import com.qs.fruitshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;
    @Override
    public List<Address> selectAllAddressById(Integer uid) {
        return addressMapper.listAddress(uid);
    }

    @Override
    public int insert(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    public int deleteByid(Integer addressid) {
        return addressMapper.deleteByid(addressid);
    }
}
