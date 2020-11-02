package entiti.Repository;

import entiti.model.Discipline;
import entiti.model.enums.DisciplineType;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class DisciplineRep {
    List<Discipline> disciplines = new ArrayList<>();

    Discipline dis1 = new Discipline(DisciplineType.AM);
    Discipline dis2 = new Discipline(DisciplineType.DEV);
    Discipline dis3 = new Discipline(DisciplineType.TEST);


    public List<Discipline> getDisciplines() {
        disciplines.add(dis1);
        disciplines.add(dis2);
        disciplines.add(dis3);
        return disciplines;
    }
}
