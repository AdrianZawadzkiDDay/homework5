package pl.bykowksi.homework_teai5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bykowksi.homework_teai5.service.CountryList;

@Controller
@RequestMapping("/countries")
public class CountryController {

    CountryList countryList;

    public CountryController(CountryList countryList) {
        this.countryList = countryList;
    }

    @GetMapping()
    public String getListGeo(Model model){
        model.addAttribute("countryInfo", countryList.getCountryList());
        return "countries";
    }


}
