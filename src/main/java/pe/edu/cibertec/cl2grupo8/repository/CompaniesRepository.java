package pe.edu.cibertec.cl2grupo8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.cl2grupo8.model.bd.Companies;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Integer> {
}
