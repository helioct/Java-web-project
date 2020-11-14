package com.deloitte.controller;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.exception.ResourceNotFoundException;
import com.deloitte.exception.UserNotFoundException;
import com.deloitte.logic.InfoUsuario;
import com.deloitte.logic.InfoUsuarioManager;
import com.deloitte.logic.LoginUser;
import com.deloitte.model.Usuario;
import com.deloitte.model.repository.UsuarioRepository;


@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@GetMapping("/usuario")
//	public List <Usuario> getAllEmployees() {
//        return usuarioRepository.findAll();
//    }
//	
	
//	@GetMapping("/usuario/{idUsers}")
//	public ResponseEntity<Usuario> getUsuariosID(@PathVariable(value = "idUsers") Integer usuarioID) throws ResourceNotFoundException {
//
//		
//		Usuario usuario = usuarioRepository.findById(usuarioID)
//				.orElseThrow(() -> new ResourceNotFoundException("Usuario "+ usuarioID + " does not exists!!!!"));
//		
//		return ResponseEntity.ok().body(usuario);
//	}
//	
//	
	
	
	@GetMapping("/infoUsuario/{mail}")
	public ResponseEntity<InfoUsuario> getUsuarioByMail(@PathVariable(value = "mail") String mail) throws ResourceNotFoundException, UserNotFoundException {

		
		Usuario usuario = usuarioRepository.findByMail(mail);
		
		if(usuario==null)  
			//runtime exception  
			throw new UserNotFoundException("mail: "+ mail);
		
		InfoUsuario  inf = new InfoUsuario();
		inf.setName(usuario.getName());
		inf.setLastname(usuario.getLastName());
		inf.setMail(usuario.getMail());
		inf.setMonedero(usuario.getMonedero());
		
		return ResponseEntity.ok().body(inf);
	}
	
	@GetMapping("/infoUsuarioManager/{mail}")
	public ResponseEntity<InfoUsuarioManager> getUsuarioByMailManager(@PathVariable(value = "mail") String mail) throws ResourceNotFoundException, UserNotFoundException {

		
		Usuario usuario = usuarioRepository.findByMail(mail);
		
		if(usuario==null)  
			//runtime exception  
			throw new UserNotFoundException("mail: "+ mail);
		
		InfoUsuarioManager  inf = new InfoUsuarioManager();
		inf.setId_usuarios(usuario.getId_usuario());
		inf.setName(usuario.getName());
		inf.setLastname(usuario.getLastName());
		inf.setMail(usuario.getMail());
		inf.setMonedero(usuario.getMonedero());
		inf.setUsuario_tipo(usuario.getTipo());
		
		return ResponseEntity.ok().body(inf);
	}
	
	@GetMapping("/usuariosManager")
	public List <InfoUsuarioManager> getAllUsuariosManager() {
		List<Usuario> usList = new LinkedList<Usuario>();
		usList=usuarioRepository.findAll();
		
		List<InfoUsuarioManager> usListManager = new LinkedList<InfoUsuarioManager>();
		
		
		
		for(Usuario usuario: usList) {
			InfoUsuarioManager inf = new InfoUsuarioManager();
			inf.setId_usuarios(usuario.getId_usuario());
			inf.setName(usuario.getName());
			inf.setLastname(usuario.getLastName());
			inf.setMail(usuario.getMail());
			inf.setMonedero(usuario.getMonedero());
			inf.setUsuario_tipo(usuario.getTipo());
			usListManager.add(inf);
		}
        return usListManager;
    }
	
	
	@PostMapping("/signIn")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
	
	
	@PostMapping("/login")
    public  Map < String, Boolean >loginUser(@Valid @RequestBody LoginUser usuario) throws UserNotFoundException {
		
		
		Usuario registerUsuario = usuarioRepository.findByMail(usuario.getMail());
		if(usuario==null  || !usuario.getPassword().equals(registerUsuario.getPassword()))  {
			throw new UserNotFoundException("INVALID CREDENTIALS");
		}
		Map < String, Boolean > response = new HashMap < > ();
	    response.put("LogInComplete", Boolean.TRUE);
	    return response;
    }
	
	
	
	
	@PutMapping("/usuario/{idUsers}")
    public ResponseEntity < Usuario > updateUsuario(@PathVariable(value = "idUsers") Integer usuarioId,
        @Valid @RequestBody Usuario employeeDetails) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + usuarioId));


        usuario.setName(employeeDetails.getName());
        usuario.setLastName(employeeDetails.getLastName());
        usuario.setMail(employeeDetails.getMail());
        usuario.setMonedero(employeeDetails.getMonedero());
        usuario.setPassword(employeeDetails.getPassword());
        usuario.setTipo(employeeDetails.getTipo());;;
        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }
	
	@DeleteMapping("/usuario/{idUsers}")
    public Map < String, Boolean > deleteUsuario(@PathVariable(value = "idUsers") Integer usuarioId)
    throws ResourceNotFoundException {
       Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + usuarioId));

        usuarioRepository.delete(usuario);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
}