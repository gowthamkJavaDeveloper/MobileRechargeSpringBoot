package com.example.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Ticket;

@Service
public class TicketService {

    private List<Ticket> ticketList = new ArrayList<>();


    // CREATE
    public Ticket addTicket(Ticket ticket) {

        ticketList.add(ticket);

        return ticket;
    }


    // READ ALL
    public List<Ticket> getAllTickets() {

        return ticketList;
    }


    // READ BY ID
    public Ticket getTicketById(int id) {

        return ticketList.stream()
                .filter(t -> t.getTicketId() == id)
                .findFirst()
                .orElse(null);
    }


    // UPDATE
    public Ticket updateTicket(int id, Ticket newTicket) {

        Ticket existingTicket = getTicketById(id);

        if (existingTicket == null) {
            return null;
        }

        existingTicket.setMovieName(newTicket.getMovieName());
        existingTicket.setCustomerName(newTicket.getCustomerName());
        existingTicket.setSeatNumber(newTicket.getSeatNumber());
        existingTicket.setTicketPrice(newTicket.getTicketPrice());

        return existingTicket;
    }


    // DELETE
    public boolean deleteTicket(int id) {

        return ticketList.removeIf(
                t -> t.getTicketId() == id
        );
    }


    // EXISTS
    public boolean ticketExists(int id) {

        return ticketList.stream()
                .anyMatch(t -> t.getTicketId() == id);
    }


    // COUNT
    public int getCount() {

        return ticketList.size();
    }
}