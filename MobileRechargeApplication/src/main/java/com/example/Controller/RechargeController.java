package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Recharge;
import com.example.Service.RechargeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

    private final RechargeService rechargeService;


    RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }


    @PostMapping
    public Recharge addRecharge(
            @Valid @RequestBody Recharge recharge) {

        return rechargeService.addRecharge(recharge);
    }


    @GetMapping
    public List<Recharge> getAllRecharges() {

        return rechargeService.getAllRecharges();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Recharge> getRechargeById(
            @PathVariable int id) {

        Recharge recharge =
                rechargeService.getRechargeById(id);

        if (recharge == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recharge);
    }


    @GetMapping("/exists/{id}")
    public boolean rechargeExists(
            @PathVariable int id) {

        return rechargeService.rechargeExists(id);
    }


    @GetMapping("/count")
    public int getCount() {

        return rechargeService.getCount();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecharge(
            @PathVariable int id) {

        boolean deleted =
                rechargeService.deleteRecharge(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                "Recharge deleted successfully"
        );
    }
}