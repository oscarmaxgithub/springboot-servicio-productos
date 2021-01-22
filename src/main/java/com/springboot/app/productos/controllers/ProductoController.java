package com.springboot.app.productos.controllers;

import com.springboot.app.productos.models.entity.Producto;
import com.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private IProductoService objProductService;

    //SIRVEN PARA LO MISMO PERO DECLARADO DE DIFERENTES MANERAS
            @Autowired
            private Environment objEnv;

            @Value("${server.port}")
            private Integer PORT;
    //SIRVEN PARA LO MISMO PERO DECLARADO DE DIFERENTES MANERAS

    @GetMapping("/listar")
    public List<Producto> listar(){

        return objProductService.findAll().stream().map(prod->{
//            prod.setPort(Integer.parseInt(objEnv.getProperty("local.server.port")));// para sacar el puerto de application.properties "local"+ el nombre de variable de entorno en properties
            prod.setPort(PORT);// para sacar el puerto de application.properties "local"+ el nombre de variable de entorno en properties
            return prod;
        }).collect(Collectors.toList());
    }

    @GetMapping("/detalle/{id}")
    public Producto detalle(@PathVariable Long id) throws Exception {
        Producto prod= objProductService.findById(id);
//        prod.setPort(Integer.parseInt(objEnv.getProperty("local.server.port")));// para sacar el puerto de application.properties "local"+ el nombre de variable de entorno en properties
        prod.setPort(PORT);// para sacar el puerto de application.properties "local"+ el nombre de variable de entorno en properties

        //PARA PROBAR HYSTRIX PARA TOLERANCIA A FALLOS
//        if (false==false){
//            throw new Exception("No se pduo cargar el producto");
//        }
        return prod;
    }

}
