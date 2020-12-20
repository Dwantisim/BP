package cz.zcu.hanzelin.bp.WorkerAllocation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue
    private Long id;
    private int days;
    private LocalDate startDate;
    private LocalDate endDate;
    private int month;
    private boolean monthlyDated;
    private String log;
}
