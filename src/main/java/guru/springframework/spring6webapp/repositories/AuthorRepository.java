package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository gives us basic methods to persist & work with entities.  like save, findbyID, findAll, delete etc.

//with this the spring data JPA is gonig to provide us the implementation(At run time ), We Do Not provide the implementation.
//We just create teh repository thats it.

//This will be detected as a Spring data JPA.


@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {


}
