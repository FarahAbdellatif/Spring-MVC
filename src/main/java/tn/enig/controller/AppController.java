package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IDepartementDao;
import tn.enig.dao.IEmployeDao;
import tn.enig.dao.IProjetDao;
import tn.enig.model.Departement;
import tn.enig.model.Employe;
import tn.enig.model.Projet;

@Controller
public class AppController {
	
	@Autowired
	IDepartementDao daod;
	@Autowired
	IEmployeDao daoe;
	@Autowired
	IProjetDao daop;
	
	public void setDaod(IDepartementDao daod) {
		this.daod=daod;
	}
	
	
	public void setDaoe(IEmployeDao daod) {
		this.daoe=daoe;
	}
	
	public void setDaoe(IProjetDao daop) {
		this.daop=daop;
	}

	@GetMapping("/home")
	public String get1(Model m) {
		List<Departement> listedep=daod.findAll();
		m.addAttribute("listedep", listedep);
		return "home";
	}
	
	@GetMapping("/projet/{id}")
	public String get2 (Model m,@PathVariable("id") int id)  {
		List<Projet> listeproj=daop.getAllProjetByDep(id);
		m.addAttribute("listep", listeproj);
		return "projets";}
	
	
	@GetMapping("/employes/dep/{id}")
	public String get3 (Model m,@PathVariable("id") int id)  {
		List<Employe> listeemp=daoe.getAllEmplyeByDep(id);
		m.addAttribute("listeemp", listeemp);
		return "employes";}
	
	@GetMapping("/employe/proj/{id}")
	public String get4 (Model m,@PathVariable("id") int id)  {
		List<Employe> listeemp=daoe.getAllEmplyeByProj(id);
		m.addAttribute("listeemp", listeemp);
		return "employesproj";}
	
	@GetMapping("/ajoutprojet")
	public String get5(Model m) {
		Projet p = new Projet();
		List<Departement> listdep=daod.findAll();
		m.addAttribute("p", p);
		m.addAttribute("listdep", listdep);
		
		return "ajoutproj";
	}
	@PostMapping("/saveProjet")
	public String get6(Model m,@ModelAttribute("p") Projet p) {
		daop.save(p);
		return "redirect:/home";
		
	}
	
	
	@GetMapping("/ajoutemploye")
	public String get7(Model m) {
		Employe e =new Employe();
		List<Departement> listdep=daod.findAll();
		List<Projet> listproj=daop.findAll();
		m.addAttribute("e", e);
		m.addAttribute("listdep", listdep);
		m.addAttribute("listproj", listproj);
		return "ajoutemp";
	}
	@PostMapping("/saveemploye")
	public String get8(Model m,@ModelAttribute("e") Employe e) {
		daoe.save(e);
		return "redirect:/home";
		
	}
	
	
}