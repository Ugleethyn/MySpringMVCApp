/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Salesman;
import emergon.repository.SalesmanRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SalesmanService {

    @Autowired
    SalesmanRepo salesmanRepo;

    public List<Salesman> getSalesmen() {
        return salesmanRepo.findAll();
    }

    public Salesman saveSalesman(Salesman salesman) {
        return salesmanRepo.save(salesman);
    }

    public void deleteSalesman(int id) {
        salesmanRepo.delete(Salesman.class, id);
    }

    public Salesman getSalesmanById(int id) {
        return salesmanRepo.find(id);
    }

    public List<String> getCities() {
        List<String> cities = new ArrayList();
        cities.add("Athens");
        cities.add("Patra");
        cities.add("Irakleio");
        cities.add("Manh");
        cities.add("Pirgos");
        cities.add("Thessaloniki");
        return cities;
    }
}
