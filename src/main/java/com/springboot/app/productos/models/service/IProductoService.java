package com.springboot.app.productos.models.service;

import com.springboot.app.productos.models.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
}
