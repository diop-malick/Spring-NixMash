package com.nixmash.springdata.jpa.repository;

import com.nixmash.springdata.jpa.model.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by daveburke on 5/31/16.
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findByPostId(Long postId) throws DataAccessException;

    @Query("select distinct p from Post p left join fetch p.tags t")
    List<Post> findAllWithDetail();

    Post findByPostNameIgnoreCase(String postName) throws DataAccessException;

    @Query("select distinct p from Post p left join p.tags t where t.tagId = ?1")
    Page<Post> findByTagId(long tagId, Pageable pageable);

    @Query("select distinct p from Post p left join p.tags t where t.tagId = ?1")
    List<Post> findAllByTagId(long tagId);

    List<Post> findAll(Sort sort);
}
