package it.danielrrapi.U5W3D1.repositories;

import it.danielrrapi.U5W3D1.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Long> {
}
