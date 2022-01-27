package br.com.bamt.organize.model.repository;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByDataDaCompra(LocalDate data);
}
