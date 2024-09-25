package com.semicolon.data.repositories;

import com.semicolon.data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository  extends JpaRepository<Item, Long> {

}
