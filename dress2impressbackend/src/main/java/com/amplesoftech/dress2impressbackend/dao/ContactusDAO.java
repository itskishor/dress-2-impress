package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;
import com.amplesoftech.dress2impressbackend.dto.Contactus;

public interface ContactusDAO {

	List<Contactus> list();
	Contactus get(int id);
	boolean add(Contactus contactus);
	boolean delete(Contactus contactus);
	boolean update(Contactus contactus);

}
