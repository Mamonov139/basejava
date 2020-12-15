package urise.webapp.model;

import java.util.ArrayList;

public class BulletedLineSection<E> implements Section {

    private final ArrayList<E> bulletedLineValues = new ArrayList<>();

    public BulletedLineSection(E[] value) {

        for (E v : value) {
            bulletedLineValues.add(v);
        }

    }

    public void setSectionValue(E[] value) {
        bulletedLineValues.clear();
        for (E v : value) {
            bulletedLineValues.add(v);
        }

    }

    @Override
    public String getSectionValue() {
        StringBuilder sb = new StringBuilder();
        for (E bls : bulletedLineValues){
            sb.append(bls.toString());
            sb.append(" \n");
        }
        return sb.toString();
    }
}
