package cz.zcu.hanzelin.bp.WorkerAllocation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Data
public class Worker {

    @Id
    @GeneratedValue
    private Long id;
    private String forName;
    private String famName;
    private String shortcut;
    private String section;
    private Long harness;
    private int reserve;
    private int absence;
    private String note;
    private boolean VP;
}
