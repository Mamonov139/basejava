package urise.webapp.model;

import java.time.LocalDate;

public class WorkPlace {
    private final String place;
    private final String description;
    private final LocalDate dataForm;
    private final LocalDate dataTo;


    public WorkPlace(String place, String description, LocalDate dataForm, LocalDate dataTo) {
        this.place = place;
        this.description = description;
        this.dataForm = dataForm;
        this.dataTo = dataTo;
    }


    public void setWorkPlace(String place, String description, LocalDate dataForm, LocalDate dataTo) {

    }

    public String getWorkPlace() {
        return null;
    }
}
