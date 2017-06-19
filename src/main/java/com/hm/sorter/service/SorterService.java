package com.hm.sorter.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.hm.sorter.dto.SortedNumbers;
import com.hm.sorter.repository.SorterRepository;

@Service
public class SorterService {

	@Autowired
	SorterRepository numbersRepository;
	
	public void sortNumbers(final List<Integer> numbers) {
		QuickSort sorter = new QuickSort();
		sorter.sort(Ints.toArray(numbers));
		numbersRepository.save(new SortedNumbers(StringUtils.join(numbers, ','), 
				StringUtils.join(sorter.getSortedList(), ','), 
				sorter.getNoOfPermutations(),
				sorter.getExecutionTimeInMs() ));
	}
	
	public List<SortedNumbers> getAllEntries() {
		return Lists.newArrayList(numbersRepository.findAll());
	}
}
