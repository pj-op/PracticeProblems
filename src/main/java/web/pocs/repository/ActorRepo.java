package web.pocs.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import web.pocs.beans.model.Actor;

import java.util.List;

public interface ActorRepo extends PagingAndSortingRepository<Actor, Integer> {
    @Query("select count(a.id) from Actor a")
    int totalRec();

    @Query("select a from Actor a")
    List<Actor> findAllActors(Pageable pageable);

    @Query(value = "select a1_0.actor_id,a1_0.first_name,a1_0.last_name,a1_0.last_update from Actor a1_0 limit :pageSize, :offSet", nativeQuery = true)
    List<Actor> findActorByOffSet(@Param("pageSize") int pageSize, @Param("offSet") int offset);

    @Query("select a from Actor a where a.id between :pageSize and :offset")
    List<Actor> findActorByOffSetBetween(@Param("pageSize") int pageSize, @Param("offset") int offset);

}
