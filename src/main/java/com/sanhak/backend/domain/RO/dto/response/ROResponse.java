package com.sanhak.backend.domain.RO.dto.response;

import com.sanhak.backend.domain.RO.entity.RepairOrder;
import lombok.Getter;

@Getter
public class ROResponse {

    private String vehicleType;
    private String causePartNameKor;
    private String bigPhenom;
    private String subPhenom;
    private String specialNote;
    private String location;
    private String problematic;
    private String cause;

    public ROResponse(RepairOrder repairOrder) {
        this.vehicleType = repairOrder.getVehicleType();
        this.causePartNameKor = repairOrder.getCausePartNameKor();
        this.bigPhenom = repairOrder.getBigPhenom();
        this.subPhenom = repairOrder.getSubPhenom();
        this.specialNote = repairOrder.getSpecialNote();
        this.location = repairOrder.getLocation();
        this.problematic = repairOrder.getProblematic();
        this.cause = repairOrder.getCause();
    }
}
