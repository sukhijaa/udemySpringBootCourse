package com.sukhijaa.currencyExchange.currencyexchangeservice.controller;

import com.sukhijaa.currencyExchange.currencyexchangeservice.bean.ExchangeObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeObjectService extends JpaRepository<ExchangeObject, Integer> {

}
