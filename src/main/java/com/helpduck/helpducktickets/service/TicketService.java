package com.helpduck.helpducktickets.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;

import com.helpduck.helpducktickets.enums.StatusEnum;
import com.helpduck.helpducktickets.entity.Comment;
import com.helpduck.helpducktickets.entity.Ticket;
import com.helpduck.helpducktickets.model.hateoas.TicketHateoas;
import com.helpduck.helpducktickets.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {

  @Autowired
  private TicketRepository repository;

  @Transactional(readOnly = true)
  public Page<TicketHateoas> findAll(Pageable pageable) {
    Page<Ticket> ticket = repository.findAll(pageable);
    Page<TicketHateoas> page = ticket.map(x -> new TicketHateoas(x));
    return page;
  }

  @Transactional(readOnly = true)
  public Ticket findById(String id) {
    Optional<Ticket> ticketOptional = repository.findById(id);
    if (ticketOptional.isEmpty()) {
      return null;
    }
    Ticket ticket = ticketOptional.get();
    return ticket;
  }

  @Transactional(readOnly = true)
  public TicketHateoas findByIdHateoas(String id) {
    Optional<Ticket> ticket = repository.findById(id);
    if (ticket.isEmpty()) {
      return null;
    }
    TicketHateoas ticketHateoas = new TicketHateoas(ticket.get());
    return ticketHateoas;
  }

  @Transactional(readOnly = true)
  public Page<TicketHateoas> findAllByUserIdService(Pageable pageable, String id) {
    Page<Ticket> tickets = repository.findAllByUserId(pageable, id);
    Page<TicketHateoas> ticketsHateoas = tickets.map(x -> new TicketHateoas(x));
    return ticketsHateoas;
  }

  @Transactional(readOnly = true)
  public Page<TicketHateoas> findAllBySupportIdService(Pageable pageable, String id) {
    Page<Ticket> tickets = repository.findAllByUserId(pageable, id);
    Page<TicketHateoas> ticketsHateoas = tickets.map(x -> new TicketHateoas(x));
    return ticketsHateoas;
  }

  @Transactional(readOnly = true)
  public Page<TicketHateoas> findAllNullSupportService(Pageable pageable) {
    Page<Ticket> tickets = repository.findAllNullSupport(pageable);
    Page<TicketHateoas> ticketsHateoas = tickets.map(x -> new TicketHateoas(x));
    return ticketsHateoas;
  }

  public Ticket create(Ticket ticket) {
    ticket.setStatus(StatusEnum.awaiting);
    ticket.setComments(new ArrayList<Comment>());
    ticket.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
    ticket.setUpdatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
    Ticket ticketInserted = repository.insert(ticket);
    return ticketInserted;
  }
}
