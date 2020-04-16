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
            String forObject = restTemplate.getForObject(url, String.class);
            System.out.println(forObject);
//            countryList.add(forObject);
        }

//           for (int i = 0; i < ipAddressList.getAddressList().size(); i++) {
//            String url = "https://api.ip2country.info/ip?" + ipAddressList.getAddressList().get(i);
//            Geolocation forObject = restTemplate.getForObject(url, Geolocation.class);
//            forObject.setUrl(ipAddressList.getAddressList().get(i));
//            geolocationList.add(forObject);
//        }
    }


    public List<Country> getCountryList() {
        return countryList;
    }

}
