package urise.webapp.model;

import java.util.ArrayList;

public class BulletedLineSection implements Section {
  
  private final ArrayList<?> bulletedLineValues;

    public BulletedLineSection(String value) {
        bulletedLineValues = null;
    }

    @Override
    public void setSectionValue(String value, SectionType section) {
        
    }

    @Override
    public String getSectionValue(SectionType section) {
        return null;
    }
}
