package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;
import com.amplesoftech.dress2impressbackend.dto.DebitCardDetails;

public interface DebitCardDetailsDAO {

	List<DebitCardDetails> list();
	DebitCardDetails get(int id);
	boolean add(DebitCardDetails debitCardDetails);
	boolean delete(DebitCardDetails debitCardDetails);
}
