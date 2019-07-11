package fr.CCI.Java.boulangermicroservice.web.controller;
import java.util.List;

import fr.CCI.Java.boulangermicroservice.dao.EspeceDao;
import fr.CCI.Java.boulangermicroservice.model.Espece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.CCI.Java.boulangermicroservice.dao.ProduitDAO;
import fr.CCI.Java.boulangermicroservice.model.Produit;

@Controller
@RequestMapping(path = "/espece")
public class EspeceController {
    @Autowired
    private EspeceDao especeDao;

    @GetMapping(value= "/all")
    public String listeDesEspeces( Model model){
        List<Espece> listEspece=  especeDao.findAll();

        model.addAttribute("listEspece", listEspece);
        return "AfficheEspece";


    }

    @GetMapping(value= "/{id}")
    public Espece especeParID(@PathVariable int id, Model model) {
        return especeDao.findById(id);
    }
}
