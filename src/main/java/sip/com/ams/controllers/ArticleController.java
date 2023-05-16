package sip.com.ams.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sip.com.ams.entites.Article;
import sip.com.ams.repositories.ArticleRepository;
import sip.com.ams.repositories.providerRepository;
import sip.com.ams.services.ArticleService;

import java.util.List;


import javax.validation.Valid;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/articles")

public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public List<Article> getAllArticles() {
      return articleService.getAllArticles();
    }

    @PostMapping("/{providerId}")
    Article createArticle(@PathVariable (value = "providerId") Long providerId,
                          @Valid @RequestBody Article article) {
       return articleService.createArticle(providerId,article);
    }

    @PutMapping("/{providerId}/{articleId}")
    public Article updateArticle(@PathVariable (value = "providerId") Long providerId,
                                 @PathVariable (value = "articleId") Long articleId,
                                 @Valid @RequestBody Article articleRequest) {
        return articleService.updateArticle(providerId,articleId,articleRequest);
    }

    @DeleteMapping("/{articleId}")
    public Article deleteArticle(@PathVariable (value = "articleId") Long articleId) {
       return articleService.deleteArticle(articleId);
    }
}
