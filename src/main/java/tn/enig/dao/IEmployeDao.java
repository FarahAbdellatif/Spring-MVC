package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enig.model.Employe;

@Repository
public interface IEmployeDao extends JpaRepository<Employe, Integer>{
	@Query("select e from Employe e where e.dep.id=?1")
	public List<Employe> getAllEmplyeByDep(int id);
	@Query("select e from Employe e where e.proj.id=?1")
	public List<Employe> getAllEmplyeByProj(int id);

}