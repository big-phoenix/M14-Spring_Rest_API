package com.white.collar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.white.collar.model.Tienda;

public interface ITiendaDAO extends JpaRepository<Tienda, Integer> {

}
