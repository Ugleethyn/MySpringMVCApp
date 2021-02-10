/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import java.util.List;

/**
 *
 * @author Ugleethyn
 */
public interface CrudRepo<E> {

    public E save(E e);

    public void delete(int id);

    public E findById(int id);

    public List<E> findAll();

}
