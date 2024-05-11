package talentsoft.soporteback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talentsoft.soporteback.model.SupportTicket;
import talentsoft.soporteback.service.impl.SupportTicketService;

import java.util.List;

@RestController
@RequestMapping("/api/support/tickets")
public class SupportTicketController {
    private final SupportTicketService supportTicketService;

    @Autowired
    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    @GetMapping
    public ResponseEntity<List<SupportTicket>> getAllTickets() {
        return ResponseEntity.ok(supportTicketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Integer id) {
        return supportTicketService.getTicketById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SupportTicket> createTicket(@RequestBody SupportTicket ticket) {
        return ResponseEntity.ok(supportTicketService.createTicket(ticket));
    }

    @PutMapping("/{ticketId}/update-answer")
    public ResponseEntity<SupportTicket> updateAnswer(@PathVariable Integer ticketId, @RequestBody SupportTicket request) {
        return supportTicketService.getTicketById(ticketId)
                .map(ticket -> {
                    ticket.setAnswer(request.getAnswer());
                    supportTicketService.updateTicket(ticket);
                    return ResponseEntity.ok(ticket);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicket> updateTicket(@PathVariable Integer id, @RequestBody SupportTicket ticket) {
        ticket.setId(id);
        return ResponseEntity.ok(supportTicketService.updateTicket(ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Integer id) {
        supportTicketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }
}
