package sip.com.ams.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sip.com.ams.entites.provider;
import sip.com.ams.repositories.providerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    providerRepository providerRepository;

   public List<provider> getAllProviders(){
        return providerRepository.findAll();
    }

   public provider getOneProviderById(Long idProvider){
        return providerRepository.findById(idProvider).orElseThrow(()->new IllegalArgumentException());
    }

  public  provider saveProvider(provider provider){
        return providerRepository.save(provider);
    }

   public provider deleteProvider(long idProvider)
    {
        provider temp = null ;
        Optional<provider> opt = providerRepository.findById(idProvider);
        if(opt.isPresent())
        {
            temp= opt.get();
            providerRepository.delete(temp);
            return temp;
        }
        if(temp==null) throw new IllegalArgumentException("provider with id = " + idProvider+ " not found");
        return temp;
    }

    public provider updateProvider(long idProvider , provider provider){
        provider temp = null ;
        Optional<provider> opt = providerRepository.findById(idProvider);
        if(opt.isPresent())
        {
            temp= opt.get();
            temp.setName(provider.getName());
            temp.setAddress(provider.getAddress());
            temp.setEmail(provider.getEmail());
            providerRepository.save(provider);
            return temp;
        }
        if(temp==null) throw new IllegalArgumentException("provider with id = " + idProvider+ " not found");
        return temp;
    }

}
