package com.springboot.app.productos.models.service.Implementation;

import com.springboot.app.productos.models.entity.Producto;
import com.springboot.app.productos.models.repository.ProductoRepository;
import com.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository objDaoOrRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {

        return (List<Producto>) objDaoOrRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {

        return objDaoOrRepository.findById(id).orElse(null);
    }
}
