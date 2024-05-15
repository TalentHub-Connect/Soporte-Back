package talentsoft.soporteback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import talentsoft.soporteback.model.SupportTicket;
import talentsoft.soporteback.repository.SupportTicketRepository;
import talentsoft.soporteback.service.intf.ISupportTicketService;

import java.util.List;
import java.util.Optional;
@Service
public class SupportTicketService implements ISupportTicketService{

    private final SupportTicketRepository supportTicketRepository;

    @Autowired
    public SupportTicketService(SupportTicketRepository supportTicketRepository) {
        this.supportTicketRepository = supportTicketRepository;
    }

    @Override
    public List<SupportTicket> getAllTickets() {
        return supportTicketRepository.findAll();
    }

    @Override
    public Optional<SupportTicket> getTicketById(Integer id) {
        return supportTicketRepository.findById(id);
    }

    @Override
    public SupportTicket createTicket(SupportTicket ticket) {
        return supportTicketRepository.save(ticket);
    }

    @Override
    public SupportTicket updateTicket(SupportTicket ticket) {
        return supportTicketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Integer id) {
        supportTicketRepository.deleteById(id);
    }
}
