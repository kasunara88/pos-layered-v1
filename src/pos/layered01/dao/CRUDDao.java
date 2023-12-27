/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dao;

import java.util.ArrayList;

/**
 *
 * @author kasun
 */
public interface CRUDDao<T, ID> extends SuperDAO {

    boolean add(T t);

    boolean update(T t);

    boolean delete(ID id);

    T get(ID id);

    ArrayList<T> getAll();

}
