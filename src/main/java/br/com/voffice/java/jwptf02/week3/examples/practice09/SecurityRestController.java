package br.com.voffice.java.jwptf02.week3.examples.practice09;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {

	@GetMapping("/security/public")
	public String getPublic() {
		return "public";
	}

	@GetMapping("/security/protected")
	public String getProtected(Principal principal) {
		return "protected: "+principal.getName();
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/security/admin")
	public String getAdmin(Principal principal) {
		return "has role admin: "+principal.getName();
	}

}
