package com.newcapec.entity;

public class ResultData<T> {

	private int total;
	private T rows;
	private String code;

	public ResultData() {
		super();
	}

	public ResultData(int total, T rows, String code) {
		super();
		this.total = total;
		this.rows = rows;
		this.code = code;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResultData [total=" + total + ", rows=" + rows + ", code=" + code + "]";
	}

}