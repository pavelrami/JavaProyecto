/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.swing.JOptionPane; 
/**
 *
 * @author carlos
 */
public class ClienteDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO clientes (rfc,nombre,telefono,direccion )VALUES (?,?,?,?)";
        try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, cl.getRfc());
        ps.setString(2, cl.getNombre());
        ps.setInt(3, cl.getTelefono());
        ps.setString(4, cl.getDireccion());
        ps.execute();
        return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    public List ListarCliente(){
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
            cl.setId(rs.getInt("id"));
                cl.setRfc(rs.getInt("rfc"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                ListaCl.add(cl);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    public boolean eliminarCliente(int id){
        String sql = "DELETE  FROM clientes WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.toString());
            }
        }
    }
       public boolean ModificarCliente(Cliente cl){
       String sql = "UPDATE clientes SET rfc=?, nombre=?, telefono=?, direccion=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setInt(1, cl.getRfc());
           ps.setString(2, cl.getNombre());
           ps.setInt(3, cl.getTelefono());
           ps.setString(4, cl.getDireccion());
           ps.setInt(5, cl.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
       public Cliente Buscarcliente(int rfc){
       Cliente cl = new Cliente();
       String sql = "SELECT * FROM clientes WHERE rfc = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, rfc);
           rs = ps.executeQuery();
           if (rs.next()) {
               cl.setId(rs.getInt("id"));
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getInt("telefono"));
               cl.setDireccion(rs.getString("direccion"));
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cl;
   }
        
}
