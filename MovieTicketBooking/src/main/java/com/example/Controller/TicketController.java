package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Ticket;
import com.example.Service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    // CREATE
    @PostMapping
    public Ticket addTicket(
            @Valid @RequestBody Ticket ticket) {

        return ticketService.addTicket(ticket);
    }


    // READ ALL
    @GetMapping
    public List<Ticket> getAllTickets() {

        return ticketService.getAllTickets();
    }


    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(
            @PathVariable int id) {

        Ticket ticket = ticketService.getTicketById(id);

        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ticket);
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(
            @PathVariable int id,
            @Valid @RequestBody Ticket ticket) {

        Ticket updatedTicket =
                ticketService.updateTicket(id, ticket);

        if (updatedTicket == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTicket);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(
            @PathVariable int id) {

        boolean deleted =
                ticketService.deleteTicket(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                "Ticket deleted successfully"
        );
    }


    // EXISTS
    @GetMapping("/exists/{id}")
    public boolean ticketExists(
            @PathVariable int id) {

        return ticketService.ticketExists(id);
    }


    // COUNT
    @GetMapping("/count")
    public int getCount() {

        return ticketService.getCount();
    }
}