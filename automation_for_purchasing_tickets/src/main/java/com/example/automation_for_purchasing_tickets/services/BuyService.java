package com.example.automation_for_purchasing_tickets.services;

import com.example.automation_for_purchasing_tickets.dtos.BuyRecord;
import com.example.automation_for_purchasing_tickets.models.BuyModel;
import com.example.automation_for_purchasing_tickets.repositorys.BuyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BuyService {

    @Autowired
    BuyRepository buyRepository;

    public BuyModel savePurchase(BuyRecord buyRecord){
        var purchase = new BuyModel();
        BeanUtils.copyProperties(buyRecord, purchase);

        return buyRepository.save(purchase);
    }

    public List<BuyModel> listAllPurchases(){
        return buyRepository.findAll();
    }

    public Object listOnePurchase(UUID id){
        return buyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    public Object updatePurchase(UUID id, BuyModel buyModel){
        Optional<BuyModel> purchase = buyRepository.findById(id);

        if(purchase.isEmpty()){
            throw new RuntimeException("Purchase not found");
        }

        var newPurchase = purchase.get();

        newPurchase.setPurchaseCode(buyModel.getPurchaseCode());
        newPurchase.setDateOfPurchase(buyModel.getDateOfPurchase());
        newPurchase.setPurchasingMethod(buyModel.getPurchasingMethod());
        newPurchase.setPurchaseValue(buyModel.getPurchaseValue());

        return buyRepository.save(newPurchase);
    }

    public void deleteOnePurchase(UUID id){
        Optional<BuyModel> purchase = buyRepository.findById(id);

        if(purchase.isEmpty()){
            throw new RuntimeException("Purchase not found");
        }

        buyRepository.deleteById(id);
    }

    public void deleteAllPurchases(){
        buyRepository.deleteAll();
    }
}
