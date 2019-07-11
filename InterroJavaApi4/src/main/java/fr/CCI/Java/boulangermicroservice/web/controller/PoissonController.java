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

import fr.CCI.Java.boulangermicroservice.dao.ProduitDAO;
import fr.CCI.Java.boulangermicroservice.model.Produit;

@Controller
@RequestMapping(path = "/poisson")
public class PoissonController {
    @Autowired
    private EspeceDao especeDao;
    @Autowired
    private PoissonDao poissonDao;
    @PostMapping(value= "/update/{id}")
    public String updatePoisson(@PathVariable int id,@RequestParam String nom,
                               @RequestParam String image,@RequestParam int especeId , Model model){

        Espece espece = especeDao.findById(especeId);
        Poisson poisson= poissonDao.findById(id);
        poisson.setNom(nom);
        poisson.setImg(image);
        poisson.setEspece(espece);
        poissonDao.save(poisson);
        List<Espece> listEspece=  especeDao.findAll();
        model.addAttribute("listEspece", listEspece);
        return "AfficheEspece";
    }
    @GetMapping(value= "/formAjout")
    public String formAjoutPoisson( Model model){

        List<Espece>listespece = especeDao.findAll();
        model.addAttribute("listespece", listespece);
        return "AjoutPoisson";
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String AddPoisson(@RequestParam String nom,
                                @RequestParam String image,@RequestParam int especeId , Model model){
        Espece espece = especeDao.findById(especeId);
        Poisson poisson =new Poisson(nom,espece,image);
        poisson.setNom(nom);
        poisson.setImg(image);
        poisson.setEspece(espece);
        poissonDao.save(poisson);
        return "Saved";
    }
    @GetMapping(value= "/delete/{id}")
    public @ResponseBody
    String supprimerPoisson(@PathVariable int id, Model model){
        Poisson poisson = poissonDao.findById(id);
        poissonDao.delete(poisson);
        return "Poisson detruit";
    }



}
