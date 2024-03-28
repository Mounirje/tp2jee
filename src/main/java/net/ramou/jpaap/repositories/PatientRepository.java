package net.ramou.jpaap.repositories;

import net.ramou.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByMalade(boolean m);
   Page<Patient> findByMalade(boolean m, PageRequest pageable);
   List<Patient> findByMaladeAndAndScoreLessThan(boolean m , int s);
   List<Patient> findByMaladeIsTrueAndAndScoreLessThan(int score);
   @Query("select p from Patient p where p.nom like :x and p.score<:y")
   List<Patient> chercherPatient(@Param("x") String nom,@Param("y") int scoremin);
}
