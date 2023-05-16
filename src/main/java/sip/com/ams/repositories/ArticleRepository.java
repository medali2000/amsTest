package sip.com.ams.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sip.com.ams.entites.Article;


@Repository

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
