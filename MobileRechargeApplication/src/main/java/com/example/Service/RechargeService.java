package com.example.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Recharge;

@Service
public class RechargeService {

    private List<Recharge> rechargeList = new ArrayList<>();


    // Add recharge
    public Recharge addRecharge(Recharge recharge) {

        rechargeList.add(recharge);

        return recharge;
    }


    // Get all recharges
    public List<Recharge> getAllRecharges() {

        return rechargeList;
    }


    // Get recharge by ID
    public Recharge getRechargeById(int id) {

        return rechargeList.stream()
                .filter(r -> r.getRechargeId() == id)
                .findFirst()
                .orElse(null);
    }


    // Check whether recharge exists
    public boolean rechargeExists(int id) {

        return rechargeList.stream()
                .anyMatch(r -> r.getRechargeId() == id);
    }


    // Count recharges
    public int getCount() {

        return rechargeList.size();
    }


    // Delete recharge
    public boolean deleteRecharge(int id) {

        return rechargeList.removeIf(
                r -> r.getRechargeId() == id
        );
    }
}