/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DeptManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class DeptManagerFacade extends AbstractFacade<DeptManager> {

    @PersistenceContext(unitName = "JSF-Empleados-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeptManagerFacade() {
        super(DeptManager.class);
    }
    
}
