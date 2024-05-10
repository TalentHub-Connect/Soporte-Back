package talentsoft.soporteback.service.intf;

import talentsoft.soporteback.model.SupportTicket;

import java.util.List;
import java.util.Optional;

public interface ISupportTicketService {
    List<SupportTicket> getAllTickets();
    Optional<SupportTicket> getTicketById(Integer id);
    SupportTicket createTicket(SupportTicket ticket);
    SupportTicket updateTicket(SupportTicket ticket);
    void deleteTicket(Integer id);
}
