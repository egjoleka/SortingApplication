package com.hm.sorter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hm.sorter.dto.SortedNumbers;

@Repository
public interface SorterRepository extends CrudRepository<SortedNumbers, Integer> {

}
