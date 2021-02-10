/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ugleethyn
 */
@Repository
public class SalesmanRepo extends HibernateUtil<Salesman> implements CrudRepo<Salesman> {

    public List<Salesman> findAll() {
        return super.findAll("Salesman.findAll");
    }

    public Salesman find(int pcode) {
        return super.find(Salesman.class, pcode);
    }

    @Override
    public Salesman save(Salesman salesman) {
        return super.save(salesman);
    }

    @Override
    public void delete(int id) {
        super.delete(Salesman.class, id);
    }

    @Override
    public Salesman findById(int id) {
        return super.find(Salesman.class, id);
    }

}
