package pe.edu.savbackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.dao.CursoDao;
import pe.edu.savbackend.domain.Curso;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoDao cursoDao;
    
    @RequestMapping("/")
    public List<Curso> getAll() {
    	System.out.println("Ingreso a getaLL");
    	System.out.println(cursoDao.findAll());
        return cursoDao.findAll();
    }
    
    @RequestMapping("/{id}")
    public  Curso getById(@PathVariable("id")Integer id) {
    	System.out.println("Ingreso a get" + id);
    	Curso c = cursoDao.getOne(id);
    	System.out.println("curso= " + c);
        return c;
    }
    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso register(@RequestBody Curso er) {
    	
    	System.out.println("Ingreso a post " + er);
    	System.out.println(cursoDao.findAll());
        return cursoDao.save(er);
    }
    
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public Curso update(@RequestBody Curso er) {
	  	      return cursoDao.save(er);
	  }
    
    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void delete(@RequestParam Integer id) {
	  	      cursoDao.deleteById(id);
	  }
}