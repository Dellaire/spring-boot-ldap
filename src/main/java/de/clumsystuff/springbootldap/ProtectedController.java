package de.clumsystuff.springbootldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedController {

	@GetMapping("/data")
	public String getProdectedData() {
		
		return "If you see this, you are authenticated.";
	}
}
