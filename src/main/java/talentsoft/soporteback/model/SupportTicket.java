package talentsoft.soporteback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "supporttickets")
public class SupportTicket {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "tittle", length = 45)
    private String Tittle;

    @Size(max = 45)
    @Column(name = "description", length = 45)
    private String Description;

    @Size(max = 15)
    @Column(name = "ticketdate", length = 15)
    private String TicketDate;

    @Column(name = "hour")
    private LocalTime Hour;

    @Size(max = 45)
    @Column(name = "status", length = 45)
    private String Status;

    @Size(max = 45)
    @Column(name = "answer", length = 45)
    private String Answer;

    @NotNull
    @Column(name = "companyid", nullable = false)
    private Integer CompanyId;

    @NotNull
    @Column(name = "typesupportid", nullable = false)
    private Integer typeSupportId;

    @NotNull
    @Column(name = "userid", nullable = false)
    private Integer userid;

}