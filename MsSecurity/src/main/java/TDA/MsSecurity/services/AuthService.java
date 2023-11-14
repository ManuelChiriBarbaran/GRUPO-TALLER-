package TDA.MsSecurity.services;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import TDA.MsSecurity.model.modelUsuario;
import TDA.MsSecurity.repository.IAuthRepository;
 
@Service
public class AuthService {

    @Autowired
    private IAuthRepository authRepository;

    public List<modelUsuario> getAllUsers() {
        return (List<modelUsuario>) authRepository.findAll();
    }
    
    public modelUsuario getUserById(int idUsuario) {
        return authRepository.findById(idUsuario).orElse(null);
        }

        public modelUsuario createUser(modelUsuario nuevoUsuario) {
            // Puedes realizar validaciones u operaciones adicionales aquí si es necesario
            return authRepository.save(nuevoUsuario);
        }
  
    }


