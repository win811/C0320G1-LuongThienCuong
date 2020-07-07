package furama.resort.models.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContractDto {
    
    @NotNull(message = "Please Choose Start Date !")
    private LocalDate startDate;
    @NotNull(message = "Please Choose End Date !")
    private LocalDate endDate;
    private double deposit;
    private String[] idAttachServiceArr;

    public ContractDto() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String[] getIdAttachServiceArr() {
        return idAttachServiceArr;
    }

    public void setIdAttachServiceArr(String[] idAttachServiceArr) {
        this.idAttachServiceArr = idAttachServiceArr;
    }
}
