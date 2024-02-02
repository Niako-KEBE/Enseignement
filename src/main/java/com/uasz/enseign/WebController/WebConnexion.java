package com.uasz.enseign.WebController;

import com.uasz.enseign.dto.Maquette.RoleDto;
import com.uasz.enseign.services.Utilisateur.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Collection;

@Slf4j
@Controller
public class WebConnexion {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Le nom de la page HTML sans l'extension
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout((jakarta.servlet.http.HttpServletRequest) request, (jakarta.servlet.http.HttpServletResponse) response, authentication);
        }
        return "redirect:/login?logout=true";
    }

    @GetMapping("/connecter")
    public String connexion(Model model, Principal principal) {
        String url = "/connecter";

        if (principal != null) {
            Collection<? extends GrantedAuthority> authorities = ((Authentication) principal).getAuthorities();

            if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_RESPONSABLE_PEDAGOGIQUE"))) {
                url = "redirect:/ResponsablePedagogique/index";
            } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ENSEIGNANT") || a.getAuthority().equals("ROLE_ETUDIANT"))) {
                url = "redirect:/home";
            } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_RESPONSABLE_ADMINISTRATIF"))) {
                url = "redirect:/responsableAdministratif/index";
            } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                url = "redirect:/admin/";
            }
        }
        return url;
    }
}
