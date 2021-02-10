/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Family;
import emergon.entity.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ugleethyn
 */
@Repository
public class FamilyRepo extends HibernateUtil<Family> implements CrudRepo<Family> {

    public List<Family> findAll() {
        return super.findAll("Family.findAll");
    }

    public Family find(int pcode) {
        return super.find(Family.class, pcode);
    }

    @Override
    public Family save(Family family) {
        return super.save(family);
    }

    @Override
    public void delete(int id) {
        super.delete(Family.class, id);
    }

    public List<Family> findAllBySalesman(int scode) {
        return super.findBySalesman("Family.findBySalesman", scode);
    }

    @Override
    public Family findById(int id) {
        return super.find(Family.class, id);
    }

}
