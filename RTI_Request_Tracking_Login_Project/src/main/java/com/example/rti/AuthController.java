package com.example.rti;
import java.util.Map; import jakarta.servlet.http.*; import jakarta.validation.Valid; import jakarta.validation.constraints.*;
import org.springframework.http.*; import org.springframework.security.authentication.*; import org.springframework.security.core.*; import org.springframework.security.core.context.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.context.SecurityContextRepository; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final AppUserRepository users; private final PasswordEncoder encoder; private final AuthenticationManager manager; private final SecurityContextRepository repo;
 public AuthController(AppUserRepository u,PasswordEncoder e,AuthenticationManager m,SecurityContextRepository r){users=u;encoder=e;manager=m;repo=r;}
 public record RegisterData(@NotBlank @Size(max=150) String fullName,@Email @NotBlank @Size(max=150) String email,@NotBlank @Size(min=8,max=72) String password){}
 public record LoginData(@Email @NotBlank String email,@NotBlank String password){}
 @PostMapping("/register") public ResponseEntity<?> register(@Valid @RequestBody RegisterData d){
 String email=d.email().trim().toLowerCase(); if(users.existsByEmailIgnoreCase(email))return ResponseEntity.badRequest().body(Map.of("error","Email already registered."));
 AppUser u=new AppUser();u.setFullName(d.fullName().trim());u.setEmail(email);u.setPassword(encoder.encode(d.password()));u.setRole("CITIZEN");users.save(u);
 return ResponseEntity.status(201).body(Map.of("message","Registration successful. Please log in."));
 }
 @PostMapping("/login") public ResponseEntity<?> login(@Valid @RequestBody LoginData d,HttpServletRequest req,HttpServletResponse res){
 try{Authentication au=manager.authenticate(new UsernamePasswordAuthenticationToken(d.email().trim().toLowerCase(),d.password()));SecurityContext c=SecurityContextHolder.createEmptyContext();c.setAuthentication(au);SecurityContextHolder.setContext(c);req.getSession(true);repo.saveContext(c,req,res);
 String role=au.getAuthorities().stream().anyMatch(x->x.getAuthority().equals("ROLE_OFFICER"))?"OFFICER":"CITIZEN";return ResponseEntity.ok(Map.of("role",role,"email",au.getName()));
 }catch(Exception e){SecurityContextHolder.clearContext();return ResponseEntity.status(401).body(Map.of("error","Invalid email or password."));}}
 @GetMapping("/me") public ResponseEntity<?> me(Authentication au){if(au==null)return ResponseEntity.status(401).body(Map.of("error","Please log in."));AppUser u=users.findByEmailIgnoreCase(au.getName()).orElseThrow();return ResponseEntity.ok(Map.of("fullName",u.getFullName(),"email",u.getEmail(),"role",u.getRole()));}
}