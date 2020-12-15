package urise.webapp.model;

import java.time.LocalDate;

public class WorkPlace {

    private String place;
    private String description;
    private LocalDate dataFrom;
    private LocalDate dataTo;

    public WorkPlace(String place, String description, LocalDate dataFrom, LocalDate dataTo) {
        this.place = place;
        this.description = description;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDataForm(LocalDate dataFrom) {
        this.dataFrom = dataFrom;
    }

    public void setDataTo(LocalDate dataTo) {
        this.dataTo = dataTo;
    }


    public String getWorkPlace() {
        StringBuilder sb = new StringBuilder();
        sb.append(place);
        sb.append("\t");
        sb.append(dataFrom.toString());
        sb.append(" - ");
        sb.append(dataTo.toString());
        sb.append("\t");
        sb.append(description);
        sb.append("\n");
        return sb.toString();
    }
}
