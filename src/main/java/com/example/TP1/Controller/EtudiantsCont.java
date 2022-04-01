package com.example.TP1.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TP1.DAO.EtudiantsR;
import com.example.TP1.entities.Departement;
import com.example.TP1.entities.Etudiants;

@RestController
@RequestMapping(value = "/etudiants")
public class EtudiantsCont {

	@Autowired
	private EtudiantsR ET;

	@GetMapping("/etudiant/{id}")
	public Etudiants get(@PathVariable Long id) {
		return ET.findById(id).get();
	}

	@GetMapping("/allE")
	public List<Etudiants> Afficher() {
		return ET.findAll();
	}

	@PostMapping("/addE")
	public Etudiants Etudiants(@RequestBody Etudiants E) {
		return ET.save(E);
	}

	@PostMapping("/update")
	public Etudiants updateEtudiants(@RequestBody Etudiants E) {
		return ET.save(E);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteEtudiant(@PathVariable Long id) {
		ET.deleteById(id);
	}

	@GetMapping("/Q1")
	public List<Etudiants> Q1() {
		return ET.findByDateASC();
	}

	@GetMapping("/Q2/{n1}/{n2}")
	public List<Etudiants> Q2(@PathVariable String n1, @PathVariable String n2) {
		return ET.findByNomeContainingAndNomeContaining(n1, n2);
	}

	@GetMapping("/Q7")
	public Collection<Object> Q7() {
		return ET.NBDept();

	}

	@GetMapping("/Q8")
	public Collection<Departement> Q8() {
		return ET.MoinsDept(ET.MoinsDept1());

	}

	@GetMapping("/Q9")
	public Collection<Object> Q9() {
		return ET.NivSp();

	}

	@GetMapping("/Q10")
	public Collection<Integer> Q10() {
		return ET.Niveauplus(ET.PlusN());

	}

	@GetMapping("/Q11")
	public Collection<Departement> Q11() {
		return ET.PlusDept(ET.PlusDept1());

	}

	@GetMapping("/Q13")
	public Collection<Object> Q13() {
		return ET.DMoyenne();

	}

	@GetMapping("/Q14")
	public Collection<Object> Q14() {
		return ET.Mmoyenne(ET.MaxDept());

	}

}
