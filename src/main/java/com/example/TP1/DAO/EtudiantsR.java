package com.example.TP1.DAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.TP1.entities.Departement;
import com.example.TP1.entities.Etudiants;

@RepositoryRestResource
public interface EtudiantsR extends JpaRepository<Etudiants, Long> {
	
	
	@RestResource(path = "/Q1")
	@Query(value = "select e from Etudiants e order by e.dateE ASC ")
	List<Etudiants> findByDateASC();

	@RestResource(path = "/Q2")
	List<Etudiants> findByNomeContainingAndNomeContaining(@PathParam("n1") String n1, @PathParam("n2") String n2);

	@RestResource(path = "/Q3")
	@Query("select e.dt from Etudiants e where e.dateE = (select min(e.dateE) from Etudiants e)")
	List<Departement> Date_entreMIn1();

	@RestResource(path = "/Q4")
	@Query("select Avg(e.moyenne) from Etudiants e ")
	Double MoyenneE();

	@RestResource(path = "/Q5")
	@Query("select e from Etudiants e where e.moyenne in (select max(t.moyenne) from Etudiants t where e.dt=t.dt  group by t.dt)")
	Collection<Etudiants> MoyenneEByDEpt();

	@RestResource(path = "/Q6")
	@Query("select e from Etudiants e where e.moyenne = (select max(t.moyenne) from Etudiants t)")
	Collection<Etudiants> MMoyenne();

	@RestResource(path = "/Q7")
	@Query("select e.dt.nom_dept, count(e) from Etudiants e group by e.dt")
	Collection<Object> NBDept();

	// Q8
	@Query("select d from Departement d, Etudiants e where d.ID_department = e.dt.ID_department group by d.ID_department having count(e) =:X")
	Collection<Departement> MoinsDept(@Param("X") Long X);

	@Query(value = "select min(c) from (select count(dept) c from Etudiants group by dept) as T", nativeQuery = true)
	Long MoinsDept1();

	@RestResource(path = "/Q9")
	@Query("select e.Niveau from Etudiants e group by e.st.Id_sepacialite")
	Collection<Object> NivSp();

	// Q10
	@Query("select e.Niveau from Etudiants e group by e.Niveau having count(e) =:X")
	Collection<Integer> Niveauplus(@Param("X") Long x);

	@Query(value = "select max(c) from (select count(IdE) c from Etudiants group by Niveau) as T", nativeQuery = true)
	Long PlusN();

	// Q11
	@Query("select d from Departement d, Etudiants e where d.ID_department = e.dt.ID_department group by d.ID_department having count(e) =:X")
	Collection<Departement> PlusDept(@Param("X") Long X);

	@Query(value = "select max(c) from (select count(dept) c from Etudiants group by dept) as T", nativeQuery = true)
	Long PlusDept1();

	// Q12
	@RestResource(path = "/Q12")
	@Query("select e.dt.nom_dept from Etudiants e where IdE is null ")
	Collection<Object> AucunEtu();

	@RestResource(path = "/Q13")
	@Query("select distinct e.dt.nom_dept from Etudiants e where e.moyenne =(select max (t.moyenne) from Etudiants t)")
	Collection<Object> DMoyenne();

	// Q14
	@Query("select e.dt from Etudiants e group by e.dt having Avg (e.moyenne) =:X")
	Collection<Object> Mmoyenne(@Param("X") Double X);

	@Query(value = "select MAX(c) from (select AVG(moyenne) c from Etudiants group by dept) as T", nativeQuery = true)
	Double MaxDept();

	// Q15
	@RestResource(path = "/Q15")
	@Query("select e.dt from Etudiants e group by e.dt having Avg (e.moyenne) >:X")
	Collection<Object> MoyEtu();

	@Query(value = "select AVG(c) from (select AVG (moyenne) c from Etudiants group by dept) as T", nativeQuery = true)
	Double MoyEtu1();

}
