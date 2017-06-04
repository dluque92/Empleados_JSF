/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.DepartamentoFacade;
import ejb.EmpleadoFacade;
import ejb.PuestoFacade;
import entity.Departamento;
import entity.Empleado;
import entity.Puesto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "empleadosModificarBean")
@RequestScoped
public class EmpleadosModificarBean {

    @EJB
    private PuestoFacade puestoFacade;

    @EJB
    private DepartamentoFacade departamentoFacade;

    @EJB
    private EmpleadoFacade empleadoFacade;
    
    

    @Inject
    EmpleadosBean session;
    
    private String puesto;
    private Empleado empleadoActual;
    private List<Empleado> listaEmpleados;
    private String nombreDepartamento;
    private Collection<Puesto> listaPuestos;

    /**
     * Creates a new instance of EmpleadosModificarBean
     */
    public EmpleadosModificarBean() {
    }
    
    @PostConstruct
    public void init(){
        this.empleadoActual = session.getEmpleadoSeleccionado();
        this.listaEmpleados = session.getListaEmpleados();
        this.nombreDepartamento = session.getDepartamentoSeleccionado();
    }
    
     public Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
    public String addPuesto() throws ParseException{
        
        Puesto p = new Puesto(this.empleadoActual.getEmpNo(), session.getPuesto(), new Date());
        p.setFechaHasta(new SimpleDateFormat("YYYY-MM-dd").parse("9999-01-01"));
        puestoFacade.create(p);
        this.listaPuestos = session.getListaPuestosSelected();
        this.listaPuestos.add(p);
        session.setListaPuestosSelected(this.listaPuestos);
        //this.empleadoActual = empleadoFacade.find(this.empleadoActual.getEmpNo());
       // session.setEmpleadoSeleccionado(empleadoActual);
        //session.setListaPuestosSelected(empleadoActual.getPuestoCollection());
        return "editarEmpleado";
    }
    
    public String editarEmpleado(Empleado empleado){
        this.empleadoActual = empleado;
        session.setEmpleadoSeleccionado(empleadoActual);
        this.nombreDepartamento = session.nombreDepartamento(empleadoActual);
        session.setDepartamentoSeleccionado(this.nombreDepartamento);
        this.listaPuestos = empleadoActual.getPuestoCollection();
        session.setListaPuestosSelected(listaPuestos);
        return "editarEmpleado";
    }
    
    public String guardar(){
        Departamento departamento = departamentoFacade.find(session.obtenerEmpleoActual(empleadoActual).getDeptEmpPK().getDeptNo());
        departamento.setNombre(nombreDepartamento);
        departamentoFacade.edit(departamento);
        this.empleadoFacade.edit(empleadoActual);
        this.listaEmpleados = empleadoFacade.findAll();
        session.setListaEmpleados(listaEmpleados);
        return "listaEmpleados";
    }
    
}
