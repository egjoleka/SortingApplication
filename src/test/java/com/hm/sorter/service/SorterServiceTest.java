package com.hm.sorter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.hm.sorter.dto.SortedNumbers;
import com.hm.sorter.repository.SorterRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SorterServiceTest {

	private List<Integer> listToBeSorted = Arrays.asList(111,10,5,6,23);
	private String sortedList = "5,6,10,23,111";
	
    @MockBean
	SorterRepository sorterRepository;
	
	@Autowired
	SorterService sorterService;
	
	@Test
	public void sortListSuccessTest() {
		ArgumentCaptor<SortedNumbers> sorterCaptor = ArgumentCaptor.forClass(SortedNumbers.class);

		sorterService.sortNumbers(listToBeSorted);

		Mockito.verify(sorterRepository, Mockito.times(1)).save(sorterCaptor.capture());

		assertNotNull(sorterCaptor.getValue().getCreationDate());
		assertNotNull(sorterCaptor.getValue().getSortingTimeInMilliseconds());
		assertEquals(sortedList, sorterCaptor.getValue().getSortedNumbers());
		assertEquals(new Integer(4), sorterCaptor.getValue().getNumberOfSwaps());
		assertEquals(StringUtils.join(listToBeSorted, ","),sorterCaptor.getValue().getUnsorterdNumbers());

	}
	
	@Test
	public void sortListSuccessSingleValueTest() {
		ArgumentCaptor<SortedNumbers> sorterCaptor = ArgumentCaptor.forClass(SortedNumbers.class);

		sorterService.sortNumbers(Arrays.asList(1));

		Mockito.verify(sorterRepository, Mockito.times(1)).save(sorterCaptor.capture());

		assertNotNull(sorterCaptor.getValue().getCreationDate());
		assertNotNull(sorterCaptor.getValue().getSortingTimeInMilliseconds());
		assertEquals("1", sorterCaptor.getValue().getSortedNumbers());
		assertEquals(new Integer(1), sorterCaptor.getValue().getNumberOfSwaps());
		assertEquals("1",sorterCaptor.getValue().getUnsorterdNumbers());

	}
	
	@Test
	public void sortListSuccessNoValueTest() {
		ArgumentCaptor<SortedNumbers> sorterCaptor = ArgumentCaptor.forClass(SortedNumbers.class);

		sorterService.sortNumbers(new ArrayList<>());

		Mockito.verify(sorterRepository, Mockito.times(1)).save(sorterCaptor.capture());

		assertNotNull(sorterCaptor.getValue().getCreationDate());
		assertNotNull(sorterCaptor.getValue().getSortingTimeInMilliseconds());
		assertEquals("", sorterCaptor.getValue().getSortedNumbers());
		assertEquals(new Integer(0), sorterCaptor.getValue().getNumberOfSwaps());
		assertEquals("",sorterCaptor.getValue().getUnsorterdNumbers());

	}
	
	@Test
	public void sortListSuccessNegativeValueTest() {
		ArgumentCaptor<SortedNumbers> sorterCaptor = ArgumentCaptor.forClass(SortedNumbers.class);

		sorterService.sortNumbers(Arrays.asList(100,-1));

		Mockito.verify(sorterRepository, Mockito.times(1)).save(sorterCaptor.capture());

		assertNotNull(sorterCaptor.getValue().getCreationDate());
		assertNotNull(sorterCaptor.getValue().getSortingTimeInMilliseconds());
		assertEquals("-1,100", sorterCaptor.getValue().getSortedNumbers());
		assertEquals(new Integer(1), sorterCaptor.getValue().getNumberOfSwaps());
		assertEquals("100,-1",sorterCaptor.getValue().getUnsorterdNumbers());

	}
	
	
	
}
