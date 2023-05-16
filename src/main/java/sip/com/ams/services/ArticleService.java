package sip.com.ams.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sip.com.ams.entites.Article;
import sip.com.ams.entites.provider;
import sip.com.ams.repositories.ArticleRepository;
import sip.com.ams.repositories.providerRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository ;

    @Autowired
    providerRepository providerRepository ;

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

   public Article createArticle( Long providerId, Article article) {
        return providerRepository.findById(providerId).map(provider -> {
            article.setProvider(provider);
            return articleRepository.save(article);
        }).orElseThrow(() -> new IllegalArgumentException("ProviderId " + providerId + " not found"));
    }

    public Article updateArticle(Long providerId, Long articleId, Article articleRequest) {
        if(!providerRepository.existsById(providerId)) {
            throw new IllegalArgumentException("ProviderId " + providerId + " not found");
        }

        return articleRepository.findById(articleId).map(article -> {
            article.setPrice(articleRequest.getPrice());
            article.setLabel(articleRequest.getLabel());
            article.setPicture(articleRequest.getPicture());
            return articleRepository.save(article);
        }).orElseThrow(() -> new IllegalArgumentException("ArticleId " + articleId + "not found"));
    }

    public Article deleteArticle(Long articleId) {

        Article temp=null ;
        Optional<Article> opt = articleRepository.findById(articleId);
        if(opt.isPresent())
        {
            temp= opt.get();
            articleRepository.delete(temp);
            return temp ;
        }
        if(temp==null) throw  new IllegalArgumentException("article with id = "+articleId+" not found");
        return temp;
    }


}
