package pl.bykowksi.homework_teai5.model;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Names {

    List<String> names;
    String name;

    public Names() {
        names = new ArrayList<>();
        String poland = "Poland";
        String russia = "Russia";

        names.add(poland);
        names.add(russia);
    }

    public List<String> getNames() {
        return names;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
