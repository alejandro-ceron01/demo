package co.edu.uceva.demo.model.service;

import co.edu.uceva.demo.model.dao.IEstudianteDao;
import co.edu.uceva.demo.model.entities.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Service
public class EstudianteServiceImpl implements IEstudianteService{


    @Autowired
    private IEstudianteDao estudianteDao;


    @Override
    public List<Estudiante> listar() {
        return (List<Estudiante>)estudianteDao.findAll();

    }

    @Override
    public Estudiante findById(Long id) {
        return null;
    }


}
