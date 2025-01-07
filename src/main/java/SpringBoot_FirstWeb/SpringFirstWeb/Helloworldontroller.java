package SpringBoot_FirstWeb.SpringFirstWeb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class Helloworldontroller {
	

	
	@GetMapping("/hello")
	public String helloworld(Model model)  {
		
		model.addAttribute("Message", "Hello world");
		
		return "Helloworld";
	
	}
	
	@GetMapping("/style")
	public String style()  {
		
		return "add-css-js";
	
	}
	
	

    @GetMapping("/signup")
    public String signup() {
    	
        return "Signup"; 
    }
    
    
	
  /*   @GetMapping("/success")
    public String successfull() {
    	
        return "successfull"; 
    }             */
   
  
   /* @PostMapping("/signup-process")
    public String handleSignup(@ModelAttribute CreateMember signupForm, RedirectAttributes redirectAttributes) {
        // Here you can add logic to process the form data (e.g., save to the database)
        
    	System.out.println(signupForm);
    	
        redirectAttributes.addFlashAttribute("message", "You have successfully signed up. Welcome to our platform!");

        // Redirect to the success page
        return "redirect:/success";
    }                                   */
  	
   
	
	      

    @GetMapping("/signupsuccess")
    public String signupsuccess() {

        return "Signupsuccess"; 
    }

    
    @GetMapping("/signinup")
	public String signinup() {
		
	    return "NewFile";  // Returning NewFile.html view
	}

    
    

    
    @GetMapping("/homepage")
    public String showHomePage(Model model) {
    	
        model.addAttribute("welcomeMessage", "Welcome to the homepage!");
        
        return "Homepage"; 
    }
    
    
    
    @GetMapping("/aboutus")
    public String aboutus(Model model) {
    	
        model.addAttribute("welcomeMessage", "Welcome to the About Us Page");
        
        return "aboutus"; 
    }
    
    
    @GetMapping("/home")
    public String home(Model model) {
    	
        model.addAttribute("welcomeMessage", "Welcome to the home Page");
        
        return "/home"; 
    }
    
    
    @GetMapping("/updateinformation")
    public String update(Model model) {
    	
        model.addAttribute("Update", "Update information");
        
        return "updateinformation"; 
    }
    
    
	
	
 
    @GetMapping("/forgetpassword")
    public String showForgotPasswordPage() {
    	
        return "forgetpassword"; 
    }

    

    @GetMapping("/signin")
    public String signin() {
    	
        return "signin"; 
    }
    
    
    
    
    
    
    

    
    
    @PostMapping("/forgetpassword")
    public String handleForgotPassword(
    		
            @RequestParam("email") String email,
            Model model) {
        
        model.addAttribute("message", "A reset link has been sent to your email address.");

        return "forgetpassword";
    }
    
 /*
    @GetMapping("/products")
    public String products(Model model) {
    	
        // Add products to the model (you can load them from a database or service)
        // For now, we can just pass dummy products
        model.addAttribute("products", getDummyProducts());
        return "Products";  // This returns the "products.html" template
    }
    
    
    private List<Product> getDummyProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        return products;
    }                       
    */
    
 
 /*   @GetMapping("/signinsuccess")
    public ModelAndView signInSuccess(@RequestParam(name = "message", required = false, defaultValue = "You have successfully signed in.") String message) {
    	
        ModelAndView modelAndView = new ModelAndView("signin-success"); // This should match the view name
        modelAndView.addObject("message", message);
        
        return modelAndView;
    }    
    */
    
    
    @PostMapping("/signin")
    public ModelAndView signIn(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(name = "remember", defaultValue = "false") boolean remember) {

        // Add your sign-in logic here. For example:
        boolean success = authenticateUser(email, password); // Replace with your authentication logic
        
        if (success) {
        	
            return new ModelAndView("Signinsuccess");
            
        } else {
        	
            // Handle failed authentication
            return new ModelAndView("redirect:/signin?error");
        }
    }
    
    
    
    private boolean authenticateUser(String email, String password) {
    	
        return "patel9826ravi@gmail.com".equals(email) && "password".equals(password);
    }

    
    
    @GetMapping("/addtocart")
    public String addtocart() {
    	
        return "addtocart"; // This refers to src/main/resources/templates/addtocart.html
    }
    
    
    
    @GetMapping("/productdeatils")
    public String productdetails()  {
    	
        return "productdeatils";
    }
	
  
    @GetMapping("/payment")
    public String payment()   {
    	
        return "payment";
    }
 
    @GetMapping("/invoice")
    
    public String invoice()   {	
        return "invoice";
    }
    
    
@GetMapping("/paymentdeatils")
    
    public String paymentdeatils()   { 
    
       return "paymentdeatils";
    }


        @GetMapping("/profile")
         public String profile()  {
        	 
        	 return "profile";
         }


        @GetMapping("/knowmore")
        public String knowmore()  {
       	 
       	 return "knowmore";
        }


        @GetMapping("/address")
        public String address()  {
       	 
       	 return "Address";
        }
   
        
        @GetMapping("/resetpassword")
        public String resetpassword()  {
       	 
       	 return "resetpassword";
        }

        private static final String UPLOAD_DIR = "uploads/";

        @PostMapping("/product/{productId}/upload/image")
        public ResponseEntity<String> uploadImage(@PathVariable Long productId, @RequestParam("image") MultipartFile file) {
            
            if (file.isEmpty()) {
                return new ResponseEntity<>("Please select an image file to upload." + "   For ID: " + productId, HttpStatus.BAD_REQUEST);
            }

            try {
                // Get the file's original name
                String fileName = file.getOriginalFilename();

                // Ensure the upload directory exists
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();  // Create the directory if it doesn't exist
                }

                // Save the file to the specified directory
                Path filePath = Paths.get(UPLOAD_DIR + fileName);
                Files.write(filePath, file.getBytes());

                // Return success response
                return new ResponseEntity<>("Image uploaded successfully: " + fileName + "   For ID: " + productId, HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>("Failed to upload the image. " + "   For ID: " + productId + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


/*
           
//Inject ProductserviceIMPL using @Autowired
private ProductserviceIMPL service;  // Ensure this is correctly named and injected

@PostMapping("/send")
public ResponseEntity<?> sendVerificationCode(@RequestParam String phoneNumber) {
    if (phoneNumber == null || phoneNumber.isEmpty()) {
        return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Required parameter 'phoneNumber' is not present."));
    }
    
    String code = service.sendVerificationCode(phoneNumber);  // Call service to send verification code
    return ResponseEntity.ok(Collections.singletonMap("message", "Verification code sent to " + phoneNumber));
}

@PostMapping("/verify")
public ResponseEntity<?> verifyCode(@RequestParam String phoneNumber, @RequestParam String code) {
    boolean isValid = service.verifyCode(phoneNumber, code);  // Call service to verify the code
    if (isValid) {
        return ResponseEntity.ok(Collections.singletonMap("message", "Phone number verified successfully!"));
    } else {
        return ResponseEntity.status(400).body(Collections.singletonMap("message", "Invalid verification code."));
    }
}
            */


















    
}
