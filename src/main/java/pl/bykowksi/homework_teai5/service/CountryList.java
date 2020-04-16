package pl.bykowksi.homework_teai5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowksi.homework_teai5.model.Names;
import pl.bykowksi.homework_teai5.model.pojo.Country;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryList {

    List<Country> countryList;
    RestTemplate restTemplate;
    Names names;

    @Autowired
    public CountryList(Names names) {
        this.names = names;
        restTemplate = new RestTemplate();
        countryList = new ArrayList();

        startCountries();
    }

    public void startCountries() {

        for (int i = 0; i < names.getNames().size(); i++) {
            String url = "https://restcountries.eu/rest/v2/name/" + names.getNames().get(i);
            Country[] forObject = restTemplate.getForObject(url, Country[].class);


            for (Country c: forObject) {
                System.out.println(c);
                countryList.add(c);
            }


        }


    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void addCountry(Names newName) {
        String url = "https://restcountries.eu/rest/v2/name/" + newName.getName();
        Country[] forObject = restTemplate.getForObject(url, Country[].class);

        for (Country c: forObject) {
            System.out.println(c);
            countryList.add(c);
        }
    }


}
