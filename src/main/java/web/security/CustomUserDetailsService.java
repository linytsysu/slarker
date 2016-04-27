package web.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import web.models.User;
import web.repositories.*;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepoitory) {
        this.userRepository = userRepository;
        this.userRoleRepository= userRoleRepoitory;
    }
    
        
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRoles=userRoleRepository.findRoleByUserName(username);
            return new CustomUserDetails(user,userRoles);
        }
    }
        
}
