package co.edu.uceva.demo.controller;

import co.edu.uceva.demo.model.entities.Estudiante;
import co.edu.uceva.demo.model.service.IEstudianteService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/estudianteservice")

public class EstudianteRestController {

    @Autowired
    IEstudianteService estudianteService;

    @GetMapping("/estudiantes")
    //public List<Estudiante>listar(){
    public ResponseEntity<?> listar(){
        Map<String,Object> reponse = new HashMap<>();
        return (ResponseEntity<?>) estudianteService.listar();
    }

    @GetMapping("/estudiantes/{id}")
    //public Estudiante buscar(@PathVariable Long id){
    public ResponseEntity<?> buscar(@PathVariable Long id){
        Map<String,Object> response=new HashMap<>();
        Estudiante estudiante = null;
        try {
             estudiante = estudianteService.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje","error consultando los datos");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if (estudiante == null){
            response.put("mensaje", "El estudiante no existe");
            return new ResponseEntity<Map<String, Object>>(reponse,HttpStatus.NOT_FOUND)
        }
        return new ResponseEntity<Estudiante>(estudiante,HttpStatus.OK);

    }

}
