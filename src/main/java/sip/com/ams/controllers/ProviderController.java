package sip.com.ams.controllers;
import java.util.List;
import java.util.Optional;

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

import sip.com.ams.entites.provider;
import sip.com.ams.repositories.providerRepository;
import sip.com.ams.services.ProviderService;

@RestController
@RequestMapping({"/providers"})
@CrossOrigin(origins="*")

public class ProviderController {
    @Autowired
    private providerRepository providerRepository;

    @Autowired
    ProviderService providerService ;

    @GetMapping("/")
    public List<provider> getAllProviders() {
        //return (List<provider>) providerRepository.findAll();
        return providerService.getAllProviders();
    }

    @PostMapping("/")
    public provider createProvider(@Valid @RequestBody provider provider) {
        return providerService.saveProvider(provider);
    }

    @PutMapping("/{providerId}")
    public provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody provider providerRequest) {
      return providerService.updateProvider(providerId,providerRequest);
    }


    @DeleteMapping("/{providerId}")
    public provider deleteProvider(@PathVariable Long providerId) {
       return providerService.deleteProvider(providerId);
    }

    @GetMapping("/{providerId}")
    public provider getProvider(@PathVariable Long providerId) {
        return providerService.getOneProviderById(providerId);

    }
}