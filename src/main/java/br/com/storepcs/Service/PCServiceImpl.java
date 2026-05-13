package br.com.storepcs.Service;


import br.com.storepcs.dao.PCDao;
import br.com.storepcs.dto.PCDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCServiceImpl implements PCService{


    private PCDao pcDao;


    public PCServiceImpl(PCDao pcd)
    {
        this.pcDao = pcd;

    }

    @Override
    public List<PCDTO> findAll() {
        return pcDao.findAll();
    }

    @Override
    public void save(PCDTO PCDTO) {
        pcDao.save(PCDTO);
    }

    @Override
    public void deleteByID(String id) {
        pcDao.deleteByID(id);
    }

    @Override
    public void update(String id, PCDTO PCDTO) {
        pcDao.update(PCDTO, id);
    }

    @Override
    public PCDTO findyById(String id) {
        return pcDao.findByID(id);
    }
}
