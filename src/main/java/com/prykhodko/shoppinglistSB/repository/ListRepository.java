/////////////////////////////////////////////////////////////////
// The repository created in order to access List's            //
// data from the database.                                     //
//                                                             //
////////////////////////////////////////////////////////////////

package com.prykhodko.shoppinglistSB.repository;

import com.prykhodko.shoppinglistSB.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation tells Spring to bootstrap the repository during component scan
/**
 * JpaRepository is an interface which defines methods for all the CRUD operations on the entity.
 * JpaRepository has methods like save(), findOne(), findAll(), count(), delete().
 * Methods are already implemented by Spring Data JPA’s SimpleJpaRepository
 * This implementation is plugged in by Spring automatically at runtime.
 */
public interface ListRepository extends JpaRepository<List, Long> {

}
