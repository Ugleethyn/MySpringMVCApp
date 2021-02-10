/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.repository.FamilyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ugleethyn
 */
@Transactional
@Service
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepo;

    public List<Family> getFamily() {
        return familyRepo.findAll();
    }
    
    public List<Family> getFamilyBySalesman(int salesman){
        return familyRepo.findAllBySalesman(salesman);
    }

    public Family saveFamily(Family family) {
        return familyRepo.save(family);
    }
        public void deleteFamily(int id) {
        familyRepo.delete(Family.class, id);
    }

    public Family getFamilyById(int id) {
        return familyRepo.find(id);
    }
}
