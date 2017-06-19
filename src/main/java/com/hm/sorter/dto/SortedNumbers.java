package com.hm.sorter.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SortedNumbers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String unsorterdNumbers;
	@Column
	private String sortedNumbers;
	@Column
	private Integer numberOfSwaps;
	@Column
	private long sortingTimeInMilliseconds;
	@Column
	private Date creationDate;
	
	public SortedNumbers() {

	}
	public SortedNumbers(String unsorterdNumbers, String sortedNumbers, Integer numberOfSwaps,
			long sortingTimeInMilliseconds) {
		this.unsorterdNumbers = unsorterdNumbers;
		this.sortedNumbers = sortedNumbers;
		this.numberOfSwaps = numberOfSwaps;
		this.sortingTimeInMilliseconds = sortingTimeInMilliseconds;
		this.creationDate=new Date();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnsorterdNumbers() {
		return unsorterdNumbers;
	}
	public void setUnsorterdNumbers(String unsorterdNumbers) {
		this.unsorterdNumbers = unsorterdNumbers;
	}
	public String getSortedNumbers() {
		return sortedNumbers;
	}
	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}
	public Integer getNumberOfSwaps() {
		return numberOfSwaps;
	}
	public void setNumberOfSwaps(Integer numberOfSwaps) {
		this.numberOfSwaps = numberOfSwaps;
	}
	public long getSortingTimeInMilliseconds() {
		return sortingTimeInMilliseconds;
	}
	public void setSortingTimeInMilliseconds(long sortingTimeInMilliseconds) {
		this.sortingTimeInMilliseconds = sortingTimeInMilliseconds;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
}
