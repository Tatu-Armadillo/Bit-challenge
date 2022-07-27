package br.com.challenge.bit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.challenge.bit.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT item FROM Item item "
            + " WHERE item.date BETWEEN :begindate AND :finaldate"
            + " ORDER BY item.code ")
    List<Item> findByDate(@Param("begindate") Date begindate, @Param("finaldate") Date finaldate);

}
