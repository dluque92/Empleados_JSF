/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.DepartamentoFacade;
import ejb.DeptEmpFacade;
import ejb.DeptManagerFacade;
import ejb.EmpleadoFacade;
import ejb.PuestoFacade;
import ejb.SueldoFacade;
import entity.Departamento;
import entity.DeptEmp;
import entity.DeptManager;
import entity.Empleado;
import entity.Puesto;
import entity.Sueldo;
import entity.SueldoPK;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author david
 */
@Named(value = "empleadosBean")
@SessionScoped
public class EmpleadosBean implements Serializable {

    @EJB
    private PuestoFacade puestoFacade;

    @EJB
    private SueldoFacade sueldoFacade;

    @EJB
    private DeptManagerFacade deptManagerFacade;

    @EJB
    private DepartamentoFacade departamentoFacade;

    @EJB
    private DeptEmpFacade deptEmpFacade;

    @EJB
    private EmpleadoFacade empleadoFacade;
    
    private String puesto;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    private Empleado empleadoSeleccionado;
    private String departamentoSeleccionado;
    private Collection<Puesto> listaPuestosSelected;

    public Collection<Puesto> getListaPuestosSelected() {
        return listaPuestosSelected;
    }

    public void setListaPuestosSelected(Collection<Puesto> listaPuestosSelected) {
        this.listaPuestosSelected = listaPuestosSelected;
    }

    public String getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(String departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }
    private List<Empleado> listaEmpleados;
    private List<Departamento> listaDepartamentos;

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    /**
     * Creates a new instance of EmpleadosBean
     */
    public EmpleadosBean() {
    }
    
    @PostConstruct
    public void init(){
        this.listaEmpleados = empleadoFacade.findAll();
        this.listaDepartamentos = departamentoFacade.findAll();
    }
    
    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }
    
    public DeptEmp obtenerEmpleoActual(Empleado empleado){
        DeptEmp depAct = null;
        for(DeptEmp depEmp: empleado.getDeptEmpCollection()){
            if(depAct == null){
                depAct = depEmp;
            }else{
                if(depEmp.getFechaHasta().after(depAct.getFechaHasta())){
                    depAct = depEmp;
                }
            }
        }
        return depAct;
    }
    
    public String nombreDepartamento(Empleado empleado){
        DeptEmp depAct = obtenerEmpleoActual(empleado);
        Departamento dep = departamentoFacade.find(depAct.getDepartamento().getDeptNo());
        return dep.getNombre();
    }
    
    public int getSueldo(Empleado empleado){
        DeptEmp depAct = obtenerEmpleoActual(empleado);
        Date fechaDesde = depAct.getFechaDesde();
        SueldoPK sueldoPK = new SueldoPK(depAct.getDeptEmpPK().getEmpNo(), fechaDesde);
        int salario = 0;
        for(Sueldo sueldo : empleado.getSueldoCollection()){
            if(sueldo.getSueldoPK().equals(sueldoPK)){
                salario = sueldo.getCantidad();
            }
        }
        return salario;
    }
    
    public String getPuesto(Empleado empleado){
        DeptEmp depAct = obtenerEmpleoActual(empleado);
        Date fechaDesde = depAct.getFechaDesde();
        String puestoActual = "";
        for(Puesto puesto : empleado.getPuestoCollection()){
            if(puesto.getPuestoPK().getFechaDesde().equals(fechaDesde) && puesto.getPuestoPK().getEmpNo() == empleado.getEmpNo() ){
                puestoActual = puesto.getPuestoPK().getDenominacion();
            }
        }
        return puestoActual;
    }
    
    public String borrar(Empleado empleado){
        borrarDep(empleado);
        borrarDepManager(empleado);
        borrarPuesto(empleado);
        borrarSueldo(empleado);
        this.empleadoFacade.remove(empleado);
        this.listaEmpleados.remove(empleado);
        return "listaEmpleados";
    }

    private void borrarDep(Empleado empleado) {
        for(DeptEmp dep : empleado.getDeptEmpCollection()){
            deptEmpFacade.remove(dep);
        }
    }

    private void borrarDepManager(Empleado empleado) {
        for(DeptManager depMan : empleado.getDeptManagerCollection()){
            deptManagerFacade.remove(depMan);
        }
    }

    private void borrarPuesto(Empleado empleado) {
        for(Puesto puesto : empleado.getPuestoCollection()){
            puestoFacade.remove(puesto);
        }
    }

    private void borrarSueldo(Empleado empleado) {
        for(Sueldo sueldo : empleado.getSueldoCollection()){
            sueldoFacade.remove(sueldo);
        }
    }
    
}
