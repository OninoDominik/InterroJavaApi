package fr.CCI.Java.boulangermicroservice.web.controller;
import java.util.List;

import fr.CCI.Java.boulangermicroservice.dao.EspeceDao;
import fr.CCI.Java.boulangermicroservice.dao.PoissonDao;
import fr.CCI.Java.boulangermicroservice.model.Espece;
import fr.CCI.Java.boulangermicroservice.model.Poisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/espece")
public class EspeceController {
    @Autowired
    private EspeceDao especeDao;
    @Autowired
    private PoissonDao poissonDao;

    @GetMapping(value= "/debut")
    public String debut( Model model){

        return "Accueil";
    }



    @GetMapping(value= "/all")
    public String listeDesEspeces( Model model){
        List<Espece> listEspece=  especeDao.findAll();

        model.addAttribute("listEspece", listEspece);
        return "AfficheEspece";
    }

    @GetMapping(value= "/poisson/{id}")
    public String listeDesPoissonParEspece(@PathVariable int id, Model model){
        Espece espece=  especeDao.findById(id);
        List<Poisson> listpoisson = poissonDao.findByEspece(espece);
        listpoisson.size();
        List<Espece> listespece=  especeDao.findAll();
        model.addAttribute("listpoisson", listpoisson);
        model.addAttribute("listespece", listespece);
        return "AffichePoisson";
    }

    @PostMapping(value= "/update/{id}")
    public String updateEspece(@PathVariable int id,@RequestParam String nom,
                               @RequestParam String Description, Model model){
        Espece espece = especeDao.findById(id);
        espece.setDescription(Description);
        espece.setNom(nom);
        especeDao.save(espece);
        List<Espece> listEspece=  especeDao.findAll();

        model.addAttribute("listEspece", listEspece);
        return "AfficheEspece";
    }

}

