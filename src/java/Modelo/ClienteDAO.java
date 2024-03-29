package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int rta;
    
    public Cliente validar(String user, String dni){
        Cliente cl=new Cliente();
        String sql="select * from cliete where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                cl.setId(rs.getInt("IdCliente"));
                cl.setNombres(rs.getString("Dni"));
                cl.setNombres(rs.getString("Nombres"));
                cl.setNombres(rs.getString("Direccion"));
                cl.setNombres(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return cl;
    }
    
    //Operaciones CRUD
    
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Cliente cl=new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Cliente cl){
        String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombres());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return rta;
    }
    public Cliente listarId(int id){
        Cliente cl=new Cliente();
        String sql="select * from cliete where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                cl.setDni(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return cl;
    }
    public int editar(Cliente cl){
        String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombres());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getEstado());
            ps.setInt(6, cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return rta;
    }
    public void eliminar(int id){
        String sql="delete from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
