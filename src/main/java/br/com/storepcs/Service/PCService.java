package br.com.storepcs.Service;


import br.com.storepcs.dto.PCDTO;

import java.util.List;

public interface PCService {

  List<PCDTO> findAll();

  void save(PCDTO PCDTO);

  void deleteByID(String id);

  void update(String id, PCDTO PCDTO);

  PCDTO findyById(String id);


}
