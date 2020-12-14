package urise.webapp.model;

import java.util.ArrayList;

public class BulletedLineSection<E> implements Section {
  
  private final ArrayList<E> bulletedLineValues;

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
